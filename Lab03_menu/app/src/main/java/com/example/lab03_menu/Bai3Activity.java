package com.example.lab03_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai3Activity extends AppCompatActivity {
    Button btnadd, btnshow, btnchon;
    LinearLayout clManHinh;

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
        btnadd = findViewById(R.id.btnadd);
        btnshow = findViewById(R.id.btnshow);
        btnchon = findViewById(R.id.btnchon);
        clManHinh = findViewById(R.id.main);
        registerForContextMenu(btnchon);
        addAction();
    }

    private void addAction() {
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog();
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Bai3Activity.this, btnshow);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu_bai3, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.mnuthem){
                            Toast.makeText(Bai3Activity.this, "Bạn chọn Thêm", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.mnusua) {
                            Toast.makeText(Bai3Activity.this, "Bạn chọn Sửa", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.mnuxoa) {
                            Toast.makeText(Bai3Activity.this, "Bạn chọn Xoá", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.mnuicon) {
                            Toast.makeText(Bai3Activity.this, "Bạn chọn Icon", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
    private void showLoginDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.login_dialog, null);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();
        EditText txtuser = dialogView.findViewById(R.id.txtuser);
        EditText txtpass = dialogView.findViewById(R.id.txtpass);
        Button btndn = dialogView.findViewById(R.id.btndn);
        Button btnhuy = dialogView.findViewById(R.id.btnhuy);
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtuser.getText().toString();
                String pass = txtpass.getText().toString();
                Toast.makeText(Bai3Activity.this, "Tài khoản: "+ user + " Mật khẩu: "+ pass, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmn_bai3, menu);
        menu.setHeaderTitle("Chọn màu nền");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuxanh) {
            clManHinh.setBackgroundColor(Color.BLUE);
            Toast.makeText(this, "Bạn chọn màu xanh", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.mnudo) {
            clManHinh.setBackgroundColor(Color.RED);
            Toast.makeText(this, "Bạn chọn màu đỏ", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.mnuden) {
            clManHinh.setBackgroundColor(Color.BLACK);
            Toast.makeText(this, "Bạn chọn màu đen", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.mnuvang) {
            clManHinh.setBackgroundColor(Color.YELLOW);
            Toast.makeText(this, "Bạn chọn màu vàng", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.mnutrang) {
            clManHinh.setBackgroundColor(Color.WHITE);
            Toast.makeText(this, "Bạn chọn màu trắng", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
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
