package com.rhaghis.quranproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.rhaghis.quranproject.adapter.QuranAdapter;
import com.rhaghis.quranproject.generator.ServiceGenerator;
import com.rhaghis.quranproject.models.Quran;
import com.rhaghis.quranproject.models.Surah;
import com.rhaghis.quranproject.services.QuranService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    QuranService service;
    RecyclerView rvSursh;
    QuranAdapter quranAdapter;

    List<Surah> surahList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = ServiceGenerator.createService(QuranService.class);
        reloadData();
        quranAdapter = new QuranAdapter(getApplicationContext(), surahList);
        layoutManager = new LinearLayoutManager(this);
        rvSursh = findViewById(R.id.rvSurah);
        rvSursh.setLayoutManager(layoutManager);
        rvSursh.setAdapter(quranAdapter);
    }

    private void reloadData() {
        pr = ProgressDialog.show(this, "List Surah", "Silahkan Tunggu Sebentar....", true, false);
        Call<Quran> call = service.getQuran();
        call.enqueue(new Callback<Quran>() {
            @Override
            public void onResponse(Call<Quran> call, Response<Quran> response) {
                if(response.isSuccessful()){
                    pr.dismiss();
                    Log.d("Suk", "Sukses !!! ");
                    surahList.clear();
                    surahList.addAll(response.body().getData().getSurahs());
                    quranAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Data Telah Tampil", Toast.LENGTH_SHORT).show();
                }else {
                    pr.dismiss();
                    Toast.makeText(MainActivity.this, "Gagal Memuat Data", Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onFailure(Call<Quran> call, Throwable t) {
                Log.d(String.valueOf(t), "Error : "+t);
                Toast.makeText(MainActivity.this, "Harap Periksa Koneksi anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
