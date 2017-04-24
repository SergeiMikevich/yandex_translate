package mikes.dept.yandextranslate.screen.favorites.history;

import mikes.dept.yandextranslate.screen.base.BaseFragmentContract;

/**
 * Created by mikesdept on 24.4.17.
 */

public interface HistoryContract {

    interface View {

        void init();

    }

    interface Presenter extends BaseFragmentContract.Presenter {

        void loadData();

    }

}
