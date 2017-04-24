package mikes.dept.yandextranslate.widget.translateform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;

/**
 * Created by mikesdept on 24.4.17.
 */

public class TranslateFormView
        extends LinearLayoutCompat
        implements RxEditText.RxEditTextChangeListener {

    @BindView(R.id.translate_edit_text)
    RxEditText mTranslateEditText;

    @BindView(R.id.translate_result_edit_text)
    EditText mTranslateResultEditText;

    @BindView(R.id.clear_button)
    ButtonRippleCircle mClearButton;

    @BindView(R.id.favorite_button)
    ButtonRippleCircle mFavoriteButton;

    KeyListener mKeyListener;

    private OnTranslateFormChangedListener mOnTranslateFormChangedListener;

    public TranslateFormView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TranslateFormView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TranslateFormView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_translate_form, this);
        ButterKnife.bind(this);
        mTranslateEditText.setOnRxTextChangeListener(this, 500);
        mTranslateResultEditText.setKeyListener(null);
        mKeyListener = mTranslateEditText.getKeyListener();
        setEditableText(false);
        mClearButton.findViewById(R.id.button).setOnClickListener(v -> onClickClear());
        mFavoriteButton.findViewById(R.id.button).setOnClickListener(v -> onClickFavorite());
    }

    public void setEditableText(@NonNull Boolean isEditable) {
        if(isEditable) {
            mTranslateEditText.setKeyListener(mKeyListener);
        }
        else {
            mTranslateEditText.setKeyListener(null);
        }
    }

    public void clearForm() {
        mTranslateEditText.setText("");
        mTranslateResultEditText.setText("");
    }

    public void setResult(@NonNull String translateResult) {
        mTranslateResultEditText.setText(translateResult);
    }

    public void setOnTranslateFormChangedListener(@NonNull OnTranslateFormChangedListener onTranslateFormChangedListener) {
        mOnTranslateFormChangedListener = onTranslateFormChangedListener;
    }

    private void onClickClear() {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onClickClearForm();
        }
    }

    private void onClickFavorite() {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onClickFavorite();
        }
    }

    @Override
    public void onTextChanged(String text) {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onTextChanged(text);
        }
    }
}
