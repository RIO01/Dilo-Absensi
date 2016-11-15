package com.ooi.diloabsensi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IsiBerita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_berita);
        String[] str=new String[2];
        str= getIntent().getStringExtra("tanggal").split(" ");



        Glide.with(this).load(getIntent().getStringExtra("gambar")).placeholder(R.drawable.default_thumbnail).into((ImageView)findViewById(R.id.gambaracara));
        ((TextView)findViewById(R.id.tanggalvalue)).setText(str[0]);
        ((TextView)findViewById(R.id.waktuvalue)).setText(str[1]);
        ((TextView)findViewById(R.id.judulacara)).setText(getIntent().getStringExtra("judul"));
        ((TextView)findViewById(R.id.deskripsiacara)).setText(getIntent().getStringExtra("deskripsi"));
    }
}
