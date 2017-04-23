package mikes.dept.yandextranslate.screen.translate;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.model.content.Language;

/**
 * Created by mikesdept on 23.4.17.
 */

public class TranslatePresenter implements TranslateContract.Presenter {

    private final TranslateContract.View mView;

    private int mSelectSourceMode;
    private final int SELECT_SOURCE_MODE = 0;
    private final int SELECT_TARGET_MODE = 1;

    private Language mLanguageSource;
    private Language mLanguageTarget;

    public TranslatePresenter(@NonNull TranslateContract.View view) {
        mView = view;
    }

    @Override
    public void onCreateView() {
        mView.init();
    }

    @Override
    public void onClickLanguagesSource() {
        mSelectSourceMode = SELECT_SOURCE_MODE;
        mView.navigateLanguages();
    }

    @Override
    public void onClickLanguageTarget() {
        mSelectSourceMode = SELECT_TARGET_MODE;
        mView.navigateLanguages();
    }

    @Override
    public void onClickReplaceLanguages() {
        replaceLanguages();
    }

    @Override
    public void updateSelectedLanguage(@NonNull Language language) {
        if(mSelectSourceMode == SELECT_SOURCE_MODE) {
            if(language.equals(mLanguageTarget)) {
                replaceLanguages();
            }
            else {
                mLanguageSource = language;
                mView.setupLanguageSource(language);
            }
        }
        else if(mSelectSourceMode == SELECT_TARGET_MODE) {
            if(language.equals(mLanguageSource)) {
                replaceLanguages();
            }
            else {
                mLanguageTarget = language;
                mView.setupLanguageTarget(language);
            }
        }
    }

    private void replaceLanguages() {
        Language languageReplace = mLanguageSource;
        mLanguageSource = mLanguageTarget;
        mLanguageTarget = languageReplace;
        mView.setupLanguageSource(mLanguageSource);
        mView.setupLanguageTarget(mLanguageTarget);
    }

}
