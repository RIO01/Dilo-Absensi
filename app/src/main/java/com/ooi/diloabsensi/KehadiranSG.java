package com.ooi.diloabsensi;

/**
 * Created by edric on 11/15/2016.
 */

public class KehadiranSG {

    private String tanggal;
    private String waktu;
    private String nama;
    private String email;
    private String phone;

    KehadiranSG(){

    }

    public KehadiranSG(String tanggal,String waktu,String nama,String email,String phone){
        this.tanggal=tanggal;
        this.waktu=waktu;
        this.nama=nama;
        this.email=email;
        this.phone=phone;
    }

    public KehadiranSG(String nama,String email,String phone){
        this.nama=nama;
        this.email=email;
        this.phone=phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPhone() {
        return phone;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

}
