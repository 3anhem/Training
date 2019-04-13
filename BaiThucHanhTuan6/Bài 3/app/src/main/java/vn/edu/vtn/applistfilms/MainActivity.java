package vn.edu.vtn.applistfilms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.vtn.applistfilms.adapter.FilmAdapter;
import vn.edu.vtn.applistfilms.model.Film;

public class MainActivity extends AppCompatActivity {
    ArrayList<Film> list;
    FilmAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        listView = findViewById(R.id.lvFilms);
        list = fakeData();
        adapter = new FilmAdapter(this, R.layout.item, list);
        listView.setAdapter(adapter);

        if (getIntent().getSerializableExtra("ITEM") != null) {
            Film film = (Film) getIntent().getSerializableExtra("ITEM");
            int position = getIntent().getIntExtra("POSITION", 0);
            list.get(position).setName(film.getName());
            list.get(position).setContent(film.getContent());
            adapter.notifyDataSetChanged();
        }
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("ITEM", list.get(position));
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });
    }


    private ArrayList<Film> fakeData() {
        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film("Chú chó nhỏ", "Chú chó to", R.drawable.chuchonho));
        films.add(new Film("Chú mèo nhỏ", "Chú mèo to", R.drawable.chuchonho));
        films.add(new Film("Chú Việt nhỏ", "Chú Việt to", R.drawable.chuchonho));
        films.add(new Film("Chú Thương nhỏ", "Chú Thương to", R.drawable.chuchonho));
        films.add(new Film("Chú chó nhỏ", "Chú chó to", R.drawable.chuchonho));
        films.add(new Film("Chú chó nhỏ", "Chú chó to", R.drawable.chuchonho));
        return films;
    }
}
