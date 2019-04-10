package vn.edu.vtn.baithuchanhtuan4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class SwitchActivity extends AppCompatActivity {
    Switch switchOne;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        addControls();


    }

    private void addControls() {
        switchOne = findViewById(R.id.switchOne);
    }

    public void toProcessBack(View view) {
        Intent intent = new Intent(SwitchActivity.this, ToggleButtonActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    public void toProcessNext(View view) {

        if (switchOne.isChecked()) {
            score++;
        }
        Intent intent = new Intent(SwitchActivity.this, ResultActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("SWITCH", score);
        intent.putExtra("TOGGLE", getIntent().getIntExtra("TOGGLE", 0));
        intent.putExtra("SPINNER", getIntent().getIntExtra("SPINNER", 0));
        intent.putExtra("CHECK", getIntent().getIntExtra("CHECK", 0));
        intent.putExtra("RADIO", getIntent().getIntExtra("RADIO", 0));
        startActivity(intent);
    }

}
