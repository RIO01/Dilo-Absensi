package com.ooi.diloabsensi;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;


@SuppressWarnings("deprecation")
public class MenuTab extends TabActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tab);

        TabHost tabhost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, Berita.class);//content pada tab yang akan kita buat
        spec = tabhost.newTabSpec("berita").setIndicator("BERITA",null).setContent(intent);//mengeset nama tab dan mengisi content pada menu tab anda.
        tabhost.addTab(spec);//untuk membuat tabbaru disini bisa diatur sesuai keinginan anda

        intent = new Intent().setClass(this, Absensi.class);
        spec = tabhost.newTabSpec("absensi").setIndicator("ABSENSI",null).setContent(intent);
        tabhost.addTab(spec);

        intent = new Intent().setClass(this, DaftarHadir.class);
        spec = tabhost.newTabSpec("dhadir").setIndicator("DAFTAR HADIR",null).setContent(intent);
        tabhost.addTab(spec);

    }
}
