package vn.edu.vtn.baithuchanhtuan5.country;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.adpter.CountryAdapter;
import vn.edu.vtn.baithuchanhtuan5.model.Country;

public class QuanLyCountry extends AppCompatActivity {
    ListView listView;
    ArrayList<Country> list;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_country);
        addControls();
        addEvents();
    }

    private void addControls() {
        listView = findViewById(R.id.listView);
        list = fakeData();
        adapter = new CountryAdapter(QuanLyCountry.this, R.layout.item_country, list);
        listView.setAdapter(adapter);
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QuanLyCountry.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Country> fakeData() {
        ArrayList<Country> list = new ArrayList<>();
        Country vietnam = new Country(R.drawable.vi, "vn", "98000000");
        Country usa = new Country(R.drawable.us, "us", "320000000");
        Country russia = new Country(R.drawable.ru, "ru", "142000000");

        list.add(vietnam);
        list.add(usa);
        list.add(russia);

        return list;
    }
}
