package mikes.dept.yandextranslate.screen.base;

import mikes.dept.yandextranslate.widget.loading.LoadingView;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface BaseFragmentContract {

    interface View extends LoadingView {

    }

    interface Presenter {

        void onCreateView();

    }

}
