package mikes.dept.yandextranslate.screen.translate;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.screen.languages.LanguagesActivity;
import mikes.dept.yandextranslate.utils.ExtraKeys;
import mikes.dept.yandextranslate.widget.languageselector.LanguageSelectorView;
import mikes.dept.yandextranslate.widget.languageselector.OnItemClickListenerLanguageSelector;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;
import mikes.dept.yandextranslate.widget.translateform.OnTranslateFormChangedListener;
import mikes.dept.yandextranslate.widget.translateform.TranslateFormView;

/**
 * Created by mikesdept on 23.4.17.
 */

public class TranslateFragment
        extends BaseFragment<TranslateContract.Presenter>
        implements TranslateContract.View, OnItemClickListenerLanguageSelector, OnTranslateFormChangedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.language_selector_view)
    LanguageSelectorView mLanguageSelectorView;

    @BindView(R.id.translate_form_view)
    TranslateFormView mTranslateFormView;

    private LoadingView mLoadingView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_translate;
    }

    @Override
    protected TranslateContract.Presenter getPresenter() {
        return new TranslatePresenter(this);
    }

    @Override
    public void init() {
        ButterKnife.bind(this, mView);
        mLoadingView = LoadingDialog.view(getChildFragmentManager());
        mLanguageSelectorView.setOnClickListener(this);
        mTranslateFormView.setOnTranslateFormChangedListener(this);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
    }

    @Override
    public void navigateLanguages() {
        Intent intent = new Intent(getActivity(), LanguagesActivity.class);
        startActivityForResult(intent, LanguagesActivity.REQUEST_CODE);
    }

    @Override
    public void setupLanguageSource(Language language) {
        mLanguageSelectorView.setupLanguageSource(language);
    }

    @Override
    public void setupLanguageTarget(Language language) {
        mLanguageSelectorView.setupLanguageTarget(language);
    }

    @Override
    public void setEditableText(@NonNull Boolean isEditable) {
        mTranslateFormView.setEditableText(isEditable);
    }

    @Override
    public void clearForm() {
        mTranslateFormView.clearForm();
    }

    @Override
    public void setResults(@NonNull String resultTranslate) {
        Log.d("TAG", "RESULT: " + resultTranslate);
    }

    @Override
    public void showMessage(@NonNull Integer messageId) {
        Snackbar.make(mToolbar, getString(messageId), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingView.hideLoadingIndicator();
    }

    @Override
    public void onClickLanguageSource() {
        mPresenter.onClickLanguagesSource();
    }

    @Override
    public void onClickLanguageTarget() {
        mPresenter.onClickLanguageTarget();
    }

    @Override
    public void onClickReplaceLanguages() {
        mPresenter.onClickReplaceLanguages();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(resultCode == Activity.RESULT_OK && requestCode == LanguagesActivity.REQUEST_CODE){
            Language language = intent.getParcelableExtra(ExtraKeys.EXTRA_KEY_SELECTED_LANGUAGE);
            mPresenter.updateSelectedLanguage(language);
        }
    }

    @Override
    public void onTextChanged(@NonNull String text) {
        mPresenter.onTextChanged(text);
    }

    @Override
    public void onClickVoice() {
        mPresenter.onClickVoice();
    }

    @Override
    public void onClickVolume() {
        mPresenter.onClickVolume();
    }

    @Override
    public void onClickClearForm() {
        mPresenter.onClickClearForm();
    }

}
