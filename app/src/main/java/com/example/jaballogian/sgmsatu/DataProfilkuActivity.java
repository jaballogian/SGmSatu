package com.example.jaballogian.sgmsatu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataProfilkuActivity extends AppCompatActivity {

    private TextView activityTitle, namaBarang, jumlahBarang, opsiPengiriman, opsiPembayaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_profilku);

        activityTitle = (TextView) findViewById(R.id.activityTitleDataProfilkuActivity);
        namaBarang = (TextView) findViewById(R.id.namaBarangTextViewDataProfilkuActivity);
        jumlahBarang = (TextView) findViewById(R.id.jumlahBarangTextViewDataProfilkuActivity);
        opsiPengiriman = (TextView) findViewById(R.id.opsiPengirimanTextViewDataProfilkuActivity);
        opsiPembayaran = (TextView) findViewById(R.id.opsiPembayaranTextViewDataProfilkuActivity);

        String valueFromProfilkuFragment;
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

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uID = currentUser.getUid();

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(uID).child("Order");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String idBarang = dataSnapshot.child("Id Barang").getValue().toString();
//                if(idBarang)

                jumlahBarang.setText(dataSnapshot.child("Jumlah Barang").getValue().toString());

                String opsiBayar = dataSnapshot.child("Opsi Bayar").getValue().toString();
//                if(opsiBayar)

                String opsiKirim = dataSnapshot.child("Opsi Kirim").getValue().toString();
//                if(opsiKirim)

                String status = dataSnapshot.child("Status").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(valueFromProfilkuFragment == "Belum Bayar"){


        }
        else if (valueFromProfilkuFragment == "Pengemasan"){


        }
        else if(valueFromProfilkuFragment == "Pengiriman"){


        }
        else if(valueFromProfilkuFragment == "Pembatalan"){


        }
        else if(valueFromProfilkuFragment == "Penilaianku"){


        }
        else if(valueFromProfilkuFragment == "Terakhir Dilihat"){


        }
        else if(valueFromProfilkuFragment == "Favoritku"){


        }
        else if(valueFromProfilkuFragment == "Postinganku"){


        }
        else if(valueFromProfilkuFragment == "Riwayat Pembelian"){


        }
    }
}
