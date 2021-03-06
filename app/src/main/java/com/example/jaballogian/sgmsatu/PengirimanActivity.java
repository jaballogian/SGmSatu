package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class PengirimanActivity extends AppCompatActivity {

    LinearLayout llResmi, llJne, llJnt, llTiki;

    ImageButton imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengiriman);
        bindView();
        bindEvent();
    }

    private void bindView(){
        llResmi = (LinearLayout) findViewById(R.id.resmiLinearLayoutPengirimanActivity);
        llJne = (LinearLayout) findViewById(R.id.jneLinearLayoutPengirimanActivity);
        llJnt = (LinearLayout) findViewById(R.id.jntLinearLayoutPengirimanActivity);
        llTiki = (LinearLayout) findViewById(R.id.tikiLinearLayoutPengirimanActivity);
        imgBtnBack = (ImageButton) findViewById(R.id.backImageButtonPengirimanActivity);
    }

    private void bindEvent(){

        llResmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(1);
            }
        });

        llJne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(2);
            }
        });

        llJnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(3);
            }
        });

        llTiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReturn(4);
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
