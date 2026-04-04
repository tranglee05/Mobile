package com.example.lab03_menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bai2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnusearch) {
            Toast.makeText(this, "Bạn đã chọn Search", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnucong) {
            Toast.makeText(this, "Bạn đã chọn Add", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnuadd) {
            Toast.makeText(this, "Bạn đã chọn Add", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnuupdate) {
            Toast.makeText(this, "Bạn đã chọn Update", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnudelete) {
            Toast.makeText(this, "Bạn đã chọn Delete", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnufeedback) {
            Toast.makeText(this, "Bạn đã chọn Feedback", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnuhelp) {
            Toast.makeText(this, "Bạn đã chọn Help", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}