package vn.edu.vtn.baithuchanhtuan4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int switchs = getIntent().getIntExtra("SWITCH", 0);
        int toggle = getIntent().getIntExtra("TOGGLE", 0);
        int spinner = getIntent().getIntExtra("SPINNER", 0);
        int check = getIntent().getIntExtra("CHECK", 0);
        int radio = getIntent().getIntExtra("RADIO", 0);

        list = new ArrayList<>();
        list.add("Câu 1: " + radio + " câu đúng");
        list.add("Câu 2: " + check + " câu đúng");
        list.add("Câu 3: " + spinner + " câu đúng");
        list.add("Câu 4: " + toggle + " câu đúng");
        list.add("Câu 5: " + switchs + " câu đúng");
        adapter = new ArrayAdapter<>(ResultActivity.this, android.R.layout.simple_list_item_1, list);
        listView = findViewById(R.id.lvResult);
        listView.setAdapter(adapter);
    }
}
