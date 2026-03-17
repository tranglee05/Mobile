package com.example.lab01;

import android.content.Intent;
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

import java.util.ArrayList;

public class Bai8Activity extends AppCompatActivity {
    Button btnadd, btnin;
    EditText txtten, txtqq;
    CheckBox cbnam, cbnu;
    ArrayList<String> ds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnadd = findViewById(R.id.btnadd);
        btnin = findViewById(R.id.btnin);
        txtten = findViewById(R.id.txtten);
        txtqq = findViewById(R.id.txtqq);
        cbnam = findViewById(R.id.cbnam);
        cbnu = findViewById(R.id.cbnu);
        addAction();
    }
    private void addAction(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = txtten.getText().toString();
                String qq = txtqq.getText().toString();
                String gt;
                if(cbnam.isChecked()){
                    gt = "Nam";
                }
                else {gt = "Nữ";}
                String tt = ten + "-" + gt + "-" + qq;
                ds.add(tt);
                Toast.makeText(Bai8Activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                txtten.setText("");
                txtqq.setText("");
            }
        });
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai8Activity.this, Bai81ResultActivity.class);
                intent.putStringArrayListExtra("ds", ds);
                startActivity(intent);
            }
        });
    }
}
