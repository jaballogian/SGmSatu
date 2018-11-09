package com.example.jaballogian.sgmsatu;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class ListInfo {

    private String judul, isi;
    private Drawable gambar;

    ListInfo(){

    }

//    public ListInfo (String judul, String isi){
//
//        this.judul = judul;
//        this.isi = isi;
//    }

    public ListInfo (Drawable gambar, String judul, String isi){

        this.gambar = gambar;
        this.judul = judul;
        this.isi = isi;
    }

    public Drawable getGambar() {
        return gambar;
    }

    public void setGambar(Drawable gambar) {
        this.gambar = gambar;
    }

    public String getIsi() {
        return isi;
    }

    public String getJudul() {
        return judul;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
