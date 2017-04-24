package mikes.dept.yandextranslate.screen.favorites.history;

import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseFragment;

/**
 * Created by mikesdept on 24.4.17.
 */

public class HistoryFragment
        extends BaseFragment<HistoryContract.Presenter>
        implements HistoryContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    protected HistoryContract.Presenter getPresenter() {
        return new HistoryPresenter(this);
    }

    @Override
    public void init() {
        mPresenter.loadData();
    }

}
