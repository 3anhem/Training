package vn.edu.vtn.baithuchanhtuan5.adpter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.model.FootballLegend;

public class FootballLegendAdapter extends ArrayAdapter<FootballLegend> {
    Context context;
    int layoutResourceId;
    ArrayList<FootballLegend> data = null;

    public FootballLegendAdapter(Context context, int layoutResourceId, ArrayList<FootballLegend> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public FootballLegendAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public View getView(int position, View row, ViewGroup group) {
        FootballLegendHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, group, false);
            ImageView img1 = (ImageView) row.findViewById(R.id.imageView);
            ImageView img2 = (ImageView) row.findViewById(R.id.imageView2);
            TextView text1 = (TextView) row.findViewById(R.id.textView);
            TextView text2 = (TextView) row.findViewById(R.id.textView2);

            holder = new FootballLegendHolder();
            holder.img1 = img1;
            holder.img2 = img2;
            holder.text1 = text1;
            holder.text2 = text2;

            row.setTag(holder);
        } else {
            holder = (FootballLegendHolder) row.getTag();
        }

        FootballLegend item = data.get(position);
        Log.d("AAAA", item.id_flag + " ");
        holder.img1.setImageResource(item.id_football);
        holder.img2.setImageResource(item.id_flag);
        holder.text1.setText(item.name);
        holder.text2.setText(item.birthday);

        return row;
    }

    public class FootballLegendHolder {
        public ImageView img1;
        public ImageView img2;
        public TextView text1;
        public TextView text2;
    }
}
