package com.example.myapplication;

import android.app.ComponentCaller;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImpliciActivity extends AppCompatActivity {
    ImageButton btnCalling, btnCamera, btnMap, btngg, btnsms;
    ImageView imgAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_implici);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mapping();
        addAction();
    }
    private void addAction() {
        btnCalling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0829662312"));
                startActivity(intent);
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1234);
            }
        });
        btngg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com"));
                startActivity(intent);
            }
        });
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("sms:0829662312"));
                startActivity(intent);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://map.coccoc.com/map/1127099122318871?borders=20.978130031116795,105.77868461608888,20.992053982740604,105.81164360046388"));
                startActivity(intent);
            }
        });
    }
        private void mapping(){
            btnCalling = (ImageButton) findViewById(R.id.btnCalling);
            btnCamera = (ImageButton) findViewById(R.id.btnCamera);
            imgAnh = (ImageView) findViewById(R.id.imgAnh);
            btnMap= (ImageButton) findViewById(R.id.btnMap);
            btngg = (ImageButton) findViewById(R.id.btngg);
            btnsms = (ImageButton) findViewById(R.id.btnsms);
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);
        if(requestCode == 1234){
            if(resultCode == RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgAnh.setImageBitmap(bitmap);

            }else {
                Toast.makeText(this, "User refured", Toast.LENGTH_SHORT).show();
            }
        }
    }
}