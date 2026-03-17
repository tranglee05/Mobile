package com.example.lab01;

import android.annotation.SuppressLint;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai6Activity extends AppCompatActivity {
    Button btnsign;
    EditText txtuser, txtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnsign = findViewById(R.id.btnsign);
        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);
        addAction();
    }
    private void addAction(){
        String user = txtuser.getText().toString();
        String pass = txtpass.getText().toString();
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.isEmpty()){
                    txtuser.setError("This field is required");
                }
                else {
                    Toast.makeText(Bai6Activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}