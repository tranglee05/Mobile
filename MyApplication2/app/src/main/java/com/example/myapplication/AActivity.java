package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AActivity extends AppCompatActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.a_aactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                int age = 30;
                String name = "Nguyễn Văn A";
                Bundle bundle = new Bundle();
                bundle.putInt("age", age);
                bundle.putString("name", name);
                /*intent.putExtra("age", age);
                intent.putExtra("name", name);*/

                Football football = new Football("Nguyễn Văn A", "Hà Nội", R.drawable.cong_phuong, R.drawable.co_hagl);
                bundle.putSerializable("football", football);
                intent.putExtra("bundle", bundle);
                startActivityForResult(intent, 123);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123){
            if(resultCode == RESULT_OK){
                String thongbao = data.getStringExtra("Thông báo");
                Toast.makeText(this, ""+thongbao, Toast.LENGTH_SHORT).show();
            }
        }
    }
}