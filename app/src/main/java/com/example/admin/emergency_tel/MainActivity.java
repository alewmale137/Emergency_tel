package com.example.admin.emergency_tel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.emergency_tel.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this); //สร้าง obj ของ DatabaseHelper
                SQLiteDatabase db = helper.getWritableDatabase();


                Cursor c = db.query("phone",null,null,null,null,null,null) ;
                c.moveToNext();
                String title = c.getString(c.getColumnIndex("title"));
                String number = c.getString(c.getColumnIndex("number"));
                Log.i("abc","Title: "+title+",Number: "+number);
                 c.close(); // ปิด cursor คือหน่วยความจำให้ระบบ ไม่กินหน่วยความจำเครื่อง

            }
        });
    }
}
