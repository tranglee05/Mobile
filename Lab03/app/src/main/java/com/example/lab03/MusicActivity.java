package com.example.lab03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends AppCompatActivity {
    ListView lvmusic;
    List<Music> list;
    MusicAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_music);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
    }
    private void initData(){
        lvmusic = findViewById(R.id.lvmusic);
        initMusic();
        adapter = new MusicAdapter(this, R.layout.line_music, list);
        lvmusic.setAdapter(adapter);
    }
    private void initMusic(){
        list = new ArrayList<>();
        list.add(new Music("Someone like you", "Adele", "4:45", R.drawable.adele));
        list.add(new Music("All my day", "Alexi Murdoch", "5:00", R.drawable.alexi));
        list.add(new Music("Ocean so slowly ", "Listenume", "3:36", R.drawable.listenume));
        list.add(new Music("Only with you ", "Roy Orbison", "4:00", R.drawable.roy));
    }
}
