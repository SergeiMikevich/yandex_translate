package mikes.dept.yandextranslate.screen.translate;

import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;

/**
 * Created by mikesdept on 23.4.17.
 */

public class TranslateFragment
        extends BaseFragment<TranslateContract.Presenter>
        implements TranslateContract.View {

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
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingView.hideLoadingIndicator();
    }

}
