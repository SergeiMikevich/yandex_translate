package mikes.dept.yandextranslate.screen.favorites;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.screen.base.BaseFragmentContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface FavoritesContract {

    interface View {

        void init();

        void showDialog();

        void showMessage(@NonNull Integer messageId);

        void refreshFavorites();

    }

    interface Presenter extends BaseFragmentContract.Presenter {

        void onClickDeleteHistory();

        void onClickDeleteHistoryConfirmed();

    }

}
