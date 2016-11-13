package com.ooi.diloabsensi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by edric on 11/13/2016.
 */

public interface ApiInterface {
    @GET("acara")
    Call<List<BeritaClass>> getBeritaAcara();
}
