package mikes.dept.yandextranslate.screen.translate;

import android.support.annotation.NonNull;

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

    @Override
    public void onClickLanguagesSource() {
        mView.navigateLanguages();
    }

    @Override
    public void onClickLanguageTarget() {
        mView.navigateLanguages();
    }

    @Override
    public void onClickReplaceLanguages() {
        mView.navigateLanguages();
    }
}
