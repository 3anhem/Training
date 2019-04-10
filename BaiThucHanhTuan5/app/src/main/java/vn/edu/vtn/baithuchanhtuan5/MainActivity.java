package vn.edu.vtn.baithuchanhtuan5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import vn.edu.vtn.baithuchanhtuan5.country.QuanLyCountry;
import vn.edu.vtn.baithuchanhtuan5.fooddrink.OderFoodActivity;
import vn.edu.vtn.baithuchanhtuan5.huyenthoaibongda.FootBallActivity;
import vn.edu.vtn.baithuchanhtuan5.traicay.TraiCayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toProcessOpenCountry(View view) {
        startActivity(new Intent(MainActivity.this, QuanLyCountry.class));
    }

    public void toProcessOpenOderFood(View view) {
        startActivity(new Intent(MainActivity.this, OderFoodActivity.class));
    }

    public void toProcessOpenOderFruit(View view) {
        startActivity(new Intent(MainActivity.this, TraiCayActivity.class));
    }

    public void toProcessOpenFootBall(View view) {
        startActivity(new Intent(MainActivity.this, FootBallActivity.class));
    }
}
