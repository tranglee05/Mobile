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

public class Bai72Activity extends AppCompatActivity {
    EditText txta, txtb, txtc;
    TextView ketqua;
    Button btngiai, btnxoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai72);
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
        txtc = findViewById(R.id.txtc);
        addAction();
    }
    private void addAction(){
        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float a = Float.parseFloat(txta.getText().toString());
                Float b = Float.parseFloat(txtb.getText().toString());
                Float c = Float.parseFloat(txtc.getText().toString());
                Intent intent = new Intent(Bai72Activity.this, Bai72ResultActivity.class);
                intent.putExtra("soa", a);
                intent.putExtra("sob", b);
                intent.putExtra("soc", c);
                startActivityForResult(intent, 1);
             }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txta.setText("");
                txtb.setText("");
                txtc.setText("");
                ketqua.setText("");
                Toast.makeText(Bai72Activity.this, "Đã xoá dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            String kq = data.getStringExtra("ketqua");
            ketqua.setText(kq);
        }
    }
}
