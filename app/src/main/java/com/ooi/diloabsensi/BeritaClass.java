package com.ooi.diloabsensi;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by edric on 11/12/2016.
 */

public class BeritaClass {

    @SerializedName("id")
    private String idacara;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("nama_acara")
    private String judul;
    @SerializedName("desc")
    private String deskripsi;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("barcode")
    private String barcode;

    public BeritaClass(){

    }

    public BeritaClass(String idacara,String tanggal,String judul,String deskripsi,String gambar,String barcode){
        super();
        this.tanggal=tanggal;
        this.judul=judul;
        this.deskripsi=deskripsi;
        this.gambar=gambar;
        this.barcode=barcode;
        this.idacara=idacara;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getIdacara() {
        return idacara;
    }

    public String getGambar() {
        return gambar;
    }

    public String getJudul() {
        return judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public void setIdAcara(String idacara) {
        this.idacara = idacara;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
