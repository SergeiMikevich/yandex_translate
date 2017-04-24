package mikes.dept.yandextranslate.screen.favorites.history;

import java.util.List;

import mikes.dept.yandextranslate.model.content.History;
import mikes.dept.yandextranslate.screen.base.BaseFragmentContract;

/**
 * Created by mikesdept on 24.4.17.
 */

public interface HistoryContract {

    interface View {

        void init();

        void showHistory(List<History> histories);

    }

    interface Presenter extends BaseFragmentContract.Presenter {

        void loadData();

    }

}
