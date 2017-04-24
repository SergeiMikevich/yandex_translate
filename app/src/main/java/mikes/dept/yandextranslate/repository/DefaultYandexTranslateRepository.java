package mikes.dept.yandextranslate.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import mikes.dept.yandextranslate.api.ApiFactory;
import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.model.response.LanguagesResponseContent;
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
        return ApiFactory.getYandexTranslateService()
                .translate(languageSource + "-" + languageTarget, text)
                .flatMap(translateResponse -> {
                    String translateResult = "";
                    for(String translate : translateResponse.getText()) {
                        translateResult += translate;
                    }
                    return Observable.just(translateResult);
                })
                .onErrorResumeNext(Observable::error);
    }

}
