package com.example.bai4_tuan6;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    public Context context;
    public int layoutResourceId;
    public ArrayList<SanPham> data;
    public SanPhamAdapter(@NonNull Context context, int resource, ArrayList<SanPham> arr_sp) {
        super(context, resource, arr_sp);
        this.context = context;
        this.layoutResourceId = resource;
        this.data = arr_sp;
    }
    public synchronized void swapData(ArrayList<SanPham> data){
        this.data.clear();
        this.data.addAll(data);
    }
    static class SanPhamHolder{
        TextView text;
        SanPham sp;
    }
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        SanPhamHolder holder = null;
        if (row != null){
            holder = (SanPhamHolder)row.getTag();
        }else{
            holder = new SanPhamHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder.text = (TextView) row.findViewById(R.id.text);
            row.setTag(holder);
        }
        holder.sp = this.getItem(position);
        SanPham sp = holder.sp;
        holder.text.setText(sp.masp+" "+sp.tensp);
        return row;
    }

}
