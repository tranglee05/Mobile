package com.example.lab03_menu;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import db.MyDatabase;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booklist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //MyDatabase myDatabase = new MyDatabase(this);
        MyDatabase myDatabase = new MyDatabase(this, "csdl_sach.sqllite", null, 1);
//        myDatabase.exceSQL("INSERT INTO BOOKSVALUES(1, 'Java', 100,99990, 'sách về java')");
//        myDatabase.exceSQL("INSERT INTO BOOKSVALUES(2, 'Android', 320, 1900, 'Android cơ bản')");
//        myDatabase.exceSQL("INSERT INTO BOOKSVALUES(3, 'Họclàmgiàu',120,9900, 'sách đọc cho vui')");
//        myDatabase.exceSQL("INSERT INTO BOOKSVALUES(4, 'TửđiểnAnh-Việt',1000,50000, 'Từ điển 100.000 từ')");
//        myDatabase.exceSQL("INSERT INTO BOOKSVALUES(5,'CNXH', 1, 1, 'chuyện cổ tích')");
        Cursor c= myDatabase.selectSQL("SELECT * FROM BOOKS");
        while (c.moveToNext()){
            Log.d("AAA", c.getInt(0)+"-" + c.getString(1)+"-" + c.getInt(2)+"-" + c.getInt(3)+"-" + c.getString(4));
        }
        Toast.makeText(this, "DB creater ok", Toast.LENGTH_SHORT).show();
        Log.d("AAA", "OK");
    }
}