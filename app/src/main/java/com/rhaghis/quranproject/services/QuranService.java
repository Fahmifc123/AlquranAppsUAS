package com.rhaghis.quranproject.services;

import com.rhaghis.quranproject.models.Quran;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RH Aghis on 1/8/2018.
 */

public interface QuranService {
    @GET("quran-uthmani")
    Call<Quran> getQuran();
}
