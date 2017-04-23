package mikes.dept.yandextranslate.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mikesdept on 23.4.17.
 */

public class TranslateResponse {

    @SerializedName("code")
    private Integer mCode;

    @SerializedName("lang")
    private String mLanguage;

    @SerializedName("text")
    private List<String> mText;

    @NonNull
    public Integer getCode() {
        return mCode;
    }

    @NonNull
    public String getLanguage() {
        return mLanguage;
    }

    @NonNull
    public List<String> getText() {
        return mText;
    }

}
