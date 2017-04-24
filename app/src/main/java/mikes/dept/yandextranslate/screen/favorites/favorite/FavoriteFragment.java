package mikes.dept.yandextranslate.screen.favorites.favorite;

import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;

/**
 * Created by mikesdept on 24.4.17.
 */

public class FavoriteFragment
        extends BaseFragment<FavoriteContract.Presenter>
        implements FavoriteContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    protected FavoriteContract.Presenter getPresenter() {
        return new FavoritePresenter(this);
    }

    @Override
    public void init() {
        mPresenter.loadData();
    }

}
