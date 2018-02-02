package com.rhaghis.quranproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rhaghis.quranproject.adapter.DetailAdapter;
import com.rhaghis.quranproject.models.Surah;
import com.rhaghis.quranproject.services.QuranService;

import java.util.ArrayList;
import java.util.List;

public class AyatActivity extends AppCompatActivity {

    TextView txtAyatText;
    String number;

    QuranService service;
    RecyclerView rvAyat;
    DetailAdapter detailAdapter;
    List<Surah> surahList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat);

//        service = ServiceGenerator.createService(QuranService.class);
//        reloadData();
//        detailAdapter = new DetailAdapter(getApplicationContext(), surahList);
//        layoutManager = new LinearLayoutManager(this);
//        rvAyat = findViewById(R.id.rvAyat);
//        rvAyat.setLayoutManager(layoutManager);
//        rvAyat.setAdapter(detailAdapter);

        Intent i = getIntent();
        txtAyatText = findViewById(R.id.txtAyatText);
        number = i.getStringExtra("number");

        txtAyatText.setText(i.getStringExtra("text"));

    }

//    private void reloadData() {
//        Call<Quran> call = service.getQuran();
//        call.enqueue(new Callback<Quran>() {
//            @Override
//            public void onResponse(Call<Quran> call, Response<Quran> response) {
//                Log.d("Suk", "Sukses !!! ");
//                surahList.clear();
//                surahList.addAll(response.body().getData().getSurahs());
//                detailAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<Quran> call, Throwable t) {
//                Log.d(String.valueOf(t), "Error : "+t);
//            }
//        });
//    }
}
