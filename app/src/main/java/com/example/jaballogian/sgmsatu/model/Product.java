package com.example.jaballogian.sgmsatu.model;


import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Products")
public class Product extends TruncatableModel {
    // If name is omitted, then the field name is used.
    @Column(name = "gambar")
    public String gambar;

    @Column(name = "judul")
    public String judul;

    @Column(name = "rasa")
    public String rasa;

    @Column(name = "deskripsi")
    public String deskripsi;

    @Column(name = "harga")
    public long harga;

    public Product() {
        super();
    }

    public Product(String gambar, String judul, String rasa, String deskripsi, int harga){
        super();
        this.gambar = gambar;
        this.judul = judul;
        this.rasa = rasa;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public static List<Product> listAll() {
        // This is how you execute a query
        return new Select()
                .from(Product.class)
                .execute();
    }

    public String toString()
    {
        return String.format("{'gambar':%s, 'judul':%s, 'rasa':%s, 'deskripsi':%s, 'harga':%d}", gambar, judul, rasa, deskripsi, harga);
    }
}
