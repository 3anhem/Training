package vn.edu.vtn.chinhsuathongtinimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    CheckBox checkGlasses, checkHair, checkTeeth, checkBox;
    ImageView imgGlasses, imgHair, imgTeeth, imgBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        checkGlasses = findViewById(R.id.checkGlasses);
        checkHair = findViewById(R.id.checkHair);
        checkTeeth = findViewById(R.id.checkTeeth);
        checkBox = findViewById(R.id.checkBox);
        imgGlasses = findViewById(R.id.imgGlasses);
        imgHair = findViewById(R.id.imgHair);
        imgTeeth = findViewById(R.id.imgTeeth);
        imgBox = findViewById(R.id.imgBox);

    }

    private void addEvents() {
        checkGlasses.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgGlasses.setVisibility(View.VISIBLE);
                } else {
                    imgGlasses.setVisibility(View.INVISIBLE);
                }

            }
        });
        checkHair.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgHair.setVisibility(View.VISIBLE);
                } else {
                    imgHair.setVisibility(View.INVISIBLE);
                }

            }
        });
        checkTeeth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgBox.setVisibility(View.VISIBLE);
                } else {
                    imgBox.setVisibility(View.INVISIBLE);
                }

            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgTeeth.setVisibility(View.VISIBLE);
                } else {
                    imgTeeth.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
}
