package vn.edu.vtn.baithuchanhtuan5.huyenthoaibongda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.adpter.FootballLegendAdapter;
import vn.edu.vtn.baithuchanhtuan5.model.FootballLegend;

public class FootBallActivity extends AppCompatActivity {

    ListView listView1;
    ArrayList<FootballLegend> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_ball);

        setControl();
        setEvent();

    }

    void setControl() {
        listView1 = (ListView) findViewById(R.id.listview1);
    }

    void setEvent() {
        KhoiTao();
        FootballLegendAdapter adapter = new FootballLegendAdapter(this, R.layout.item_football, data);
        listView1.setAdapter(adapter);
    }

    void KhoiTao() {
        data.add(new FootballLegend(R.drawable.xuantruong, "Xuan Truong", "28/4/1995 (23 age)", R.drawable.vn));
        data.add(new FootballLegend(R.drawable.beckcam, "David Beckham", "2/5/1975 (43 age)", R.drawable.my));
        data.add(new FootballLegend(R.drawable.cr7, "Cris Ronaldo", "5/2/1985 (34 age)", R.drawable.bdn));
        data.add(new FootballLegend(R.drawable.mbabe, "Kylian Mbappe", "20/12/1998 (20 age)", R.drawable.phap));
    }
}
