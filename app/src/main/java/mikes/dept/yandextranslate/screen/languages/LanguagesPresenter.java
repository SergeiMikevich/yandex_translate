package mikes.dept.yandextranslate.screen.languages;

import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesPresenter implements LanguagesContract.Presenter {

    private final LanguagesContract.View mView;

    public LanguagesPresenter(@NonNull LanguagesContract.View view) {
        mView = view;
    }

    @Override
    public void onCreate() {
        mView.init();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

}
