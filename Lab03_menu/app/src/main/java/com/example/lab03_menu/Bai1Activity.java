package com.example.lab03_menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bai1, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mmuadd){
            Toast.makeText(this, "Bạn đã chọn Add", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.mnusetting){
            Toast.makeText(this, "Bạn đã chọn Settings", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnurefresh) {
            Toast.makeText(this, "Bạn đã chọn Refresh", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.mnualbum){
            Toast.makeText(this, "Bạn đã chọn Sellect Album", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.phone) {
            Toast.makeText(this, "Bạn đã chọn Phone", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.email) {
            Toast.makeText(this, "Bạn đã chọn Email", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}