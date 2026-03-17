package com.example.myapplication;

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

public class FootballActivity extends AppCompatActivity {
   // ListView lvFootball;
    GridView lvFootball;
    List<Football> list;
    FootballAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_football);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
    }
    private void initData(){
        lvFootball = findViewById(R.id.lvFootball);
        initFootball();
        adapter = new FootballAdapter(this, R.layout.activity_main, list);
        lvFootball.setAdapter(adapter);
    }
    private void initFootball(){
       // adapter.notifyDataSetChanged();
        list = new ArrayList<>();
        list.add(new Football("Nguyễn Công Phượng", "Hoàng anh gia lai", R.drawable.cong_phuong, R.drawable.co_hagl));
        list.add(new Football("Nguyễn Quang Hải", "CLB Hà Nội", R.drawable.quang_hai, R.drawable.co_clb_hanoi));
        list.add(new Football("Vũ Văn Thanh", "Hoàng anh gia lai", R.drawable.van_thanh, R.drawable.co_hagl));
        list.add(new Football("Nguyễn Xuân Trường", "CLB Hà Nội", R.drawable.xuan_truong, R.drawable.co_clb_hanoi));
        list.add(new Football("Nguyễn Văn Toàn", "Hoàng anh gia lai", R.drawable.van_toan, R.drawable.co_hagl));
    }
}
