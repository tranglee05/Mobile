package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai9ResultActivity extends AppCompatActivity {
    ListView list;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9result);
        list = findViewById(R.id.list);
        btnBack = findViewById(R.id.btnBack);
        ArrayList<Bai9> ds= (ArrayList<Bai9>) getIntent().getSerializableExtra("ds");
        Bai9Adapter adapter = new Bai9Adapter(this, ds, R.layout.line_bai9);
        list.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
