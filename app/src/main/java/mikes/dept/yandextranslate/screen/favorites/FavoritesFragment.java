package mikes.dept.yandextranslate.screen.favorites;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.screen.favorites.favorite.FavoriteFragment;
import mikes.dept.yandextranslate.screen.favorites.history.HistoryFragment;
import mikes.dept.yandextranslate.widget.viewpager.FragmentViewPagerAdapter;

/**
 * Created by mikesdept on 23.4.17.
 */

public class FavoritesFragment
        extends BaseFragment<FavoritesContract.Presenter>
        implements FavoritesContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.view_pager)
    ViewPager mPager;

    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    private OnRefreshFavoritesFragmentListener mOnRefreshFavoritesFragmentListener;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    protected FavoritesContract.Presenter getPresenter() {
        return new FavoritesPresenter(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mOnRefreshFavoritesFragmentListener = (OnRefreshFavoritesFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onViewSelected");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnRefreshFavoritesFragmentListener = (OnRefreshFavoritesFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onViewSelected");
        }
    }

    @Override
    public void init() {
        ButterKnife.bind(this, mView);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        android.support.v7.app.ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setTitle(R.string.favorite_favorites);
        }
        setHasOptionsMenu(true);
        setupViewPager(mPager);
        mTabLayout.setupWithViewPager(mPager);
    }

    @Override
    public void showDialog() {
        new AlertDialog.Builder(getActivity())
                .setMessage(R.string.are_you_sure_to_delete_all_history)
                .setPositiveButton(R.string.yes, (dialog1, which) -> mPresenter.onClickDeleteHistoryConfirmed())
                .setNegativeButton(R.string.no, (dialog12, which) -> dialog12.dismiss())
                .create()
                .show();
    }

    @Override
    public void showMessage(@NonNull Integer messageId) {
        Toast.makeText(getActivity(), getString(messageId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshFavorites() {
        if(mOnRefreshFavoritesFragmentListener != null) {
            mOnRefreshFavoritesFragmentListener.onRefreshFavorites();
        }
    }

    private void setupViewPager(@NonNull ViewPager viewPager) {
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new HistoryFragment(), getString(R.string.favorite_history));
        adapter.addFragment(new FavoriteFragment(), getString(R.string.favorite_favorites));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        menuInflater.inflate(R.menu.menu_delete, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.menu_delete:
                mPresenter.onClickDeleteHistory();
                break;
        }
        return true;
    }

}
