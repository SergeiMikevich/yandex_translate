package mikes.dept.yandextranslate.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesResponseContent {

    @SerializedName("en")
    private String mEnglish;

    @SerializedName("de")
    private String mGerman;

    @SerializedName("ru")
    private String mRussian;

    public String getEnglishCode() {
        return "en";
    }

    public String getEnglishTitle() {
        return  mEnglish;
    }

    public String getGermanCode() {
        return "de";
    }

    public String getGermanTitle() {
        return  mGerman;
    }

    public String getRussianCode() {
        return "ru";
    }

    public String getRussianTitle() {
        return  mRussian;
    }

}
