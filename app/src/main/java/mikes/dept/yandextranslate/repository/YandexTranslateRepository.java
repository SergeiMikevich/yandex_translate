package mikes.dept.yandextranslate.repository;

import android.support.annotation.NonNull;

import java.util.List;

import mikes.dept.yandextranslate.model.content.History;
import mikes.dept.yandextranslate.model.content.Language;
import rx.Observable;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface YandexTranslateRepository {

    Observable<List<Language>> getLanguages(@NonNull String ui);

    Observable<History> translate(@NonNull String languageSource, @NonNull String languageTarget, @NonNull String text);

    Observable<List<History>> loadHistory();

    Observable<Boolean> updateHistory(@NonNull History history);

}
