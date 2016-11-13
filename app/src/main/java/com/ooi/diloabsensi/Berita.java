package com.ooi.diloabsensi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Berita extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<BeritaClass> arrayList;
    private RvAdapter adapter;
    private ApiInterface apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        arrayList = new ArrayList<BeritaClass>();
        adapter=new RvAdapter(arrayList);
        mRecyclerView.setAdapter(adapter);

        mSwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });
        apiService =ApiClient.getClient().create(ApiInterface.class);
        refreshItems();
    }


    void refreshItems() {

        final Call<List<BeritaClass>> call =apiService.getBeritaAcara();
        call.enqueue(new Callback<List<BeritaClass>>() {
            @Override
            public void onResponse(Call<List<BeritaClass>> call, Response<List<BeritaClass>> response) {
                arrayList.clear();
                for (int i=0;i<response.body().size()-1;i++){
                   arrayList.add(new BeritaClass(response.body().get(i).getIdacara(),response.body().get(i).getTanggal(),
                           response.body().get(i).getJudul(),response.body().get(i).getDeskripsi(),response.body().get(i).getGambar(),
                           response.body().get(i).getBarcode()));
                }
                adapter.berita=arrayList;
                mRecyclerView.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<BeritaClass>> call, Throwable t) {
                if(call.isCanceled()){
                    Log.d("RESPONSE","call cancelled");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error occured",5).show();
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                call.cancel();
            }
        }, 5000);
    }
}
