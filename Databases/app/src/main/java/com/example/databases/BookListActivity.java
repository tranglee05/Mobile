package com.example.databases;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import db.MyDatabase;

public class BookListActivity extends AppCompatActivity {
    EditText txtname, txtpage, txtprice, txtdesc;
    ListView lvData;
    Button btnmenu;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    MyDatabase db;
    int selected = -1;

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

        txtname = findViewById(R.id.txtname);
        txtpage = findViewById(R.id.txtpage);
        txtprice = findViewById(R.id.txtprice);
        txtdesc = findViewById(R.id.txtdesc);
        lvData = findViewById(R.id.lvData);
        btnmenu = findViewById(R.id.btnmenu);
        db = new MyDatabase(this);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvData.setAdapter(adapter);
        loadData();
        addActions();
        //myDatabase.exceSQL("INSERT INTO BOOKS (BookName, Page, Price, Description) VALUES ('Java', 100, 99990, 'sách về java')");
    }

    private void addActions() {
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String item = list.get(i);
                String[] arr = item.split(" - ", 5);
                selected = Integer.parseInt(arr[0].trim());

                txtname.setText(arr[1].trim());
                txtpage.setText(arr[2].trim());
                txtprice.setText(arr[3].trim());
                txtdesc.setText(arr[4].trim());

                Toast.makeText(BookListActivity.this, "Đã chọn ID = " + selected, Toast.LENGTH_SHORT).show();
            }
        });
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(BookListActivity.this, btnmenu);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String name = txtname.getText().toString();
                        String page = txtpage.getText().toString();
                        String price = txtprice.getText().toString();
                        String desc = txtdesc.getText().toString();
                        if (item.getItemId() == R.id.mnuthem) {
                            String sql = "INSERT INTO BOOKS (BookName, Page, Price, Description) VALUES ('" + name + "', " + page + ", " + price + ", '" + desc + "')";
                            db.exceSQL(sql);
                            Toast.makeText(BookListActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                            txtname.setText("");
                            txtpage.setText("");
                            txtprice.setText("");
                            txtdesc.setText("");
                        } else if (item.getItemId() == R.id.mnusua) {
                            if (selected == -1) {
                                Toast.makeText(BookListActivity.this, "Hãy chọn sách trước khi sửa", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                            String sql = "UPDATE BOOKS SET BookName = '" + name + "', Page = " + page + ", Price = " + price + ", Description = '" + desc + "' WHERE BookID = " + selected;
                            db.exceSQL(sql);
                            Toast.makeText(BookListActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                            loadData();
                            selected = -1;
                        } else if (item.getItemId() == R.id.mnuxoa) {
                            if (selected == -1) {
                                Toast.makeText(BookListActivity.this, "Vui lòng chọn sách cần xóa", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                            String sql = "DELETE FROM BOOKS WHERE BookID = " + selected;
                            db.exceSQL(sql);
                            Toast.makeText(BookListActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                            txtname.setText("");
                            txtpage.setText("");
                            txtprice.setText("");
                            txtdesc.setText("");
                        }
                        loadData();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void loadData() {
        list.clear();

        Cursor c = db.selectSQL("SELECT * FROM BOOKS");
        while (c.moveToNext()) {
            String row = c.getInt(0) + " - "
                    + c.getString(1) + " - "
                    + c.getInt(2) + " - "
                    + c.getInt(3) + " - "
                    + c.getString(4);

            list.add(row);
        }

        adapter.notifyDataSetChanged();
    }
}