package mikes.dept.yandextranslate.widget.languageselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.Language;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguageSelectorItemView extends LinearLayoutCompat {

    private String title;

    @BindView(R.id.title_text_view)
    TextView mTitleTextView;

    @BindView(R.id.language_text_view)
    TextView mLanguageTextView;

    public LanguageSelectorItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        init();
    }

    public LanguageSelectorItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        init();
    }

    public LanguageSelectorItemView(Context context) {
        super(context);
        init();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LanguageSelectorItemView,
                0, 0);

        try {
            title = a.getString(R.styleable.LanguageSelectorItemView_view_item_language_selector_title);
        } finally {
            a.recycle();
        }
    }

    private void init() {
        inflate(getContext(), R.layout.view_item_language_selector, this);
        ButterKnife.bind(this);
        setupTitle();
    }

    private void setupTitle() {
        mTitleTextView.setText(title != null ? title : "");
    }

    public void setupLanguage(Language language) {
        if(language == null) {
            mLanguageTextView.setText("");
        }
        else {
            mLanguageTextView.setText(language.getTitle() + " (" + language.getCode() + ")");
        }
    }

}
