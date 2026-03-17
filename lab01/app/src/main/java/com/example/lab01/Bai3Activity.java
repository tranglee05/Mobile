package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai3Activity extends AppCompatActivity {
    CheckBox cbnam, cbnu, cbkhac;
    Button btncheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btncheck = findViewById(R.id.btncheck);
        cbnam = findViewById(R.id.cbnam);
        cbnu = findViewById(R.id.cbnu);
        cbkhac = findViewById(R.id.cbkhac);
        addAction();
    }
    private void addAction(){
        cbnam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(Bai3Activity.this, "Bạn chọn nam", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbnu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(Bai3Activity.this, "Bạn chọn nữ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbkhac.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(Bai3Activity.this, "Bạn chọn khác", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Bạn chọn: ";
                        if(cbnam.isChecked()) result += "Nam";
                        if(cbnu.isChecked()) result += "Nữ";
                        if(cbkhac.isChecked()) result += "Khác";
                        Toast.makeText(Bai3Activity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}