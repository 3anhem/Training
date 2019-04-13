package com.example.bt2_b6;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<FootballLegend> list = fakeData();
    FootballLegendAdapter adapter;
    FootballLegend tam = null;
    Bundle b;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }



    private void addControls() {
        listView = findViewById(R.id.listview);
        list= fakeData();
        adapter = new FootballLegendAdapter(MainActivity.this, R.layout.list_item_row, list);
        listView.setAdapter(adapter);
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
                tam =list.get(position);
                i = new Intent(MainActivity.this, EditPlayer.class);
                b=new Bundle();
                b.putSerializable("CONTACT", tam);
                i.putExtra("DATA", b);
                startActivityForResult(i,33);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                tam =list.get(position);
                AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
                b.setTitle("DELETE PLAYER");
                b.setMessage("Are you sure to delete this player?");
                b.setPositiveButton("yes", new DialogInterface. OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        list.remove(tam);
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }});
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which)

                    {

                        dialog.cancel();

                    }

                });

                b.create().show();
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==33 && resultCode==99) {
                //data = getIntent();
                b = data.getBundleExtra("DATA1");
                tam = (FootballLegend) b.getSerializable("CONTACT1");
                //Toast.makeText(MainActivity.this, "qweqw" + "", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(tam.getName())) {
                        list.get(i).setCauLacBo(tam.getCauLacBo());
                        list.get(i).setSoBanThang(tam.getSoBanThang());
                        //load lai list vew
                        adapter.notifyDataSetChanged();
                    }

                }
            }
    }

    private ArrayList<FootballLegend> fakeData() {
        ArrayList<FootballLegend> list = new ArrayList<>();
        FootballLegend xuantruong = new FootballLegend(R.drawable.xuantruong, "Xuân Trường", "98","vn");
        FootballLegend beckcam = new FootballLegend(R.drawable.beckcam, "beckcam", "320","fc");
        FootballLegend cr7 = new FootballLegend(R.drawable.cr7, "cr7", "142","db");
        FootballLegend mbabe = new FootballLegend(R.drawable.mbabe, "mbabe", "14","db");

        list.add(xuantruong);
        list.add(beckcam);
        list.add(cr7);
        list.add(mbabe);

        return list;
    }
}
