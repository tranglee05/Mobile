package com.example.lab03;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends AppCompatActivity {
    ListView lvfruit;
    List<Fruit> list;
    FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
    }
    private void initData() {
        lvfruit = findViewById(R.id.lvfruit);
        initFruit();
        adapter = new FruitAdapter(this, R.layout.line_fruit, list);
        lvfruit.setAdapter(adapter);
    }
    private void initFruit() {
        list = new ArrayList<>();
        list.add(new Fruit("Apple", "Red", R.drawable.apple));
        list.add(new Fruit("Banana", "Yellow", R.drawable.banana));
        list.add(new Fruit("Grapes", "Purple", R.drawable.grapes));
        list.add(new Fruit("Orange", "Orange", R.drawable.orange));
        list.add(new Fruit("Strawberry", "Red", R.drawable.strawberry));
        list.add(new Fruit("Watermelon", "Green", R.drawable.watermelon));
        list.add(new Fruit("Mango", "Yellow", R.drawable.mango));
        list.add(new Fruit("Pineapple", "Yellow", R.drawable.pineapple));
    }
}
