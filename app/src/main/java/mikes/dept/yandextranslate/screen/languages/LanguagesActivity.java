package mikes.dept.yandextranslate.screen.languages;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.screen.base.BaseActivity;
import mikes.dept.yandextranslate.screen.languages.adapter.LanguagesAdapter;
import mikes.dept.yandextranslate.screen.languages.adapter.OnItemClickListenerLanguage;
import mikes.dept.yandextranslate.utils.ExtraKeys;
import mikes.dept.yandextranslate.widget.divider.DividerItemDecoration;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesActivity
        extends BaseActivity<LanguagesContract.Presenter>
        implements LanguagesContract.View, OnItemClickListenerLanguage, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private LanguagesAdapter mAdapter;

    private LoadingView mLoadingView;

    public final static int REQUEST_CODE = 123;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_languages;
    }

    @Override
    protected LanguagesContract.Presenter getPresenter() {
        return new LanguagesPresenter(this);
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mAdapter = new LanguagesAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mPresenter.loadLanguages("en");
    }

    @Override
    public void showLanguages(List<Language> languages) {
        mAdapter.changeDataSet(languages);
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mSwipeRefreshLayout.setRefreshing(false);
        mLoadingView.hideLoadingIndicator();
    }

    @Override
    public void onClickLanguage(@NonNull Language language) {
        Intent intent = new Intent();
        intent.putExtra(ExtraKeys.EXTRA_KEY_SELECTED_LANGUAGE, language);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.loadLanguages("en");
    }

}
