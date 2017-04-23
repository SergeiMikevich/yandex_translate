package mikes.dept.yandextranslate.api;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.model.response.LanguagesResponse;
import mikes.dept.yandextranslate.model.response.TranslateResponse;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface YandexTranslateService {

    @POST("tr.json/getLangs")
    Observable<LanguagesResponse> getLanguages(@Query("ui") @NonNull String ui);

    @POST("tr.json/translate")
    Observable<TranslateResponse> translate(@Query("lang") @NonNull String lang, @Query("text") @NonNull String text);

}
