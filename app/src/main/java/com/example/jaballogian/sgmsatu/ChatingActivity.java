package com.example.jaballogian.sgmsatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatingActivity extends AppCompatActivity {

    private TextView namaPengirim, isiPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chating);

        namaPengirim = (TextView) findViewById(R.id.namaPengirimTextViewChatingActivity);
        isiPesan = (TextView) findViewById(R.id.isiPesanTextViewChatingActivity);

        String dataNamaPengirim, dataIsiPesan;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                dataNamaPengirim= null;
                dataIsiPesan=null;
            } else {
                dataNamaPengirim= extras.getString("Nama Pengirim Pesan");
                dataIsiPesan= extras.getString("Isi Pesan");
            }
        } else {
            dataNamaPengirim = (String) savedInstanceState.getSerializable("Nama Pengirim Pesan");
            dataIsiPesan = (String) savedInstanceState.getSerializable("Isi Pesan");
        }

        namaPengirim.setText(dataNamaPengirim);
        isiPesan.setText(dataIsiPesan);
    }
}
