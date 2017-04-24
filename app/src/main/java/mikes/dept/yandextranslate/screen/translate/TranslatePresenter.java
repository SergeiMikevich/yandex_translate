package mikes.dept.yandextranslate.screen.translate;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    private String mCurrentTextForTranslate = "";

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
        checkIsTextForTranslateEmpty();
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
        if(mLanguageSource != null && mLanguageTarget != null) {
            mView.setEditableText(true);
            checkIsTextForTranslateEmpty();
        }
        else {
            mView.setEditableText(false);
        }
    }

    @Override
    public void onTextChanged(@NonNull String text) {
        mCurrentTextForTranslate = text;
        checkIsTextForTranslateEmpty();
    }

    @Override
    public void onClickClearForm() {
        mView.clearForm();
    }

    @Override
    public void onClickFavorite() {

    }

    private void replaceLanguages() {
        Language languageReplace = mLanguageSource;
        mLanguageSource = mLanguageTarget;
        mLanguageTarget = languageReplace;
        mView.setupLanguageSource(mLanguageSource);
        mView.setupLanguageTarget(mLanguageTarget);
    }

    private void translate() {
        RepositoryProvider.provideYandexTranslateRepository()
                .translate(mLanguageSource.getCode(), mLanguageTarget.getCode(), mCurrentTextForTranslate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mView::setResult, throwable -> mView.setResult(""));
    }

    private void checkIsTextForTranslateEmpty() {
        if(TextUtils.isEmpty(mCurrentTextForTranslate)) {
            mView.setResult("");
        }
        else {
            translate();
        }
    }

}
