package mikes.dept.yandextranslate.widget.translateform;

import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 24.4.17.
 */

public interface OnTranslateFormChangedListener {

    void onTextChanged(@NonNull String text);

    void onClickClearForm();

}
