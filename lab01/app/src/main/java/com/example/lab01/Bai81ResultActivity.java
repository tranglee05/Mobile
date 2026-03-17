package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai81ResultActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai81result);
        list = findViewById(R.id.list);
        Intent intent = getIntent();
        ArrayList<String> ds = intent.getStringArrayListExtra("ds");
        ArrayAdapter adapter = new ArrayAdapter(
                Bai81ResultActivity.this, android.R.layout.simple_list_item_1, ds
        );
        list.setAdapter(adapter);
    }
}
