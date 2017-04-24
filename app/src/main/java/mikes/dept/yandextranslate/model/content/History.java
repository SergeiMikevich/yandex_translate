package mikes.dept.yandextranslate.model.content;

import io.realm.RealmObject;

/**
 * Created by mikesdept on 24.4.17.
 */

public class History extends RealmObject {

    public static final String FIELD_SOURCE = "mTextSource";
    public static final String FIELD_LANGUAGE = "mLanguage";

    private Boolean mIsFavorite;
    private String mTextSource;
    private String mTextTarget;
    private String mLanguage;

    public History() {

    }

    public History(String textSource, String textTarget, String language) {
        mIsFavorite = false;
        mTextSource = textSource;
        mTextTarget = textTarget;
        mLanguage = language;
    }

    public Boolean isFavorite() {
        return mIsFavorite;
    }

    public String getTextSource() {
        return mTextSource;
    }

    public String getTextTarget() {
        return mTextTarget;
    }

    public String getLanguage() {
        return mLanguage;
    }

}
