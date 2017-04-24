package mikes.dept.yandextranslate.screen.favorites.favorite;

import android.support.annotation.NonNull;

import java.util.List;

import mikes.dept.yandextranslate.model.content.History;
import mikes.dept.yandextranslate.screen.base.BaseFragmentContract;

/**
 * Created by mikesdept on 24.4.17.
 */

public interface FavoriteContract {

    interface View {

        void init();

        void showHistory(@NonNull List<History> histories);

    }

    interface Presenter extends BaseFragmentContract.Presenter {

        void loadData();

    }

}
