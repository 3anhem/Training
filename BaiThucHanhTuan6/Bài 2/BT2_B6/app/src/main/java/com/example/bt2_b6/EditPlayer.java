package com.example.bt2_b6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditPlayer  extends AppCompatActivity {

    TextView txtTen;
    ImageView imgHinh;
    EditText editCauLacBo;
    EditText editBanThang;
    Button btOk;
    Button btCancel;
    Intent intent;
    Bundle b;
    FootballLegend c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_player);
        editPlayer();
        addEvents();
    }

    private void addEvents() {
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FootballLegend cd = new FootballLegend();
                cd.setName(c.getName());
                cd.setImage(c.getImage());
                cd.setSoBanThang(editBanThang.getEditableText().toString());
                cd.setCauLacBo(editCauLacBo.getText().toString());
                Toast.makeText(EditPlayer.this, cd.getImage() + cd.getCauLacBo() + cd.getSoBanThang()+cd.getName() +"", Toast.LENGTH_SHORT).show();

                b.putSerializable("CONTACT1",cd);
                intent.putExtra("DATA1",b);
                setResult(99,intent);
                finish();
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void editPlayer() {
        txtTen = (TextView)findViewById(R.id.txtTen);
        imgHinh =findViewById(R.id.imgHinh);
        editBanThang = (EditText)findViewById(R.id.editBanThang);
        editCauLacBo = (EditText) findViewById(R.id.editCauLacBo);
        btOk = (Button)findViewById(R.id.btOk);
        btCancel = (Button)findViewById(R.id.btCancel);
        intent =getIntent();
        b =intent.getBundleExtra("DATA");
        c =(FootballLegend) b.getSerializable("CONTACT");
        txtTen.setText(c.getName());

        imgHinh.setImageResource(c.getImage());
        editBanThang.setText(c.getSoBanThang());
        editCauLacBo.setText(c.getCauLacBo());
    }

}
