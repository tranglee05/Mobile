package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bai71Activity extends AppCompatActivity {

    EditText txta, txtb;
    TextView ketqua;
    Button btngiai, btnxoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai71);

        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        ketqua = findViewById(R.id.ketqua);
        btngiai = findViewById(R.id.btngiai);
        btnxoa = findViewById(R.id.btnxoa);

        addAction();
    }

    private void addAction(){

        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txta.getText().toString().isEmpty() ||
                        txtb.getText().toString().isEmpty()){
                    Toast.makeText(Bai71Activity.this,"Nhập đủ a và b",Toast.LENGTH_SHORT).show();
                    return;
                }

                float a = Float.parseFloat(txta.getText().toString());
                float b = Float.parseFloat(txtb.getText().toString());

                Intent intent = new Intent(Bai71Activity.this, Bai71ResultActivity.class);
                intent.putExtra("soa", a);
                intent.putExtra("sob", b);

                startActivityForResult(intent, 1);
            }
        });

        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txta.setText("");
                txtb.setText("");
                ketqua.setText("");
                Toast.makeText(Bai71Activity.this,"Đã xoá",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            String kq = data.getStringExtra("ketqua");
            ketqua.setText(kq);
        }
    }
}