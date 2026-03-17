package com.example.lab02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Bai1Activity extends AppCompatActivity {
    EditText txt;
    Button btnadd, btnsua;
    ListView ds;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt = findViewById(R.id.txt);
        btnadd = findViewById(R.id.btnadd);
        btnsua = findViewById(R.id.btnsua);
        ds = findViewById(R.id.ds);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        addAction();
    }
    private void addAction(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dulieu = txt.getText().toString();
                if(dulieu.isEmpty()){
                    Toast.makeText(Bai1Activity.this,"Chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
                }else{
                    arrayList.add(dulieu);
                    adapter.notifyDataSetChanged();
                    txt.setText("");
                }
            }
        });
        ds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText(arrayList.get(position));
                vitri = position;
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vitri == -1) {
                    Toast.makeText(Bai1Activity.this, "Chọn item cần sửa", Toast.LENGTH_SHORT).show();
                } else {

                    arrayList.set(vitri, txt.getText().toString());
                    adapter.notifyDataSetChanged();
                    txt.setText("");
                    vitri = -1;
                }
            }
        });
        ds.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Bai1Activity.this);

                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn xóa không?");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Không", null);

                builder.show();

                return true;
            }
        });
    }
}