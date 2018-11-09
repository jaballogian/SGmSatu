package com.example.jaballogian.sgmsatu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaballogian.sgmsatu.model.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataProfilkuActivity extends AppCompatActivity {

    private TextView activityTitle, namaBarang, jumlahBarang, opsiPengiriman, opsiPembayaran;

    private String opsiBayarText[] = {"", "Kartu Kredit", "Atm / Transfer Bank", "Go-Pay", "OVO", "Pulsa"};

    private String opsiKirimText[] = {"", "Kurir Resmi SGM\nditerima dalam 0-1 hari"
            , "JNE REG\nditerima dalam 3-4 hari"
            , "J&T Express\nditerima dalam 5-9 hari"
            , "TIKI\nditerima dalam 3-4 hari"};

    private long hargaKirim[] = {0, 2000, 44000, 47000, 45000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_profilku);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dataProfilLinearLayoutProfilkuFragment);

        activityTitle = (TextView) findViewById(R.id.activityTitleDataProfilkuActivity);
        namaBarang = (TextView) findViewById(R.id.namaBarangTextViewDataProfilkuActivity);
        jumlahBarang = (TextView) findViewById(R.id.jumlahBarangTextViewDataProfilkuActivity);
        opsiPengiriman = (TextView) findViewById(R.id.opsiPengirimanTextViewDataProfilkuActivity);
        opsiPembayaran = (TextView) findViewById(R.id.opsiPembayaranTextViewDataProfilkuActivity);

        final String valueFromProfilkuFragment;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                valueFromProfilkuFragment= null;
            } else {
                valueFromProfilkuFragment= extras.getString("Activity Title");
            }
        } else {
            valueFromProfilkuFragment= (String) savedInstanceState.getSerializable("Activity Title");
        }

        activityTitle.setText(valueFromProfilkuFragment);

        if(valueFromProfilkuFragment.equals("Belum Bayar")){
            Log.d("data", "visible");
            linearLayout.setVisibility(View.VISIBLE);
        }
        else if (valueFromProfilkuFragment.equals("Pengemasan")){

            linearLayout.setVisibility(View.INVISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Pengiriman")){

            linearLayout.setVisibility(View.INVISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Pembatalan")){

            linearLayout.setVisibility(View.VISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Penilaianku")){

            linearLayout.setVisibility(View.INVISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Terakhir Dilihat")){

            linearLayout.setVisibility(View.VISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Favoritku")){

            linearLayout.setVisibility(View.INVISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Postinganku")){

            linearLayout.setVisibility(View.INVISIBLE);
        }
        else if(valueFromProfilkuFragment.equals("Riwayat Pembelian")){

            linearLayout.setVisibility(View.VISIBLE);
        }

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uID = currentUser.getUid();

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(uID).child("Order");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Integer idBarang = Integer.valueOf(dataSnapshot.child("Id Barang").getValue().toString());
                Product product = Product.load(Product.class, idBarang);
                namaBarang.setText(product.judul);

                jumlahBarang.setText(dataSnapshot.child("Jumlah Barang").getValue().toString());

                Integer opsiBayar = Integer.valueOf(dataSnapshot.child("Opsi Bayar").getValue().toString());
                opsiPembayaran.setText(opsiBayarText[opsiBayar]);

                Integer opsiKirim = Integer.valueOf(dataSnapshot.child("Opsi Kirim").getValue().toString());
                opsiPengiriman.setText(opsiKirimText[opsiKirim]);

//                String status = dataSnapshot.child("Status").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
