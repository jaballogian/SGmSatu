package com.example.jaballogian.sgmsatu;

public class ListInfo {

    private String judul, isi;

    ListInfo(){

    }

    public ListInfo (String judul, String isi){

        this.judul = judul;
        this.isi = isi;
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
