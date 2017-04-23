package mikes.dept.yandextranslate.model.content;

import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 23.4.17.
 */

public class Language {

    private String mCode;
    private String mTitle;

    public Language(@NonNull String code, @NonNull String title) {
        mCode = code;
        mTitle = title;
    }

    @NonNull
    public String getCode() {
        return mCode;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }

}
