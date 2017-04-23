package mikes.dept.yandextranslate.screen.translate;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.screen.base.BaseFragmentContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface TranslateContract {

    interface View extends BaseFragmentContract.View {

        void init();

        void navigateLanguages();

        void setupLanguageSource(Language language);

        void setupLanguageTarget(Language language);

    }

    interface Presenter extends BaseFragmentContract.Presenter {

        void onClickLanguagesSource();

        void onClickLanguageTarget();

        void onClickReplaceLanguages();

        void updateSelectedLanguage(@NonNull Language language);

    }

}
