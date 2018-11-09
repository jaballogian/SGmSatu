package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PembayaranActivity extends AppCompatActivity {

    LinearLayout llKartuKredit, llAtm, llGopay, llOvo, llPulsa;

    ImageButton imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        bindView();
        bindEvent();
    }

    private void bindView(){
        llKartuKredit = (LinearLayout) findViewById(R.id.kartuKreditLinearLayoutPembayaranActivity);
        llAtm = (LinearLayout) findViewById(R.id.atmLinearLayoutPembayaranActivity);
        llGopay = (LinearLayout) findViewById(R.id.gopayLinearLayoutPembayaranActivity);
        llOvo = (LinearLayout) findViewById(R.id.ovoLinearLayoutPembayaranActivity);
        llPulsa = (LinearLayout) findViewById(R.id.pulsaLinearLayoutPembayaranActivity);
        imgBtnBack = (ImageButton) findViewById(R.id.backImageButtonPembayaranActivity);
    }

    private void bindEvent(){

        llKartuKredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(1);
            }
        });

        llAtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(2);
            }
        });

        llGopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(3);
            }
        });

        llOvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(4);
            }
        });

        llPulsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(5);
            }
        });

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setReturn(int hasil)
    {
        Intent intent=new Intent();
        intent.putExtra("hasil", hasil);
        setResult(2,intent);
        finish();//finishing activity
    }

    @Override
    public void onBackPressed() {
        //Include the code here
        Intent intent=new Intent();
        intent.putExtra("hasil", 0);
        setResult(1,intent);
        finish();//finishing activity
        return;
    }

}
