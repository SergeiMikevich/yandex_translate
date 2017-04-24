package mikes.dept.yandextranslate.screen.favorites;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.screen.favorites.favorite.FavoriteFragment;
import mikes.dept.yandextranslate.screen.favorites.history.HistoryFragment;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;
import mikes.dept.yandextranslate.widget.viewpager.FragmentViewPagerAdapter;

/**
 * Created by mikesdept on 23.4.17.
 */

public class FavoritesFragment
        extends BaseFragment<FavoritesContract.Presenter>
        implements FavoritesContract.View {

    @BindView(R.id.view_pager)
    ViewPager mPager;

    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    protected FavoritesContract.Presenter getPresenter() {
        return new FavoritesPresenter(this);
    }

    @Override
    public void init() {
        ButterKnife.bind(this, mView);
        setupViewPager(mPager);
        mTabLayout.setupWithViewPager(mPager);
    }

    private void setupViewPager(@NonNull ViewPager viewPager) {
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new HistoryFragment(), getString(R.string.favorite_history));
        adapter.addFragment(new FavoriteFragment(), getString(R.string.favorite_favorites));
        viewPager.setAdapter(adapter);
    }

}
