package mikes.dept.yandextranslate.screen.settings;

import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.screen.favorites.FavoritesContract;
import mikes.dept.yandextranslate.screen.favorites.FavoritesPresenter;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;

/**
 * Created by mikesdept on 23.4.17.
 */

public class SettingsFragment
        extends BaseFragment<SettingsContract.Presenter>
        implements SettingsContract.View {

    private LoadingView mLoadingView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    protected SettingsContract.Presenter getPresenter() {
        return new SettingsPresenter(this);
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
