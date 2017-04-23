package mikes.dept.yandextranslate.screen.main;

import mikes.dept.yandextranslate.screen.base.BaseContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface MainContract {

    interface View extends BaseContract.View {

        void init();

        void navigateTranslate();

        void navigateFavorites();

        void navigateSettings();

    }

    interface Presenter extends BaseContract.Presenter {

        void onClickTranslate();

        void onClickFavorites();

        void onClickSettings();

    }

}
