package com.example.bt4_t7;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class DanhsachSP extends AppCompatActivity {

    ArrayList<SanPham> arraySanPham;
    ListView lvDanhsach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_sp);

        lvDanhsach = (ListView) findViewById(R.id.lvDanhsach);

        Cursor cursor = MainActivity.db.TruyVanTraVe("Select * from SanPham");
        arraySanPham = new ArrayList<>();
        while (cursor.moveToNext()) {
            arraySanPham.add(new SanPham(cursor.getString(1), cursor.getInt(2), cursor.getBlob(3)));
        }
        CustomAdapter adapter = new CustomAdapter(DanhsachSP.this, R.layout.row_listview, arraySanPham);
        lvDanhsach.setAdapter(adapter);
    }
}

