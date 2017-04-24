package mikes.dept.yandextranslate.screen.favorites.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mikes.dept.yandextranslate.R;
import mikes.dept.yandextranslate.model.content.History;

/**
 * Created by mikesdept on 24.4.17.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesHolder> {

    private final List<History> mHistoryList;

    public FavoritesAdapter(){
        mHistoryList = new ArrayList<>();
    }

    public void changeDataSet(@NonNull List<History> historyList){
        mHistoryList.clear();
        mHistoryList.addAll(historyList);
        notifyDataSetChanged();
    }

    @Override
    public FavoritesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_favorite, parent, false);
        return new FavoritesHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(FavoritesHolder holder, int position) {
        History history= mHistoryList.get(position);
        holder.bind(history);
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }

}
