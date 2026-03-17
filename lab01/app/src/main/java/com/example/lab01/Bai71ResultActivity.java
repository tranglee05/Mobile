package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Bai71ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        float a = intent.getFloatExtra("soa", 0);
        float b = intent.getFloatExtra("sob", 0);

        String ketqua;

        if(a == 0){
            if(b == 0){
                ketqua = "Phương trình vô số nghiệm";
            } else {
                ketqua = "Phương trình vô nghiệm";
            }
        } else {
            float x = -b / a;
            ketqua = "x = " + x;
        }

        Intent resultIntent = new Intent();
        resultIntent.putExtra("ketqua", ketqua);

        setResult(RESULT_OK, resultIntent);
        finish();
    }
}