package mikes.dept.yandextranslate.screen.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseActivity;
import mikes.dept.yandextranslate.screen.favorites.FavoritesFragment;
import mikes.dept.yandextranslate.screen.favorites.OnRefreshFavoritesFragmentListener;
import mikes.dept.yandextranslate.screen.settings.SettingsFragment;
import mikes.dept.yandextranslate.screen.translate.TranslateFragment;

public class MainActivity
        extends BaseActivity<MainContract.Presenter>
        implements MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener, OnRefreshFavoritesFragmentListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;

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
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mPresenter.onClickTranslate();
    }

    @Override
    public void navigateTranslate() {
        navigateFragment(new TranslateFragment());
    }

    @Override
    public void navigateFavorites() {
        navigateFragment(new FavoritesFragment());
    }

    @Override
    public void navigateSettings() {
        navigateFragment(new SettingsFragment());
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

    @Override
    public void onRefreshFavorites() {
        navigateFragment(new FavoritesFragment());
    }

}
