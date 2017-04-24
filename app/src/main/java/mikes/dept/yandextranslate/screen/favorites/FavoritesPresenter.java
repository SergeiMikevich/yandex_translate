package mikes.dept.yandextranslate.screen.favorites;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    @Override
    public void onClickDeleteHistory() {
        mView.showDialog();
    }

    @Override
    public void onClickDeleteHistoryConfirmed() {
        RepositoryProvider.provideYandexTranslateRepository()
                .deleteHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isOk -> mView.refreshFavorites(), throwable -> mView.showMessage(R.string.error));
    }

}
