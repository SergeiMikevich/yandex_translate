package mikes.dept.yandextranslate.screen.languages.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.Language;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title)
    TextView mTitleTextView;

    @BindView(R.id.code)
    TextView mCodeTextView;

    public LanguagesHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull Language language){
        mTitleTextView.setText(language.getTitle());
        mCodeTextView.setText(language.getCode());
    }

}
