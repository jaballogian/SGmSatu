package com.example.jaballogian.sgmsatu;

import android.media.Image;

public class ListInfo {

    private String judul, isi;
    //private Image gambar;

    ListInfo(){

    }

    public ListInfo (String judul, String isi){

        this.judul = judul;
        this.isi = isi;
    }

//    public ListInfo (Image gambar, String judul, String isi){
//
//        this.gambar = gambar;
//        this.judul = judul;
//        this.isi = isi;
//    }

//    public Image getGambar() {
//        return gambar;
//    }
//
//    public void setGambar(Image gambar) {
//        this.gambar = gambar;
//    }

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
