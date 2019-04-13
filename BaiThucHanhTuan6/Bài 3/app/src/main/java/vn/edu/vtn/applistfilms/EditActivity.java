package vn.edu.vtn.applistfilms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.vtn.applistfilms.model.Film;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtName, txtContent;
    Button btnSubmit, btnCancel;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        txtContent = findViewById(R.id.txtContent);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        Film film = (Film) getIntent().getSerializableExtra("ITEM");
        txtName.setText(film.getName());
        txtContent.setText(film.getContent());
        position = getIntent().getIntExtra("POSITION", -1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                toProcessSubmit();
                break;
            case R.id.btnCancel:
                finish();
        }
    }

    private void toProcessSubmit() {
        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        Film film = new Film(txtName.getText().toString(), txtContent.getText().toString(), R.drawable.chuchonho);
        intent.putExtra("ITEM", film);
        intent.putExtra("POSITION", position);
        startActivity(intent);
    }
}
