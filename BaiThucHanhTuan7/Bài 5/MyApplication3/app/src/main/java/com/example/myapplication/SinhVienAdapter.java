package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    Context context;
    ArrayList<SinhVien> data;
    int layoutResourceID;
    public SinhVienAdapter(@NonNull Context context, int resource, ArrayList<SinhVien> data) {
        super(context, resource, data);
        this.context = context;
        this.layoutResourceID = resource;
        this.data = data;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent){
        SinhVienHolder holder;
        View row = view;
        SinhVien sv = data.get(position);
        if (row != null){
            holder = (SinhVienHolder)row.getTag();
        }else {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.row_listview, parent, false);
            holder = new SinhVienHolder();
            holder.Img = row.findViewById(R.id.Img);
            holder.Address = row.findViewById(R.id.Address);
            holder.Name = row.findViewById(R.id.Name);
            row.setTag(holder);
        }
        holder.Name.setText(sv.Name);
        holder.Address.setText(sv.Address);
        if (holder.openAvatar(sv.Img)){
            Bitmap bm = BitmapFactory.decodeFile(holder.File_Img.getAbsolutePath());
            holder.Img.setImageBitmap(bm);
        }
        else {
            holder.Img.setImageResource(R.mipmap.sample_avatar);
        }
        return row;
    }
}
