package mikes.dept.yandextranslate.screen.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mikesdept on 23.4.17.
 */

public abstract class BaseActivity<P extends BaseContract.Presenter> extends AppCompatActivity {

    protected P mPresenter;

    protected abstract int getLayoutId();

    protected abstract P getPresenter();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = getPresenter();
        mPresenter.onCreate();
    }

    public void onStart(){
        super.onStart();
        mPresenter.onStart();
    }

    public void onResume(){
        super.onResume();
        mPresenter.onResume();
    }

    public void onPause(){
        super.onPause();
        mPresenter.onPause();
    }

    public void onStop(){
        super.onStop();
        mPresenter.onStop();
    }

}
