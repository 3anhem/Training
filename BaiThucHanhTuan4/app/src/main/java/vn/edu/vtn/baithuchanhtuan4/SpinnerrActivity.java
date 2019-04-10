package vn.edu.vtn.baithuchanhtuan4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class SpinnerrActivity extends AppCompatActivity {
    Spinner spinA, spinB, spinC;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinnerr);
        spinA = findViewById(R.id.spinA);
        spinB = findViewById(R.id.spinB);
        spinC = findViewById(R.id.spinC);
    }

    public void toProcessBack(View view) {
        Intent intent = new Intent(SpinnerrActivity.this, CheckBoxActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    public void toProcessNext(View view) {
        String resultOne = (String) spinA.getSelectedItem();
        String resultTwo = (String) spinB.getSelectedItem();
        String resultThree = (String) spinC.getSelectedItem();
        if (resultOne.equals("3")) {
            score++;
        }
        if (resultTwo.equals("4")) {
            score++;
        }
        if (resultThree.equals("4")) {
            score++;
        }
        Intent intent = new Intent(SpinnerrActivity.this, ToggleButtonActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("SPINNER", score);
        intent.putExtra("CHECK", getIntent().getIntExtra("CHECK", 0));
        intent.putExtra("RADIO", getIntent().getIntExtra("RADIO", 0));
        startActivity(intent);
    }
}
