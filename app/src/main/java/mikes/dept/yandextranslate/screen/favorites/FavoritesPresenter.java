package mikes.dept.yandextranslate.screen.favorites;

import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 23.4.17.
 */

public class FavoritesPresenter implements FavoritesContract.Presenter {

    private final FavoritesContract.View mView;

    public FavoritesPresenter(@NonNull FavoritesContract.View view) {
        mView = view;
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

}
