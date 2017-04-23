package mikes.dept.yandextranslate.screen.languages;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.screen.base.BaseActivity;
import mikes.dept.yandextranslate.widget.loading.LoadingDialog;
import mikes.dept.yandextranslate.widget.loading.LoadingView;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesActivity
        extends BaseActivity<LanguagesContract.Presenter>
        implements LanguagesContract.View {

    private LoadingView mLoadingView;

    public static void navigateLanguages(@NonNull AppCompatActivity activity) {
        activity.startActivity(new Intent(activity, LanguagesActivity.class));
    }

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
