package mikes.dept.yandextranslate.screen.favorites.history;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.screen.favorites.favorite.FavoriteContract;

/**
 * Created by mikesdept on 24.4.17.
 */

public class HistoryPresenter implements HistoryContract.Presenter {

    private final HistoryContract.View mView;

    public HistoryPresenter(@NonNull HistoryContract.View view) {
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
