package mikes.dept.yandextranslate.repository;

import android.support.annotation.NonNull;

import java.util.List;

import mikes.dept.yandextranslate.model.content.Language;
import rx.Observable;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface YandexTranslateRepository {

    Observable<List<Language>> getLanguages(@NonNull String ui);

    Observable<String> translate(@NonNull String language, @NonNull String text);

}
