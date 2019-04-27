package vn.edu.vtn.baithuchanhtuan8;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GiaVangActivity extends AppCompatActivity {
    EditText txt18K, txtUSD, txt999, txtAUD;
    Switch switchh;
    DatabaseReference msg = null;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gia_vang);
        addControls();
        addEvents();
        setFirebase();
    }

    private void addControls() {
        txt18K = findViewById(R.id.txt18K);
        txtUSD = findViewById(R.id.txtUSD);
        txt999 = findViewById(R.id.txt9999);
        txtAUD = findViewById(R.id.txtAUD);
        switchh = findViewById(R.id.switchh);
    }

    private void addEvents() {
        switchh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setEnableT();
                } else {
                    setEnableF();
                }
            }
        });
        txt18K.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toProcess18K();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt999.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toProcess999();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtUSD.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toProcessUSD();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtAUD.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toProcessAUD();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void toProcess999() {
        msg = database.getReference("999");
        msg.setValue(txt999.getText().toString());
    }

    private void toProcess18K() {
        msg = database.getReference("18K");
        msg.setValue(txt18K.getText().toString());
    }

    private void toProcessUSD() {
        msg = database.getReference("USD");
        msg.setValue(txtUSD.getText().toString());
    }

    private void toProcessAUD() {
        msg = database.getReference("AUD");
        msg.setValue(txtAUD.getText().toString());
    }

    public void setEnableT() {
        txt18K.setEnabled(true);
        txtUSD.setEnabled(true);
        txt999.setEnabled(true);
        txtAUD.setEnabled(true);
    }

    public void setEnableF() {
        txt18K.setEnabled(false);
        txtUSD.setEnabled(false);
        txt999.setEnabled(false);
        txtAUD.setEnabled(false);
    }

    private void setFirebase() {
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        msg = database.getReference("999");
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txt999.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("AAAA", "ERROR : " + databaseError.toException());
            }
        });
        msg = database.getReference("18K");
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txt18K.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("AAAA", "ERROR : " + databaseError.toException());
            }
        });
        msg = database.getReference("USD");
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtUSD.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("AAAA", "ERROR : " + databaseError.toException());
            }
        });
        msg = database.getReference("AUD");
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtAUD.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("AAAA", "ERROR : " + databaseError.toException());
            }
        });
    }

    public void toProcessReload(View view) {
        setFirebase();
    }
}
