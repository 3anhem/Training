package vn.edu.vtn.thaydoiformatchu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox cbBackground, cbTextColor, cbTextCenter;
    RadioButton rbOdd, rbEven, rbBoth;
    Button btnSubmit;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        cbBackground = findViewById(R.id.cbBackground);
        cbTextColor = findViewById(R.id.cbTextColor);
        cbTextCenter = findViewById(R.id.cbTextCenter);
        rbOdd = findViewById(R.id.rbOdd);
        rbEven = findViewById(R.id.rbEven);
        rbBoth = findViewById(R.id.rbBoth);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbBackground.isChecked()) {
                    txtResult.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                } else {
                    txtResult.setBackgroundColor(getResources().getColor(R.color.white));
                }
                if (cbTextColor.isChecked()) {
                    txtResult.setTextColor(getResources().getColor(R.color.white));
                } else {
                    txtResult.setTextColor(getResources().getColor(R.color.black));
                }
                if (cbTextCenter.isChecked()) {
                    txtResult.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else {
                    txtResult.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                }
                if (rbOdd.isChecked()) {
                    int result = 0;
                    do {
                        Random random = new Random();
                        result = random.nextInt(100);
                    } while (result % 2 == 0);
                    txtResult.setText(result + "");
                }
                if (rbEven.isChecked()) {
                    int result = 0;
                    do {
                        Random random = new Random();
                        result = random.nextInt(100);
                    } while (result % 2 != 0);
                    txtResult.setText(result + "");
                }
                if (rbBoth.isChecked()) {
                    int odd = 0;
                    int even = 0;
                    do {
                        Random random = new Random();
                        odd = random.nextInt(100);
                    } while (odd % 2 == 0);
                    do {
                        Random random = new Random();
                        even = random.nextInt(100);
                    } while (even % 2 != 0);

                    txtResult.setText(odd + " " + even);
                }
                txtResult.setVisibility(View.VISIBLE);
            }
        });

    }


}
