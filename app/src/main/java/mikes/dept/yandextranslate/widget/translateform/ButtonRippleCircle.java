package mikes.dept.yandextranslate.widget.translateform;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;

/**
 * Created by mikesdept on 24.4.17.
 */

public class ButtonRippleCircle extends LinearLayoutCompat {

    private Integer mIconId;

    @BindView(R.id.icon_image_view)
    ImageView mIconImageView;

    public ButtonRippleCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        init();
    }

    public ButtonRippleCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        init();
    }

    public ButtonRippleCircle(Context context) {
        super(context);
        init();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ButtonRippleCircle,
                0, 0);

        try {
            mIconId = a.getResourceId(R.styleable.ButtonRippleCircle_button_ripple_circle_icon, 0);
        } finally {
            a.recycle();
        }
    }

    private void init() {
        inflate(getContext(), R.layout.view_button_ripple_circle, this);
        ButterKnife.bind(this);
        setupIcon();
    }

    private void setupIcon() {
        if(mIconId != 0) {
            mIconImageView.setImageDrawable(getContext().getResources().getDrawable(mIconId));
        }
    }

}
