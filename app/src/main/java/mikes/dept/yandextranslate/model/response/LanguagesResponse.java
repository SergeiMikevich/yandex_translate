package mikes.dept.yandextranslate.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesResponse {

    @SerializedName("langs")
    private LanguagesResponseContent mLanguagesResponseContent;

    public LanguagesResponseContent getLanguagesResponseContent() {
        return mLanguagesResponseContent;
    }

}
