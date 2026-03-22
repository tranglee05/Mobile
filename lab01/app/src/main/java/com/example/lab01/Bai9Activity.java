package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Bai9Activity extends AppCompatActivity {
    EditText txtname, txtDes;
    Button btnOn, btnXem, btnHuy;
    ImageView imgavatar;
    RadioGroup radioGroup;
    CheckBox cbvb;
    ArrayList<Bai9> ds = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai9);

        txtname = findViewById(R.id.txtname);
        txtDes = findViewById(R.id.txtDes);
        btnOn = findViewById(R.id.btnOn);
        btnXem = findViewById(R.id.btnXem);
        btnHuy = findViewById(R.id.btnHuy);
        imgavatar = findViewById(R.id.imgavatar);
        radioGroup = findViewById(R.id.radioGroup);
        cbvb = findViewById(R.id.cbvb);

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = txtname.getText().toString();
                String des = txtDes.getText().toString();
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton r = findViewById(id);
                String gt = r.getText().toString();
                int avatar = R.drawable.ic_launcher_foreground;
                boolean vb = cbvb.isChecked();
                ds.add(new Bai9(ten, gt, des, vb, avatar));
                Toast.makeText(Bai9Activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai9Activity.this, Bai9ResultActivity.class);
                intent.putExtra("ds", ds);
                startActivity(intent);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtname.setText("");
                txtDes.setText("");
                radioGroup.clearCheck();
                cbvb.setChecked(false);
            }
        });
    }
}