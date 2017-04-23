package mikes.dept.yandextranslate.screen.main;

import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 23.4.17.
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
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

    @Override
    public void onClickTranslate() {
        mView.navigateTranslate();
    }

    @Override
    public void onClickFavorites() {
        mView.navigateFavorites();
    }

    @Override
    public void onClickSettings() {
        mView.navigateSettings();
    }

}
