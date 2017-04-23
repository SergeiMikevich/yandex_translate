package mikes.dept.yandextranslate.screen.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mikesdept on 23.4.17.
 */

public abstract class BaseFragment<P extends BaseFragmentContract.Presenter> extends Fragment {

    protected P mPresenter;

    protected abstract int getLayoutId();

    protected abstract P getPresenter();

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        mPresenter = getPresenter();
        mPresenter.onCreateView();
        return mView;
    }

}
