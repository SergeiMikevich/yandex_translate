package mikes.dept.yandextranslate.screen.languages;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import mikes.dept.yandextranslate.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    @Override
    public void loadLanguages(@NonNull String ui) {
        RepositoryProvider.provideYandexTranslateRepository()
                .getLanguages(ui)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(mView::showLoadingIndicator)
                .doOnTerminate(mView::hideLoadingIndicator)
                .subscribe(mView::showLanguages, throwable -> mView.showLanguages(new ArrayList<>()));
    }

}
