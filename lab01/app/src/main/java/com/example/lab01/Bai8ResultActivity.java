package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8ResultActivity extends AppCompatActivity {
    TextView txtds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8result);

        txtds = findViewById(R.id.txtds);
        Intent intent = getIntent();
        ArrayList<String> ds = intent.getStringArrayListExtra("ds");
        String kq = "";
        for(String s : ds){
            kq += s + "\n";
        }
        txtds.setText(kq);
    }
}
