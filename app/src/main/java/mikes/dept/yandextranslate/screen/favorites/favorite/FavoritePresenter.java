package mikes.dept.yandextranslate.screen.favorites.favorite;

import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 24.4.17.
 */

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View mView;

    public FavoritePresenter(@NonNull FavoriteContract.View view) {
        mView = view;
    }

    @Override
    public void loadData() {
        //TODO: loadData
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

}
