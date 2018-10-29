package com.example.jaballogian.sgmsatu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    transaction.replace(R.id.content, new BerandaFragment()).commit();
                    //mTextMessage.setText("Beranda");
                    return true;
                case R.id.navigation_help:
                    transaction.replace(R.id.content, new BantuanFragment()).commit();
                    //mTextMessage.setText("Bantuan");
                    return true;
                case R.id.navigation_pesan:
                    transaction.replace(R.id.content, new PesanFragment()).commit();
                    //mTextMessage.setText("Pesan");
                    return true;
                case R.id.navigation_notifikasi:
                    transaction.replace(R.id.content, new NotifikasiFragment()).commit();
                    //mTextMessage.setText("Notifikasi");
                    return true;
                case R.id.navigation_profilku:
                    transaction.replace(R.id.content, new ProfilkuFragment()).commit();
                    //mTextMessage.setText("Profilku");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
