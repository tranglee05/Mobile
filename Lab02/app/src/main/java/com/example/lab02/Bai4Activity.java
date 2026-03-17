package com.example.lab02;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class Bai4Activity extends AppCompatActivity {
    EditText txtcv, txtnd, txtdate, txttime;
    Button btndate, btntime, btnadd;
    ListView ds;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtcv = findViewById(R.id.txtcv);
        txtnd = findViewById(R.id.txtnd);
        txtdate = findViewById(R.id.txtdate);
        txttime = findViewById(R.id.txttime);
        btndate = findViewById(R.id.btndate);
        btntime = findViewById(R.id.btntime);
        btnadd = findViewById(R.id.btnadd);
        ds = findViewById(R.id.ds);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        ds.setAdapter(adapter);
        addAction();
    }
    private void addAction(){
        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(calendar.YEAR);
                int month = calendar.get(calendar.MONTH);
                int day = calendar.get(calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Bai4Activity.this, (view, y, m, d)-> txtdate.setText(d+"/"+m+"/"+y),year,month,day);
                dialog.show();
            }
        });
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(calendar.HOUR_OF_DAY);
                int minute = calendar.get(calendar.MINUTE);
                TimePickerDialog dialog = new TimePickerDialog(Bai4Activity.this, (view, h, m)-> txttime.setText(h+":"+m),hour,minute,true);
                dialog.show();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cv = txtcv.getText().toString();
                String nd = txtcv.getText().toString();
                String date =txtdate.getText().toString();
                String time = txttime.getText().toString();
                if(!cv.isEmpty() && !nd.isEmpty()){
                    String data = cv + "-" + nd + "-" + "-" + date + "-" + time;
                    arrayList.add(data);
                    adapter.notifyDataSetChanged();
                    txtcv.setText("");
                    txtnd.setText("");
                    txttime.setText("");
                    txtdate.setText("");
                }
            }
        });
    }
}
