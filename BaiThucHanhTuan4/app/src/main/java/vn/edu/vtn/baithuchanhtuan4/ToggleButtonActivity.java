package vn.edu.vtn.baithuchanhtuan4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity {
    ToggleButton toggleOne, toggleTwo, toggleThree;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        toggleOne = findViewById(R.id.toggleOne);
        toggleTwo = findViewById(R.id.toggleTwo);
        toggleThree = findViewById(R.id.toggleThree);
    }

    public void toProcessNext(View view) {
        if (toggleOne.isChecked()) {
            score++;
        }
        Intent intent = new Intent(ToggleButtonActivity.this, SwitchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("TOGGLE", score);
        intent.putExtra("SPINNER", getIntent().getIntExtra("SPINNER", 0));
        intent.putExtra("CHECK", getIntent().getIntExtra("CHECK", 0));
        intent.putExtra("RADIO", getIntent().getIntExtra("RADIO", 0));
        startActivity(intent);
    }


    public void toProcessBack(View view) {
        Intent intent = new Intent(ToggleButtonActivity.this, SpinnerrActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
