package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8ResultActivity extends AppCompatActivity {
    TextView txtds;
    Button btnQL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8result);

        txtds = findViewById(R.id.txtds);
        btnQL = findViewById(R.id.btnQL);
        Intent intent = getIntent();
        ArrayList<String> ds = intent.getStringArrayListExtra("ds");
        String kq = "";
        for(String s : ds){
            kq += s + "\n";
        }
        txtds.setText(kq);
        btnQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
