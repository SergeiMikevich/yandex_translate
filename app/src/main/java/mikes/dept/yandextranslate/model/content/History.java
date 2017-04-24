package mikes.dept.yandextranslate.model.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import io.realm.RealmObject;

/**
 * Created by mikesdept on 24.4.17.
 */

public class History extends RealmObject implements Parcelable {

    public static final String FIELD_SOURCE = "mTextSource";
    public static final String FIELD_LANGUAGE = "mLanguage";

    private Boolean mIsFavorite;
    private String mTextSource;
    private String mTextTarget;
    private String mLanguage;

    public History() {

    }

    public History(Boolean isFavorite, String textSource, String textTarget, String language) {
        mIsFavorite = isFavorite;
        mTextSource = textSource;
        mTextTarget = textTarget;
        mLanguage = language;
    }

    public History(String textSource, String textTarget, String language) {
        mIsFavorite = false;
        mTextSource = textSource;
        mTextTarget = textTarget;
        mLanguage = language;
    }

    protected History(Parcel in) {
        mIsFavorite = in.readInt() == 1;
        mTextSource = in.readString();
        mTextTarget = in.readString();
        mLanguage = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public Boolean isFavorite() {
        return mIsFavorite;
    }

    public void setFavorite(@NonNull Boolean isFavorite) {
        mIsFavorite = isFavorite;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIsFavorite ? 1 : 0);
        dest.writeString(mTextSource);
        dest.writeString(mTextTarget);
        dest.writeString(mLanguage);
    }
}
