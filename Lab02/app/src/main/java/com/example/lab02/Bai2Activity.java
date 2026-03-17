package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Bai2Activity extends AppCompatActivity {
    EditText txt;
    Button btnnhap;
    TextView tv;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt = findViewById(R.id.txt);
        btnnhap = findViewById(R.id.btnnhap);
        lv = findViewById(R.id.lv);
        tv = findViewById(R.id.tv);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        addAction();
    }
    private void addAction(){
        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dulieu = txt.getText().toString();
                if(dulieu.isEmpty()){
                    Toast.makeText(Bai2Activity.this,"Chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
                }else{
                    arrayList.add(dulieu);
                    adapter.notifyDataSetChanged();
                    txt.setText("");
                }
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText("Vị trí: " + position + "  Giá trị: " + arrayList.get(position));
            }
        });
    }
}
