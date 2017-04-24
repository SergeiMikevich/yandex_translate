package mikes.dept.yandextranslate.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import io.realm.Realm;
import io.realm.RealmResults;
import mikes.dept.yandextranslate.api.ApiFactory;
import mikes.dept.yandextranslate.model.content.History;
import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.model.response.LanguagesResponseContent;
import mikes.dept.yandextranslate.model.response.TranslateResponse;
import rx.Observable;

/**
 * Created by mikesdept on 23.4.17.
 */

public class DefaultYandexTranslateRepository implements YandexTranslateRepository {

    @Override
    public Observable<List<Language>> getLanguages(@NonNull String ui) {
        return ApiFactory.getYandexTranslateService()
                .getLanguages(ui)
                .flatMap(languagesResponse -> {
                    LanguagesResponseContent languagesResponseContent = languagesResponse.getLanguagesResponseContent();
                    List<Language> languages = new ArrayList<>();
                    languages.add(new Language(languagesResponseContent.getEnglishCode(), languagesResponseContent.getEnglishTitle()));
                    languages.add(new Language(languagesResponseContent.getGermanCode(), languagesResponseContent.getGermanTitle()));
                    languages.add(new Language(languagesResponseContent.getRussianCode(), languagesResponseContent.getRussianTitle()));
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        realm.delete(Language.class);
                        realm.insert(languages);
                    });
                    return Observable.just(languages);
                })
                .onErrorResumeNext(throwable -> {
                    Realm realm = Realm.getDefaultInstance();
                    RealmResults<Language> languageRealmResults = realm.where(Language.class).findAll();
                    if(languageRealmResults.size() > 0) {
                        return Observable.just(realm.copyFromRealm(languageRealmResults));
                    }else {
                        return Observable.error(new NoSuchElementException());
                    }
                });
    }

    @Override
    public Observable<History> translate(@NonNull String languageSource, @NonNull String languageTarget, @NonNull String text) {
        String language = languageSource + "-" + languageTarget;
        return Observable.just(0)
                .flatMap(integer -> {
                    History history = Realm.getDefaultInstance().where(History.class)
                            .equalTo(History.FIELD_SOURCE, text)
                            .equalTo(History.FIELD_LANGUAGE, language)
                            .findFirst();
                    if(history != null) {
                        History historyResult = new History(history.isFavorite(), history.getTextSource(), history.getTextTarget(), history.getLanguage());
                        return Observable.just(historyResult);
                    }
                    else {
                        return ApiFactory.getYandexTranslateService()
                                .translate(language, text)
                                .flatMap(translateResponse -> Observable.just(saveResult(text, getTranslateResultText(translateResponse), language)));
                    }
                })
                .onErrorResumeNext(Observable::error);
    }

    @Override
    public Observable<List<History>> loadHistory() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<History> historyResults = realm.where(History.class).findAll();
        return Observable.just(realm.copyFromRealm(historyResults));
    }

    @Override
    public Observable<Boolean> updateHistory(@NonNull History history) {
        return Observable.just(0)
                .flatMap(integer -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        History historyForUpdate = realm.where(History.class)
                                .equalTo(History.FIELD_SOURCE, history.getTextSource())
                                .equalTo(History.FIELD_LANGUAGE, history.getLanguage())
                                .findFirst();
                        historyForUpdate.setFavorite(true);
                        realm.insertOrUpdate(historyForUpdate);
                    });
                    return Observable.just(true);
                })
                .onErrorResumeNext(Observable::error);
    }

    @Override
    public Observable<Boolean> deleteHistory() {
        return Observable.just(0)
                .flatMap(integer -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> realm.delete(History.class));
                    return Observable.just(true);
                })
                .onErrorResumeNext(Observable::error);
    }

    private String getTranslateResultText(TranslateResponse translateResponse) {
        String translateResultText = "";
        for(String translate : translateResponse.getText()) {
            translateResultText += translate;
        }
        return translateResultText;
    }

    private History saveResult(String textSource, String textTarget, String language) {
        History history = new History(textSource, textTarget, language);
        Realm.getDefaultInstance().executeTransaction(realm -> realm.insert(history));
        return history;
    }

}
