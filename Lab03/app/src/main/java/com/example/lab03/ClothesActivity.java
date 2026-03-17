package com.example.lab03;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ClothesActivity extends AppCompatActivity {
    GridView lvclothes;
    List<Clothes> list;
    ClothesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clothes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
    }
    private void initData(){
        lvclothes = findViewById(R.id.lvclothes);
        initClothes();
        adapter = new ClothesAdapter(this, R.layout.line_clothes, list);
        lvclothes.setAdapter(adapter);
    }
    private void initClothes(){
        list = new ArrayList<>();
        list.add(new Clothes("Quần ống rộng", "120.000đ", R.drawable.quan));
        list.add(new Clothes("Tất", "20.000đ", R.drawable.tat));
        list.add(new Clothes("Áo chống nắng", "150.000đ", R.drawable.ao_chong_nang));
        list.add(new Clothes("Áo giữ nhiệt", "100.000đ", R.drawable.ao_giu_nhiet));
        list.add(new Clothes("Áo phao", "300.000đ", R.drawable.ao_phao));
        list.add(new Clothes("Áo hodie form rộng", "200.000đ", R.drawable.hoodie));
        list.add(new Clothes("Áo hoodie zip", "250.000đ", R.drawable.hoodie_zip));
    }
}