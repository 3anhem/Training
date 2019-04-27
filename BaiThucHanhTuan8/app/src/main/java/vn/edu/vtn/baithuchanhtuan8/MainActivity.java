package vn.edu.vtn.baithuchanhtuan8;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    String TAG = "Message";
    DatabaseReference msg = null;
    EditText txtValue;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValue = findViewById(R.id.txtValue);
        setFirebase();
    }

    private void setFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        msg = database.getReference(TAG);
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("AAAA", "ERROR : " + databaseError.toException());
            }
        });
    }

    public void toProcess(View view) {
        msg.setValue(txtValue.getText().toString());
    }

    public void toProcessGold(View view) {
        startActivity(new Intent(MainActivity.this, GiaVangActivity.class));
    }
}
