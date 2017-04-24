package mikes.dept.yandextranslate.screen.favorites.history;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.History;
import mikes.dept.yandextranslate.screen.base.BaseFragment;
import mikes.dept.yandextranslate.screen.favorites.adapter.FavoritesAdapter;
import mikes.dept.yandextranslate.widget.divider.DividerItemDecoration;

/**
 * Created by mikesdept on 24.4.17.
 */

public class HistoryFragment
        extends BaseFragment<HistoryContract.Presenter>
        implements HistoryContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private FavoritesAdapter mAdapter;

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
        ButterKnife.bind(this, mView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        mAdapter = new FavoritesAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.loadData();
    }

    @Override
    public void showHistory(List<History> histories) {
        mAdapter.changeDataSet(histories);
    }

}
