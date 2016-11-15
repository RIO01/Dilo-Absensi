package com.ooi.diloabsensi;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarHadir extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<KehadiranSG> arrayList;
    private RvHadirAdapter adapter;
    private ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_hadir);

        mRecyclerView = (RecyclerView)findViewById(R.id.rvhadir);
        mLayoutManager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        arrayList = new ArrayList<KehadiranSG>();
        adapter=new RvHadirAdapter(




                arrayList);
        mRecyclerView.setAdapter(adapter);

        mSwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swiperefreshhadir);
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

//        final Call<List<KehadiranSG>> call =apiService.getBeritaAcara();
//        call.enqueue(new Callback<List<KehadiranSG>>() {
//            @Override
//            public void onResponse(Call<List<KehadiranSG>> call, Response<List<KehadiranSG>> response) {
//                arrayList.clear();
//                for (int i=0;i<response.body().size()-1;i++){
//
//                }
//                adapter.kehadiran=arrayList;
//                mRecyclerView.setAdapter(adapter);
//                mSwipeRefreshLayout.setRefreshing(false);
//            }
//
//            @Override
//            public void onFailure(Call<List<KehadiranSG>> call, Throwable t) {
//                if(call.isCanceled()){
//                    Log.d("RESPONSE","call cancelled");
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
//                call.cancel();
            }
        }, 5000);
    }
}
