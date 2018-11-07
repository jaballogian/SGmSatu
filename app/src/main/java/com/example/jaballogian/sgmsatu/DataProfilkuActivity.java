package com.example.jaballogian.sgmsatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class DataProfilkuActivity extends AppCompatActivity {

    private TextView activityTitle;
    private ListView listDataProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_profilku);

        activityTitle = (TextView) findViewById(R.id.activityTitleDataProfilkuActivity);
        listDataProfil = (ListView) findViewById(R.id.listDataProfilListViewDataProfilActivity);

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
    }
}
