package mikes.dept.yandextranslate.screen.translate;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.screen.favorites.FavoritesContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public class TranslatePresenter implements TranslateContract.Presenter {

    private final TranslateContract.View mView;

    public TranslatePresenter(@NonNull TranslateContract.View view) {
        mView = view;
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

}
