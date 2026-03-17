package com.example.lab01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai4Activity extends AppCompatActivity {
    Button btnlog;
    CheckBox cbsave;
    EditText txtuser, txtpass;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        preferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnlog = findViewById(R.id.btnlog);
        cbsave = findViewById(R.id.cbsave);
        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);
        addAction();
    }
    private void addAction(){
        String user = txtuser.getText().toString();
        String pass = txtpass.getText().toString();
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.equals("admin") && pass.equals("123")){
                    Toast.makeText(Bai4Activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if(cbsave.isChecked()){
                        saveData(user, pass);
                    }
                    else {
                        clearData();
                    }
                }
                else {
                    Toast.makeText(Bai4Activity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void saveData(String user, String pass){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", user);
        editor.putString("pass", pass);
        editor.putBoolean("checked", true);
        editor.apply();
    }
    private void clearData(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
