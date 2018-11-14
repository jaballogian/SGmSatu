package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BeliProdukActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_produk);
        bindView();
    }

    @Override
    public void onClick(View v) {
        // default method for handling onClick Events..
        Intent main = new Intent(v.getContext(), DetailActivity.class);
        switch (v.getId()) {
            case R.id.bp0side0ImageViewBeliProdukActivity:
            case R.id.bp1side0ImageViewBeliProdukActivity:
            case R.id.bp2side0ImageViewBeliProdukActivity:
            case R.id.bp3side0ImageViewBeliProdukActivity:
                main.putExtra("id", 1);
                break;

            case R.id.bp0side1ImageViewBeliProdukActivity:
            case R.id.bp1side1ImageViewBeliProdukActivity:
            case R.id.bp2side1ImageViewBeliProdukActivity:
            case R.id.bp3side1ImageViewBeliProdukActivity:
                main.putExtra("id", 2);
                break;

            case R.id.bp0side2ImageViewBeliProdukActivity:
            case R.id.bp1side2ImageViewBeliProdukActivity:
            case R.id.bp2side2ImageViewBeliProdukActivity:
            case R.id.bp3side2ImageViewBeliProdukActivity:
                main.putExtra("id", 3);
                break;

            case R.id.bp0side3ImageViewBeliProdukActivity:
            case R.id.bp1side3ImageViewBeliProdukActivity:
            case R.id.bp2side3ImageViewBeliProdukActivity:
            case R.id.bp3side3ImageViewBeliProdukActivity:
                main.putExtra("id", 4);
                break;

            case R.id.bp0side4ImageViewBeliProdukActivity:
            case R.id.bp1side4ImageViewBeliProdukActivity:
            case R.id.bp2side4ImageViewBeliProdukActivity:
            case R.id.bp3side4ImageViewBeliProdukActivity:
                main.putExtra("id", 5);
                break;

            case R.id.bp0side5ImageViewBeliProdukActivity:
            case R.id.bp1side5ImageViewBeliProdukActivity:
            case R.id.bp2side5ImageViewBeliProdukActivity:
                main.putExtra("id", 6);
                break;

            default:
                return;
        }
        startActivity(main);
    }

    private void bindView()
    {
        ((ImageView) findViewById(R.id.bp0side0ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp0side1ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp0side2ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp0side3ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp0side4ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp0side5ImageViewBeliProdukActivity)).setOnClickListener(this);

        ((ImageView) findViewById(R.id.bp1side0ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp1side1ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp1side2ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp1side3ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp1side4ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp1side5ImageViewBeliProdukActivity)).setOnClickListener(this);

        ((ImageView) findViewById(R.id.bp2side0ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp2side1ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp2side2ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp2side3ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp2side4ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp2side5ImageViewBeliProdukActivity)).setOnClickListener(this);

        ((ImageView) findViewById(R.id.bp3side0ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp3side1ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp3side2ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp3side3ImageViewBeliProdukActivity)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bp3side4ImageViewBeliProdukActivity)).setOnClickListener(this);
    }
}
