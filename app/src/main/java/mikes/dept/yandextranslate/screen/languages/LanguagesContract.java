package mikes.dept.yandextranslate.screen.languages;

import android.support.annotation.NonNull;

import java.util.List;

import mikes.dept.yandextranslate.model.content.Language;
import mikes.dept.yandextranslate.screen.base.BaseActivityContract;

/**
 * Created by mikesdept on 23.4.17.
 */

public interface LanguagesContract {

    interface View extends BaseActivityContract.View {

        void init();

        void showLanguages(List<Language> languages);

    }

    interface Presenter extends BaseActivityContract.Presenter {

        void loadLanguages(@NonNull String ui);

    }

}
