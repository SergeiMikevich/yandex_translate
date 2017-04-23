package mikes.dept.yandextranslate.screen.main;

import mikes.dept.yandextranslate.screen.base.BaseActivityContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface MainContract {

    interface View {

        void navigateTranslate();

        void navigateFavorites();

        void navigateSettings();

    }

    interface Presenter extends BaseActivityContract.Presenter {

        void onClickTranslate();

        void onClickFavorites();

        void onClickSettings();

    }

}
