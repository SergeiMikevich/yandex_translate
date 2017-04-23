package mikes.dept.yandextranslate.screen.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseActivity;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;

public class MainActivity
        extends BaseActivity<MainContract.Presenter>
        implements MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener {

    private LoadingView mLoadingView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.Presenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
    }

    @Override
    public void navigateTranslate() {
        //TODO: navigate translate fragment
    }

    @Override
    public void navigateFavorites() {
        //TODO: navigate favorites fragment
    }

    @Override
    public void navigateSettings() {
        //TODO: navigate settings fragment
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.bottom_navigation_translate:
                mPresenter.onClickTranslate();
                break;
            case R.id.bottom_navigation_favorites:
                mPresenter.onClickFavorites();
                break;
            case R.id.bottom_navigation_settings:
                mPresenter.onClickSettings();
                break;
        }
        return true;
    }

    private void navigateFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}
