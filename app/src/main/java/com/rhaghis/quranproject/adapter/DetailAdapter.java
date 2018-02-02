package com.rhaghis.quranproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rhaghis.quranproject.R;
import com.rhaghis.quranproject.models.Surah;

import java.util.List;

/**
 * Created by Novia on 29/01/2018.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    Context ctx;
    List<Surah> surahList;

    public DetailAdapter(Context ctx, List<Surah> surahList) {
        this.ctx = ctx;
        this.surahList = surahList;
    }

    @Override
    public DetailAdapter.DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listayat,parent,false);
        DetailAdapter.DetailViewHolder vh = new DetailAdapter.DetailViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DetailAdapter.DetailViewHolder holder, int position) {
        final Surah itemSurah = surahList.get(position);
        itemSurah.getAyahs().get(0).getNumber();
        holder.txtAyatText.setText(itemSurah.getAyahs().get(0).getText());

    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

        TextView txtAyatText;

        public DetailViewHolder(View itemView) {
            super(itemView);
            txtAyatText = itemView.findViewById(R.id.txtAyatText);
        }
    }
}
