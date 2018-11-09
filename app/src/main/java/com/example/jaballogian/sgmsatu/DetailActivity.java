package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaballogian.sgmsatu.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    Integer id;

    TextView judul, rasa, deskripsi, harga;
    ImageView gambar;

    Button btnKurang, btnTambah, btnBeliProduct;
    EditText etJumlah;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        id = getIntent().getIntExtra("id", 0);
        Log.d("sgmdetail", id.toString());
        bindView();
        bindEvent();
        Product product = Product.load(Product.class, id);
        int drawableId = getResources().getIdentifier(product.gambar, "drawable", "com.example.jaballogian.sgmsatu");
        gambar.setImageResource(drawableId);
        judul.setText(product.judul);
        rasa.setText(product.rasa);
        deskripsi.setText(product.deskripsi);
        String textHarga = "IDR " + String.valueOf(product.harga);
        harga.setText(textHarga);
    }

    public void bindView()
    {
        judul = (TextView) findViewById(R.id.judulTextViewDetailActivity);
        rasa = (TextView) findViewById(R.id.rasaTextViewDetailActivity);
        harga = (TextView) findViewById(R.id.hargaTextViewDetailActivity);
        deskripsi = (TextView) findViewById(R.id.deskripsiTextViewDetailActivity);
        gambar = (ImageView) findViewById(R.id.gambarImageViewDetailActivity);
        etJumlah = (EditText) findViewById(R.id.jumlahEditTextDetailActivity);
        btnKurang = (Button) findViewById(R.id.kurangButtonDetailActivity);
        btnTambah = (Button) findViewById(R.id.tambahButtonDetailActivity);
        btnBeliProduct = (Button) findViewById(R.id.beliProductButtonDetailActivity);
    }

    public void bindEvent()
    {
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer jumlah = 0;
                try{
                    jumlah = Integer.valueOf(etJumlah.getText().toString());
                }catch (Exception e) {
                    /* This is a generic Exception handler which means it can handle
                     * all the exceptions. This will execute if the exception is not
                     * handled by previous catch blocks.
                     */
                    System.out.println("Exception occurred");
                };

                if(jumlah > 0)
                {
                    jumlah--;
                }
                etJumlah.setText(String.valueOf(jumlah));
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer jumlah = 0;
                try{
                    jumlah = Integer.valueOf(etJumlah.getText().toString());
                }catch (Exception e) {
                    /* This is a generic Exception handler which means it can handle
                     * all the exceptions. This will execute if the exception is not
                     * handled by previous catch blocks.
                     */
                    System.out.println("Exception occurred");
                };
                jumlah++;
                etJumlah.setText(String.valueOf(jumlah));
            }
        });

        btnBeliProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCheckout = new Intent(DetailActivity.this, CheckoutActivity.class);
                toCheckout.putExtra("id", id);
                toCheckout.putExtra("jumlah", Integer.valueOf(etJumlah.getText().toString()));
                startActivity(toCheckout);
            }
        });


    }


}
