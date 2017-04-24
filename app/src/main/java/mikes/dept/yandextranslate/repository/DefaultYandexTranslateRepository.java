package mikes.dept.yandextranslate.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

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
                    return Observable.just(languages);
                })
                .onErrorResumeNext(Observable::error);
    }

    @Override
    public Observable<String> translate(@NonNull String languageSource, @NonNull String languageTarget, @NonNull String text) {
        String language = languageSource + "-" + languageTarget;
        return Observable.just(0)
                .flatMap(integer -> {
                    History history = Realm.getDefaultInstance().where(History.class)
                            .equalTo(History.FIELD_SOURCE, text)
                            .equalTo(History.FIELD_LANGUAGE, language)
                            .findFirst();
                    if(history != null) {
                        return Observable.just(history.getTextTarget());
                    }
                    else {
                        return ApiFactory.getYandexTranslateService()
                                .translate(language, text)
                                .flatMap(translateResponse -> {
                                    String translateResultText = getTranslateResultText(translateResponse);
                                    saveResult(text, translateResultText, language);
                                    return Observable.just(translateResultText);
                                });
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

    private String getTranslateResultText(TranslateResponse translateResponse) {
        String translateResultText = "";
        for(String translate : translateResponse.getText()) {
            translateResultText += translate;
        }
        return translateResultText;
    }

    private void saveResult(String textSource, String textTarget, String language) {
        Realm.getDefaultInstance().executeTransaction(realm -> realm.insert(new History(textSource, textTarget, language)));
    }

}
