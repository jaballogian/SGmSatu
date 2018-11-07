package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.example.jaballogian.sgmsatu.model.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    private FirebaseAuth mAuth;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    transaction.replace(R.id.frameContainerMainActivity, new BerandaFragment()).commit();
                    //mTextMessage.setText("Beranda");
                    return true;
                case R.id.navigation_help:
                    transaction.replace(R.id.frameContainerMainActivity, new BantuanFragment()).commit();
                    //mTextMessage.setText("Bantuan");
                    return true;
                case R.id.navigation_pesan:
                    transaction.replace(R.id.frameContainerMainActivity, new PesanFragment()).commit();
                    //mTextMessage.setText("Pesan");
                    return true;
                case R.id.navigation_notifikasi:
                    transaction.replace(R.id.frameContainerMainActivity, new NotifikasiFragment()).commit();
                    //mTextMessage.setText("Notifikasi");
                    return true;
                case R.id.navigation_profilku:
                    transaction.replace(R.id.frameContainerMainActivity, new ProfilkuFragment()).commit();
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

        ActiveAndroid.initialize(this);
        initializeModel();

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){

            Intent toLogInActivity = new Intent(this, LogInActivity.class);
            startActivity(toLogInActivity);
            finish();
        }

    }

    public void initializeModel()
    {
        Product.truncate(Product.class);
        for(int i = 0; i < 12; i++) {
            List<Product> products = Product.listAll();

            String judul = "Produk sgm dengan prodak terlaris " + String.valueOf(products.size());
            Product product = new Product(
                    "sgm",
                    judul,
                    "Coklat",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                    (i+1)*1000
            );
            product.save();
        }
        Log.d("sgminit", "complete initialize model");
        List<Product> products = Product.listAll();
        for (Product product:products) {
            Log.d("sgm", String.valueOf(product.getId())+ " => " + product.toString());
        }
    }

}
