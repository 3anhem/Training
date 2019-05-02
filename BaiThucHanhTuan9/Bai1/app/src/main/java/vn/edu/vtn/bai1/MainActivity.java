package vn.edu.vtn.bai1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    ArrayList<Color> data= new ArrayList<>();
    ColorAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);


        Adapter = new ColorAdapter(this,R.layout.item,data);
        lv.setAdapter(Adapter);

        new ColorAsync().execute("http://cdn.crunchify.com/wp-content/uploads/code/jsonArray.txt");
    }

    class ColorAsync extends AsyncTask<String, Integer, Color> {
        @Override
        protected Color doInBackground(String... strings) {
            String UrlWebservice = strings[0];// lấy địa chỉ Webservice được truyền vào
            String JsonString = new ReadJson().getJSONStringFromURL(UrlWebservice);
            ArrayList<Color> datas   = new Gson().fromJson(JsonString, new TypeToken<ArrayList<Color>>() {
            }.getType());

            for (int i = 0 ; i< datas.size(); i++) {
                Color colorObject = datas.get(i);
                data.add(colorObject);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Color colorObject) {
            super.onPostExecute(colorObject);
            Adapter.notifyDataSetChanged();
        }
    }


    }