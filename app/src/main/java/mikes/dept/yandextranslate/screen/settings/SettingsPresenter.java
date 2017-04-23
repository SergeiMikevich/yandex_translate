package mikes.dept.yandextranslate.screen.settings;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.screen.favorites.FavoritesContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public class SettingsPresenter implements SettingsContract.Presenter {

    private final SettingsContract.View mView;

    public SettingsPresenter(@NonNull SettingsContract.View view) {
        mView = view;
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

}
