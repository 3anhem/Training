package com.example.bai4_tuan6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview = null;
    ArrayList<ArrayList<SanPham>> data = new ArrayList<>();
    Spinner spinner;
    SanPhamAdapter adapter = null;
    Button btnInsert;
    EditText masp, tensp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] arr_loaisp = getResources().getStringArray(R.array.spinner);
        spinner = findViewById(R.id.spinner);

        for (String i:arr_loaisp)
            data.add(new ArrayList<SanPham>());

        listview = (ListView)findViewById(R.id.listview);
        adapter = new SanPhamAdapter(this, R.layout.fragment_row, new ArrayList<SanPham>());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {

                adapter.swapData(data.get(position));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index_loaisp = spinner.getSelectedItemPosition();
                SanPham sp = adapter.getItem(position);
                masp.setText(sp.masp);
                tensp.setText(sp.tensp);
            }
        });

        btnInsert = findViewById(R.id.btn);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSp();
            }
        });
        masp = findViewById(R.id.masp);
        tensp = findViewById(R.id.tensp);
    }
    public SanPham getSp(){
        SanPham sp = new SanPham();
        sp.masp = masp.getText().toString();
        sp.tensp = tensp.getText().toString();
        return sp;
    }
    public void insertSp(){
        SanPham sp = getSp();
        int index_loaisp = spinner.getSelectedItemPosition();
        adapter.add(sp);
        data.get(index_loaisp).add(sp);
        adapter.notifyDataSetChanged();
    }
}
