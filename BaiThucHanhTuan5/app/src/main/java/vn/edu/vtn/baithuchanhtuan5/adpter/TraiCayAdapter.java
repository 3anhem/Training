package vn.edu.vtn.baithuchanhtuan5.adpter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.model.TraiCay;

public class TraiCayAdapter extends ArrayAdapter<TraiCay> {
    Activity context;
    int resource;
    List<TraiCay> objects;
    public TraiCayAdapter(Activity context, int resource, List<TraiCay> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View view = inflater.inflate(this.resource,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView ten = view.findViewById(R.id.tentraicay);
        TextView mota = view.findViewById(R.id.mota);
        TraiCay traiCay =this.objects.get(position);
        imageView.setImageResource(traiCay.getHinh());
        ten.setText(traiCay.getTen());
        mota.setText(traiCay.getMota());
        return view;
    }
}
