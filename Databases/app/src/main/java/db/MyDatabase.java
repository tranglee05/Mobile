package db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    String context;
    public static final String dbName= "csdl_sach.sqllite";
    public static final int version = 2;
    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MyDatabase(@Nullable Context context) {
        super(context, dbName, null, version);
    }
    public void exceSQL(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY autoincrement,BookName text, Page integer, Price Float, Description text)";
        sqLiteDatabase.execSQL(sql);
//                + "INSERT INTO BOOKSVALUES(1, 'Java', 100,99990, 'sách về java');\n"
//                + "INSERT INTO BOOKSVALUES(2, 'Android', 320, 1900, 'Android cơ bản');\n"
//                + "INSERT INTO BOOKSVALUES(3, 'Họclàmgiàu',120,9900, 'sách đọc cho vui');\n"
//                + "INSERT INTO BOOKSVALUES(4, 'TửđiểnAnh-Việt',1000,50000, 'Từ điển 100.000 từ');\n"
//                +"INSERTINTOBOOKSVALUES(5,'CNXH', 1, 1, 'chuyện cổ tích');";
        Log.d("BOOKS", "DB create OK");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public Cursor selectSQL(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }
}
