package com.ooi.diloabsensi;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Berita extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<BeritaClass> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        arrayList = new ArrayList<BeritaClass>();
        mSwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));
        arrayList.add(new BeritaClass("id", "tanggal", "judul", "deskripsi", null, "barcode"));


        RvAdapter adapter = new RvAdapter(arrayList);
        mRecyclerView.setAdapter(adapter);
    }

    void refreshItems() {
        Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return "execute";
        }

        @Override
        protected void onPostExecute(String result) {}

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }



}
