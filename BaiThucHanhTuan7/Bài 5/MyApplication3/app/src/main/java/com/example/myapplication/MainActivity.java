package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDatabase db;
    ArrayList<SinhVien> data;
    SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MyDatabase(this);
        data = db.getSinhVienS();

        adapter = new SinhVienAdapter(this, R.layout.row_listview, data);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(MainActivity.this, Option.class);
                startActivity(intent);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String selected;
                        int index = position;
                        while ((selected=Option.getOptionSelected())==null);
                        switch (selected){
                            case Option.OPTION_UPDATE: showPopupUpdate(index); break;
                            case Option.OPTION_DELETE: showPopupDelete(index); break;
                            default: break;
                        }
                    }
                }).start();
            }
        });

        FloatingActionButton button_them = findViewById(R.id.them);
        button_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupInsert();
            }
        });
    }

    void showPopupInsert(){
        Intent intent = new Intent(MainActivity.this, PopupUpdate.class);
        startActivity(intent);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MainActivity.this) {
                    SinhVien sv;
                    while (!PopupUpdate.isUpdated() && !PopupUpdate.dismiss());
                    if (PopupUpdate.isUpdated()) {
                        sv = PopupUpdate.getSinhVien();
                        data.add(sv);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        });
        thread.start();
    }

    void showPopupUpdate(int position){
        final SinhVien sv = data.get(position);
        Intent intent = new Intent(MainActivity.this, PopupUpdate.class);
        intent.putExtra(PopupUpdate.EXTRA_ID, sv.ID);
        intent.putExtra(PopupUpdate.EXTRA_NAME, sv.Name);
        intent.putExtra(PopupUpdate.EXTRA_ADRESS, sv.Address);
        intent.putExtra(PopupUpdate.EXTRA_SEX, sv.Sex);
        intent.putExtra(PopupUpdate.EXTRA_IMG, sv.Img);
        startActivity(intent);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MainActivity.this) {
                    while (!PopupUpdate.isUpdated() && !PopupUpdate.dismiss());
                    if (PopupUpdate.isUpdated()) {
                        SinhVien _sv = PopupUpdate.getSinhVien();
                        if (_sv == null) return;
                        sv.Name = _sv.Name;
                        sv.Address = _sv.Address;
                        sv.Sex = _sv.Sex;
                        sv.Img = _sv.Img;
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        });
        thread.start();
    }

    void showPopupDelete(int position){
        final SinhVien sv = data.get(position);
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Xóa Sinh Viên " + sv.Name);
        builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.deleteSinhVien(sv.ID);
                data.remove(sv);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Hủy Bỏ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                builder.show();
            }
        });
    }



}
