package mikes.dept.yandextranslate.screen.languages.adapter;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.model.content.Language;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface LanguagesOnItemClickListener {

    void onClickLanguage(@NonNull Language language);

}
