package vn.edu.vtn.baithuchanhtuan5.fooddrink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.adpter.DrinkAdapter;
import vn.edu.vtn.baithuchanhtuan5.model.Drink;

public class DrinkActivity extends AppCompatActivity {
    ListView listDrink;
    ArrayList<Drink> list;
    DrinkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        addControls();
        addEvents();
    }

    private void addControls() {
        listDrink = findViewById(R.id.listDrink);
        list = fakeData();
        adapter = new DrinkAdapter(DrinkActivity.this, R.layout.item_drink, list);
        listDrink.setAdapter(adapter);
    }

    private void addEvents() {
        listDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(DrinkActivity.this, OderFoodActivity.class);
//                intent.putExtra("DRINK", list.get(position).getName());
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//                startActivity(intent);
                OderFoodActivity.drinkName = list.get(position).getName();
                finish();
            }
        });
    }

    private ArrayList<Drink> fakeData() {
        ArrayList<Drink> list = new ArrayList<>();
        Drink coca = new Drink("Cô ca cô la", R.drawable.ic_coca);
        Drink pepsi = new Drink("Pepsi", R.drawable.ic_pepsi);
        Drink aqua = new Drink("Nước lọc", R.drawable.ic_aquafina);
        Drink heniken = new Drink("Bia Heniken", R.drawable.ic_heniken);


        list.add(coca);
        list.add(pepsi);
        list.add(aqua);
        list.add(heniken);

        return list;
    }
}
