package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Bai82Activity extends AppCompatActivity {

    EditText txtTen, txtQue;
    RadioGroup radioGroup;
    Button btnThem, btnIn;

    ArrayList<Bai82> ds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai82);

        txtTen = findViewById(R.id.txtTen);
        txtQue = findViewById(R.id.txtQue);
        radioGroup = findViewById(R.id.radioGroup);
        btnThem = findViewById(R.id.btnThem);
        btnIn = findViewById(R.id.btnIn);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = txtTen.getText().toString();
                String que = txtQue.getText().toString();

                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton r = findViewById(id);
                String gt = r.getText().toString();

                int avatar = R.drawable.ic_launcher_foreground;

                ds.add(new Bai82(ten, gt, que, avatar));

                Toast.makeText(Bai82Activity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai82Activity.this, Bai82ResultActivity.class);
                intent.putExtra("ds", ds);
                startActivity(intent);
            }
        });
    }
}