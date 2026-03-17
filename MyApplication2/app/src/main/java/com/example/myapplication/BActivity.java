package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BActivity extends AppCompatActivity {
    TextView txtName;
    TextView txtAddress;
    ImageView avatar;
    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.b_bactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mapping();
        Intent intent = getIntent();
        /*String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);*/
        Bundle bundle = intent.getBundleExtra("bundle");
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        Football football = (Football) bundle.getSerializable("football");
        txtName.setText(football.getFullname());
        txtAddress.setText(football.getAddress());
        avatar.setImageResource(football.getAvatar());
        flag.setImageResource(football.getFlag());
        Toast.makeText(this, "Name: " + name + "\nAge: " + age, Toast.LENGTH_SHORT).show();
        //Gửi kq lại cho màn hình a
        Intent data = new Intent();
        data.putExtra("Thông báo","Đã nhận ủ thông tin");
        setResult(RESULT_OK, data);

    }
    private void mapping(){
        txtName = findViewById(R.id.txtFullname2);
        txtAddress = findViewById(R.id.txtAddress2);
        avatar = findViewById(R.id.imgAvatar2);
        flag = findViewById(R.id.imgFlag2);
    }
}