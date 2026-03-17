package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai7Activity extends AppCompatActivity {
    EditText txta, txtb;
    TextView ketqua;
    Button btngiai, btnxoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btngiai = findViewById(R.id.btngiai);
        btnxoa = findViewById(R.id.btnxoa);
        ketqua = findViewById(R.id.ketqua);
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        addAction();
    }
    private void addAction(){

        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txta.getText().toString().isEmpty() ||
                        txtb.getText().toString().isEmpty()){
                    Toast.makeText(Bai7Activity.this,"Nhập đủ a và b",Toast.LENGTH_SHORT).show();
                    return;
                }
                float a = Float.parseFloat(txta.getText().toString());
                float b = Float.parseFloat(txtb.getText().toString());

                if(a == 0){
                    if(b == 0){
                        ketqua.setText("Phương trình vô số nghiệm");
                    }
                    else {
                        ketqua.setText("Phương trình vô nghiệm");
                    }
                }
                else {
                    float x = -b / a;
                    ketqua.setText("Phương trình có nghiệm x = " + x);
                }
            }
        });

        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txta.setText("");
                txtb.setText("");
                ketqua.setText("");
                Toast.makeText(Bai7Activity.this,"Đã xoá",Toast.LENGTH_SHORT).show();
            }
        });
    }
}