package vn.edu.vtn.baithuchanhtuan4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox checkOne, checkTrue, checkThree, checkFour;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        checkOne = findViewById(R.id.checkOne);
        checkTrue = findViewById(R.id.checkTrue);
        checkThree = findViewById(R.id.checkThree);
        checkFour = findViewById(R.id.checkFour);
    }

    public void toProcessBack(View view) {
        Intent intent = new Intent(CheckBoxActivity.this, RadioActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void toProcessNext(View view) {
        if (checkOne.isChecked()) {
            score++;
        }
        if (checkTrue.isChecked()) {
            score++;
        }
        Intent intent = new Intent(CheckBoxActivity.this, SpinnerrActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("CHECK", score);
        intent.putExtra("RADIO", getIntent().getIntExtra("RADIO", 0));
        startActivity(intent);
    }
}
