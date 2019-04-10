package vn.edu.vtn.baithuchanhtuan5.traicay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.adpter.TraiCayAdapter;
import vn.edu.vtn.baithuchanhtuan5.model.TraiCay;

public class TraiCayActivity extends AppCompatActivity {

    ListView listView;
    TraiCayAdapter listAdapter;
    ArrayList<TraiCay> traiCays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trai_cay);
        addControls();
        addEvent();
    }

    private void addEvent() {

    }

    void Khoitao() {
        traiCays.add(new TraiCay(R.drawable.a1, "Bưởi", "Bưởi năm roi"));
        traiCays.add(new TraiCay(R.drawable.a3, "Sinh Tố", "Ly sinh tố"));
        traiCays.add(new TraiCay(R.drawable.a2, "Trái Cây Tô", "Tô trái cây"));
        traiCays.add(new TraiCay(R.drawable.a1, "Vựa Trái Cây", "Vựa Trái Cây"));
    }

    private void addControls() {
        traiCays = new ArrayList<TraiCay>();
        listView = findViewById(R.id.listView);
        Khoitao();
        listAdapter = new TraiCayAdapter(TraiCayActivity.this,
                R.layout.item_traicay, traiCays);
        listView.setAdapter(listAdapter);
    }

}
