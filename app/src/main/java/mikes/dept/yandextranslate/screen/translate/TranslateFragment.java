package mikes.dept.yandextranslate.screen.translate;

import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.screen.languages.LanguagesActivity;
import mikes.dept.yandextranslate.widget.languageselector.LanguageSelectorView;
import mikes.dept.yandextranslate.widget.languageselector.OnItemClickListenerLanguageSelector;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;

/**
 * Created by mikesdept on 23.4.17.
 */

public class TranslateFragment
        extends BaseFragment<TranslateContract.Presenter>
        implements TranslateContract.View, OnItemClickListenerLanguageSelector {

    @BindView(R.id.language_selector_view)
    LanguageSelectorView mLanguageSelectorView;

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
    }

    @Override
    public void navigateLanguages() {
        LanguagesActivity.navigateLanguages((AppCompatActivity) getActivity());
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

}
