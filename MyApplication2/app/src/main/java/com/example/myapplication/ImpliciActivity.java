package com.example.myapplication;

import android.Manifest;
import android.app.ComponentCaller;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImpliciActivity extends AppCompatActivity {
    ImageButton btnCalling, btnCamera, btnMap, btngg, btnsms;
    Button btnmenu, btnctmnu;
    ImageView imgAnh;
    LinearLayout clManHinh;

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
        registerForContextMenu(btnctmnu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuCalling) {
            openCalling();
        }else if (item.getItemId() == R.id.mnuCamera) {
            openCamera();
        } else if (item.getItemId() == R.id.mnuGoogle) {
            openGoogle();
        } else if (item.getItemId() == R.id.mnuSMS) {
            openSMS();
        } else if (item.getItemId() == R.id.mnuMap) {
            openMap();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addAction() {
        btnCalling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalling();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
        btngg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogle();

            }
        });
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSMS();

            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();

            }
        });
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showmenu();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Chọn màu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.mnuxanh){
            clManHinh.setBackgroundColor(Color.BLUE);
            Toast.makeText(this, "Đã đổi sang màu xanh", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.mnudo) {
            clManHinh.setBackgroundColor(Color.RED);
            Toast.makeText(this, "Đã đổi sang màu đỏ", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.mnuden) {
            clManHinh.setBackgroundColor(Color.BLACK);
            Toast.makeText(this, "Đã đổi sang màu đen", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.mnuvang) {
            clManHinh.setBackgroundColor(Color.YELLOW);
            Toast.makeText(this, "Đã đổi sang màu vàng", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
    private void showmenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnmenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ImpliciActivity.this, "Bạn chọn " + item.getTitle(), Toast.LENGTH_SHORT).show();
                int id = item.getItemId();
                if(id == R.id.mnuthem){
                    btnmenu.setText("Them");
                    return true;
                }else if(id == R.id.mnusua){
                    btnmenu.setText("Sua");
                    return true;
                }else if(id == R.id.mnuxoa){
                    btnmenu.setText("Xoa");
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
        private void mapping(){
            btnCalling = (ImageButton) findViewById(R.id.btnCalling);
            btnCamera = (ImageButton) findViewById(R.id.btnCamera);
            imgAnh = (ImageView) findViewById(R.id.imgAnh);
            btnMap= (ImageButton) findViewById(R.id.btnMap);
            btngg = (ImageButton) findViewById(R.id.btngg);
            btnsms = (ImageButton) findViewById(R.id.btnsms);
            btnmenu = findViewById(R.id.btnmenu);
            btnctmnu = findViewById(R.id.btnctmnu);
            clManHinh = findViewById(R.id.main);
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