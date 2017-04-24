package mikes.dept.yandextranslate.model.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import io.realm.RealmObject;

/**
 * Created by mikesdept on 23.4.17.
 */

public class Language extends RealmObject implements Parcelable {

    private String mCode;
    private String mTitle;

    public Language() {

    }

    public Language(@NonNull String code, @NonNull String title) {
        mCode = code;
        mTitle = title;
    }

    protected Language(Parcel in) {
        mCode = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<Language> CREATOR = new Creator<Language>() {
        @Override
        public Language createFromParcel(Parcel in) {
            return new Language(in);
        }

        @Override
        public Language[] newArray(int size) {
            return new Language[size];
        }
    };

    @NonNull
    public String getCode() {
        return mCode;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    public Boolean equals(Language language) {
        return language != null && this.getCode().equals(language.getCode()) && this.getTitle().equals(language.getTitle());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCode);
        dest.writeString(mTitle);
    }
}
