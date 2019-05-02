package vn.edu.vtn.bai1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter extends ArrayAdapter<Color> {
    Context context;
    int layoutResourceId;
    ArrayList<Color> data;

    public ColorAdapter(Context context, int layoutResourceId, ArrayList<Color> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    static class ColorHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ColorHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ColorHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgImage);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtName);

            row.setTag(holder);
        }
        else
        {
            holder = (ColorHolder)row.getTag();
        }
        // xử lý
        Color colorObject = data.get(position);
        holder.txtTitle.setText(colorObject.getColor());
        holder.txtTitle.setBackground(new ColorDrawable(android.graphics.Color.parseColor(colorObject.getColor())));
        return row;
    }

}
