package vn.edu.vtn.baithuchanhtuan5.fooddrink;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import vn.edu.vtn.baithuchanhtuan5.R;

public class OderFoodActivity extends AppCompatActivity {
    TextView txtFood, txtDrink;
    public static String drinkName, foodName;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_dat_do_an);
        addControls();
        addEvents();
//        drinkName = savedInstanceState.getString("DRINK", "KCG");
//        foodName = savedInstanceState.getString("FOOD", "KCG");
    }

    private void addControls() {
        txtFood = findViewById(R.id.txtFood);
        txtDrink = findViewById(R.id.txtDrink);
//        if (getIntent().getStringExtra("FOOD") != null) {
//            foodName = getIntent().getStringExtra("FOOD");
//            txtFood.setText(foodName);
//        }
//        if (getIntent().getStringExtra("DRINK") != null) {
//            drinkName = getIntent().getStringExtra("DRINK");
//            txtDrink.setText(drinkName);
//        }
    }

    private void addEvents() {

    }

    public void toProcessOpenFood(View view) {
        startActivity(new Intent(OderFoodActivity.this, FoodActivity.class));
    }

    public void toProcessOpenDrink(View view) {
        startActivity(new Intent(OderFoodActivity.this, DrinkActivity.class));
    }

    public void toProcessOut(View view) {
        finish();
    }

//    @Override
//    public void onSaveInstanceState(Bundle data) {
//        super.onSaveInstanceState(data);
//        data.putString("DRINK", drinkName);
//        data.putString("FOOD", foodName);
//    }

    @Override
    protected void onResume() {
        super.onResume();
        txtDrink.setText(drinkName);
        txtFood.setText(foodName);
    }
}
