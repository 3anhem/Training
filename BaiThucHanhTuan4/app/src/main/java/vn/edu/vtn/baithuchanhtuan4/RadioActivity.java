package vn.edu.vtn.baithuchanhtuan4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class RadioActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    int score = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioFour) {
                    score += 1;
                } else {
                    score = 0;
                }
            }
        });
    }

    public void toProcessBack(View view) {
        Intent intent = new Intent(RadioActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    public void toProcessNext(View view) {
        Intent intent = new Intent(RadioActivity.this, CheckBoxActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("RADIO", score);
        startActivity(intent);
    }
}
