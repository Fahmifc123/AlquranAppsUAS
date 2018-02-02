package com.rhaghis.quranproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rhaghis.quranproject.AyatActivity;
import com.rhaghis.quranproject.R;
import com.rhaghis.quranproject.models.Data;
import com.rhaghis.quranproject.models.Surah;

import java.util.List;

/**
 * Created by Nahila Khunafa on 1/13/2018.
 */

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder> {
    Context ctx;
    List<Surah> surahList;

    public QuranAdapter(Context ctx, List<Surah> surahList) {
        this.ctx = ctx;
        this.surahList = surahList;
    }

    @Override
    public QuranAdapter.QuranViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listsurah,parent,false);
        QuranViewHolder vh = new QuranViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(QuranAdapter.QuranViewHolder holder, int position) {
        final Surah itemSurah = surahList.get(position);
        holder.txtSurah.setText(itemSurah.getName());
        holder.txtNomor.setText(itemSurah.getNumber().toString());

        holder.txtSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AyatActivity.class);
                i.putExtra("number", itemSurah.getNumber().toString());
                i.putExtra("name", itemSurah.getName());
                i.putExtra("text", itemSurah.getAyahs().get(0).getText());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public class QuranViewHolder extends RecyclerView.ViewHolder {
        public TextView txtSurah, txtNomor;

        public QuranViewHolder(View itemView) {
            super(itemView);
            txtSurah = itemView.findViewById(R.id.txtSurah);
            txtNomor = itemView.findViewById(R.id.txtNomor);
        }
    }
}
