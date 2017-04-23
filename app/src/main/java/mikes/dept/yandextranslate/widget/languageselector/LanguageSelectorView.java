package mikes.dept.yandextranslate.widget.languageselector;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.Language;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguageSelectorView extends LinearLayoutCompat {

    @BindView(R.id.language_selector_source_item_view)
    LanguageSelectorItemView mLanguageSelectorSourceItemView;

    @BindView(R.id.language_selector_target_item_view)
    LanguageSelectorItemView mLanguageSelectorTargetItemView;

    private OnItemClickListenerLanguageSelector mOnItemClickListenerLanguageSelector;

    public LanguageSelectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LanguageSelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LanguageSelectorView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_language_selector, this);
        ButterKnife.bind(this);
    }

    public void setupLanguageSource(@NonNull Language language) {
        mLanguageSelectorSourceItemView.setupLanguage(language);
    }

    public void setupLanguageTarget(@NonNull Language language) {
        mLanguageSelectorTargetItemView.setupLanguage(language);
    }

    public void setOnClickListener(@NonNull OnItemClickListenerLanguageSelector onItemClickListenerLanguageSelector) {
        mOnItemClickListenerLanguageSelector = onItemClickListenerLanguageSelector;
    }

    @OnClick(R.id.language_selector_source_item_view)
    public void onClickLanguageFrom() {
        if(mOnItemClickListenerLanguageSelector != null) {
            mOnItemClickListenerLanguageSelector.onClickLanguageSource();
        }
    }

    @OnClick(R.id.language_selector_target_item_view)
    public void onClickLanguageTo() {
        if(mOnItemClickListenerLanguageSelector != null) {
            mOnItemClickListenerLanguageSelector.onClickLanguageTarget();
        }
    }

    @OnClick(R.id.replace_languages_button)
    public void onClickReplaceLanguages() {
        if(mOnItemClickListenerLanguageSelector != null) {
            mOnItemClickListenerLanguageSelector.onClickReplaceLanguages();
        }
    }

}
