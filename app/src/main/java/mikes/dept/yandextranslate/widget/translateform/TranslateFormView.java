package mikes.dept.yandextranslate.widget.translateform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.method.KeyListener;
import android.util.AttributeSet;

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

    @BindView(R.id.voice_button)
    ButtonRippleCircle mVoiceButton;

    @BindView(R.id.volume_button)
    ButtonRippleCircle mVolumeButton;

    @BindView(R.id.clear_button)
    ButtonRippleCircle mClearButton;

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
        mKeyListener = mTranslateEditText.getKeyListener();
        setEditableText(false);
        mVoiceButton.findViewById(R.id.button).setOnClickListener(v -> onClickVoice());
        mVolumeButton.findViewById(R.id.button).setOnClickListener(v -> onClickVolume());
        mClearButton.findViewById(R.id.button).setOnClickListener(v -> onClickClear());
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
    }

    public void setOnTranslateFormChangedListener(@NonNull OnTranslateFormChangedListener onTranslateFormChangedListener) {
        mOnTranslateFormChangedListener = onTranslateFormChangedListener;
    }

    private void onClickVoice() {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onClickVoice();
        }
    }

    private void onClickVolume() {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onClickVolume();
        }
    }

    private void onClickClear() {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onClickClearForm();
        }
    }

    @Override
    public void onTextChanged(String text) {
        if(mOnTranslateFormChangedListener != null) {
            mOnTranslateFormChangedListener.onTextChanged(text);
        }
    }
}
