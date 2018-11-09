package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jaballogian.sgmsatu.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class CheckoutActivity extends AppCompatActivity {

    private ImageButton imgBtnGoBack, imgBtnPembayaran, imgBtnPengiriman;

    private Button btnBuatPesanan;

    private TextView tvNamaNoHP, tvAlamat, tvKota, tvProvinsi, tvJudul, tvHarga,
                     tvJumlah, tvPengiriman, tvPembayaran, tvTotalHarga;

    private DatabaseReference mDatabase;

    private int opsiKirim = 0, opsiBayar = 0;

    private String opsiBayarText[] = {"", "Kartu Kredit", "Atm / Transfer Bank", "Go-Pay", "OVO", "Pulsa"};

    private String opsiKirimText[] = {"", "Kurir Resmi SGM\nditerima dalam 0-1 hari"
                                        , "JNE REG\nditerima dalam 3-4 hari"
                                        , "J&T Express\nditerima dalam 5-9 hari"
                                        , "TIKI\nditerima dalam 3-4 hari"};

    private long hargaKirim[] = {0, 2000, 44000, 47000, 45000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        bindView();
        bindEvent();
        tvPengiriman.setText(String.valueOf(opsiKirimText[opsiKirim]));
        tvPembayaran.setText(String.valueOf(opsiBayarText[opsiBayar]));
        int id = getIntent().getIntExtra("id", 0);
        int jumlah = getIntent().getIntExtra("jumlah", 0);
        Product product = Product.load(Product.class, id);
        tvJudul.setText(product.judul);
        tvHarga.setText(String.valueOf(product.harga));
        String jumlahText = "x"+String.valueOf(jumlah);
        tvJumlah.setText(jumlahText);
        resetTotalHarga();


    }

    private void bindView()
    {
        btnBuatPesanan = (Button) findViewById(R.id.buatPesananButtonCheckoutActivity);
        imgBtnGoBack = (ImageButton) findViewById(R.id.backImageButtonCheckoutActivity);
        imgBtnPembayaran = (ImageButton) findViewById(R.id.pembayaranImageButtonCheckoutActivity);
        imgBtnPengiriman = (ImageButton) findViewById(R.id.pengirimanImageButtonCheckoutActivity);

        tvAlamat = (TextView) findViewById(R.id.alamatTextViewCheckoutActivity);
        tvHarga = (TextView) findViewById(R.id.hargaTextViewCheckoutActivity);
        tvJudul = (TextView) findViewById(R.id.judulTextViewCheckoutActivity);
        tvJumlah = (TextView) findViewById(R.id.jumlahTextViewCheckoutActivity);
        tvKota = (TextView) findViewById(R.id.kotaTextViewCheckoutActivity);
        tvNamaNoHP = (TextView) findViewById(R.id.namaDanNoHPTextViewCheckoutActivity);
        tvPembayaran = (TextView) findViewById(R.id.pembayaranTextViewCheckoutActivity);
        tvPengiriman = (TextView) findViewById(R.id.pengirimanTextViewCheckoutActivity);
        tvProvinsi = (TextView) findViewById(R.id.provinsiTextViewCheckoutActivity);
        tvTotalHarga = (TextView) findViewById(R.id.totalHargaTextViewCheckoutActivity);
    }

    private void bindEvent()
    {
        btnBuatPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrder();
            }
        });

        imgBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckoutActivity.super.onBackPressed();
            }
        });

        imgBtnPengiriman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CheckoutActivity.this,PengirimanActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        imgBtnPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CheckoutActivity.this,PembayaranActivity.class);
                startActivityForResult(intent, 3);
            }
        });

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uID = currentUser.getUid();

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(uID);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String namaNoHP = dataSnapshot.child("Nama Lengkap").getValue().toString() + " | " + dataSnapshot.child("No Telpon").getValue().toString();
                tvNamaNoHP.setText(namaNoHP);
                tvAlamat.setText(dataSnapshot.child("Alamat").getValue().toString());
                tvKota.setText(dataSnapshot.child("Kabupaten Kota").getValue().toString());
                tvProvinsi.setText(dataSnapshot.child("Provinsi").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            int hasil = data.getIntExtra("hasil", 0);
            if(hasil == 0) {
                opsiKirim = opsiKirim;
            }else
            {
                opsiKirim = hasil;
            }

            tvPengiriman.setText(String.valueOf(opsiKirimText[opsiKirim]));

        }else if(requestCode==3)
        {
            int hasil = data.getIntExtra("hasil", 0);
            if(hasil == 0) {
                opsiBayar = opsiKirim;
            }else
            {
                opsiBayar = hasil;
            }
            tvPembayaran.setText(String.valueOf(opsiBayarText[opsiBayar]));
        }
        resetTotalHarga();
    }

    public void setOrder()
    {
        //save data to database
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uID = currentUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uID).child("Order");

        HashMap<String, Object> order = new HashMap<>();
        order.put("Id Barang", getIntent().getIntExtra("id", 0));
        order.put("Jumlah Barang", getIntent().getIntExtra("jumlah", 0));
        order.put("Opsi Kirim", opsiKirim);
        order.put("Opsi Bayar", opsiBayar);
        order.put("Status", "Belum Dibayar");

        mDatabase.setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    finish();
                }
            }
        });
    }

    private void resetTotalHarga()
    {
        int id = getIntent().getIntExtra("id", 0);
        int jumlah = getIntent().getIntExtra("jumlah", 0);
        Product product = Product.load(Product.class, id);
        long totalHarga = product.harga * jumlah + hargaKirim[opsiKirim];
        String totalHargaText = "RP " + String.valueOf(totalHarga);
        tvTotalHarga.setText(totalHargaText);
    }
}
