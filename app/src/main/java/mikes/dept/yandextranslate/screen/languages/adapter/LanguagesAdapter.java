package mikes.dept.yandextranslate.screen.languages.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.Language;

/**
 * Created by mikesdept on 23.4.17.
 */

public class LanguagesAdapter
        extends RecyclerView.Adapter<LanguagesHolder>
        implements View.OnClickListener {

    private final LanguagesOnItemClickListener mOnItemClickListener;
    private final List<Language> mLanguages;

    public LanguagesAdapter(@NonNull LanguagesOnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
        mLanguages = new ArrayList<>();
    }

    public void changeDataSet(@NonNull List<Language> list){
        mLanguages.clear();
        mLanguages.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public LanguagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_language, parent, false);
        return new LanguagesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LanguagesHolder holder, int position) {
        Language language = mLanguages.get(position);
        holder.bind(language);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(language);
    }

    @Override
    public int getItemCount() {
        return mLanguages.size();
    }

    @Override
    public void onClick(View v) {
        Language language = (Language) v.getTag();
        mOnItemClickListener.onClickLanguage(language);
    }

}
