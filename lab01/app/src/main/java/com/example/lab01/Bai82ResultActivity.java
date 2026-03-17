package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Bai82ResultActivity extends AppCompatActivity {

    ListView list;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai82result);

        list = findViewById(R.id.list);
        btnBack = findViewById(R.id.btnBack);

        ArrayList<Bai82> ds =
                (ArrayList<Bai82>) getIntent().getSerializableExtra("ds");

        Bai82Adapter adapter = new Bai82Adapter(this, ds);
        list.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}