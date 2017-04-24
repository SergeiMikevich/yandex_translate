package mikes.dept.yandextranslate.screen.favorites.history;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import mikes.dept.yandextranslate.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        RepositoryProvider.provideYandexTranslateRepository()
                .loadHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mView::showHistory, throwable -> mView.showHistory(new ArrayList<>()));
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

}
