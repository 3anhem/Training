package com.example.bt2_b6;

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FootballLegendAdapter extends ArrayAdapter<FootballLegend> implements Serializable {
    Context context;
    int resource;
    List<FootballLegend> list;


    public FootballLegendAdapter(Context context, int resource, List<FootballLegend> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    public FootballLegendAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.imgFlag = convertView.findViewById(R.id.imageView);
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtSoBanThang = convertView.findViewById(R.id.txtBanThang);
            holder.txtCauLacBo = convertView.findViewById(R.id.txtCauLacBo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        FootballLegend item = this.list.get(position);
        Log.d("AAAA",item.getImage()+" ");
        holder.txtName.setText(item.getName());
        holder.txtSoBanThang.setText(item.getSoBanThang());
        holder.txtCauLacBo.setText(item.getCauLacBo());
        holder.imgFlag.setImageResource(item.getImage());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgFlag;
        TextView txtName;
        TextView txtSoBanThang;
        TextView txtCauLacBo;
    }
}
