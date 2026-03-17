package com.example.lab03;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {
    ListView lvcountry;
    List<Country> list;
    CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activiy_country);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
    }
    private void initData(){
        lvcountry = findViewById(R.id.lvcountry);
        initCountry();
        adapter = new CountryAdapter(this, R.layout.line_country, list);
        lvcountry.setAdapter(adapter);
    }
    private void initCountry(){
        list = new ArrayList<>();
        list.add(new Country(R.drawable.vietnam,"Việt Nam", "98 million", "331,212 km²"));
        list.add(new Country(R.drawable.my,"United States", "331 million", "9,833,520 km²"));
        list.add(new Country(R.drawable.han,"Korea", "51 million", "100,210 km²"));
        list.add(new Country(R.drawable.phap,"France", "67 million", "551,695 km²"));
        list.add(new Country(R.drawable.nhatban,"Japan", "125 million", "377,975 km²"));
    }
}
