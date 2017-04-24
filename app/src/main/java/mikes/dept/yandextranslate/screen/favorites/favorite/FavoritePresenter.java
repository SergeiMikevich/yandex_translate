package mikes.dept.yandextranslate.screen.favorites.favorite;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import mikes.dept.yandextranslate.model.content.History;
import mikes.dept.yandextranslate.repository.RepositoryProvider;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        RepositoryProvider.provideYandexTranslateRepository()
                .loadHistory()
                .flatMap(Observable::from)
                .filter(History::isFavorite)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mView::showHistory, throwable -> mView.showHistory(new ArrayList<>()));
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

}
