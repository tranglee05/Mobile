package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class popupmenu extends AppCompatActivity {
    Button btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_popmenu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnmenu = findViewById(R.id.btnmenu);
        showmenu();
    }
    private void showmenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnmenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.mnuCalling){
                    openCalling();
                }else if(item.getItemId() == R.id.mnuCamera){
                    openCamera();
                }else if(item.getItemId() == R.id.mnuGoogle){
                    openGoogle();
                }else if(item.getItemId() == R.id.mnuSMS){
                    openSMS();
                }else if(item.getItemId() == R.id.mnuMap){
                    openMap();
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void openCalling(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // 2. Nếu chưa có quyền, thực hiện xin quyền
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);

        } else {
            // 3. Nếu đã có quyền, thực hiện cuộc gọi ngay lập tức
            Intent intent = new Intent(Intent.ACTION_CALL); // Đổi sang ACTION_CALL
            intent.setData(Uri.parse("tel:0829662312"));
            startActivity(intent);
        }
    }
    private void openCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1234);
    }
    private void openGoogle(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com"));
        startActivity(intent);
    }
    private void openSMS(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:0829662312"));
        startActivity(intent);
    }
    private void openMap(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://map.coccoc.com/map/1127099122318871?borders=20.978130031116795,105.77868461608888,20.992053982740604,105.81164360046388"));
        startActivity(intent);
    }
}
