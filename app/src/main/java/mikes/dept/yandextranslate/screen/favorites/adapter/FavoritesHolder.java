package mikes.dept.yandextranslate.screen.favorites.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.History;

/**
 * Created by mikesdept on 24.4.17.
 */

public class FavoritesHolder extends RecyclerView.ViewHolder {

    private Context mContext;

    @BindView(R.id.favorite_icon)
    ImageView mFavoriteIcon;

    @BindView(R.id.source_text_view)
    TextView mSourceTextView;

    @BindView(R.id.target_text_view)
    TextView mTargetTextView;

    @BindView(R.id.language_text_view)
    TextView mLanguageTextView;

    public FavoritesHolder(View itemView, @NonNull Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;
    }

    public void bind(@NonNull History history){
        if(history.isFavorite()) {
            mFavoriteIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.colorAccent));
        }
        else {
            mFavoriteIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.secondaryText));
        }
        mSourceTextView.setText(history.getTextSource());
        mTargetTextView.setText(history.getTextTarget());
        mLanguageTextView.setText(history.getLanguage());
    }

}
