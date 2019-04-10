package vn.edu.vtn.baithuchanhtuan5.fooddrink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.adpter.FoodAdapter;
import vn.edu.vtn.baithuchanhtuan5.model.Food;

public class FoodActivity extends AppCompatActivity {
    ListView listFood;
    ArrayList<Food> list;
    FoodAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        addControls();
        addEvents();
    }

    private void addControls() {
        listFood = findViewById(R.id.listFood);
        list = fakeData();
        adapter = new FoodAdapter(FoodActivity.this, R.layout.item_food, list);
        listFood.setAdapter(adapter);
    }

    private void addEvents() {
        listFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FoodActivity.this, OderFoodActivity.class);
                OderFoodActivity.foodName = list.get(position).getName();
                finish();
//                intent.putExtra("FOOD", list.get(position).getName());
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//                startActivity(intent);
            }
        });
    }

    private ArrayList<Food> fakeData() {
        ArrayList<Food> list = new ArrayList<>();
        Food bunbBo = new Food("Bún bò", R.drawable.ic_bbh);
        Food vitLon = new Food("Cháo", R.drawable.ic_htnv);
        Food banhCanh = new Food("Bánh canh", R.drawable.ic_mq);
        Food pho = new Food("Phở", R.drawable.ic_phn);


        list.add(bunbBo);
        list.add(vitLon);
        list.add(banhCanh);
        list.add(pho);

        return list;
    }
}
