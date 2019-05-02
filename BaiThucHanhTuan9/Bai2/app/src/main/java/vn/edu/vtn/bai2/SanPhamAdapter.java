package vn.edu.vtn.bai2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Context context;
    int layoutResourceId;
    ArrayList<SanPham> data;

    public SanPhamAdapter(Context context, int layoutResourceId, ArrayList<SanPham> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    static class SanPhamHolder {
        ImageView imgIcon;
        TextView txtTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SanPhamHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new SanPhamHolder();
            holder.imgIcon = (ImageView) row.findViewById(R.id.imgImage);
            holder.txtTitle = (TextView) row.findViewById(R.id.txtName);

            row.setTag(holder);
        } else {
            holder = (SanPhamHolder) row.getTag();
        }

        SanPham sanPham = data.get(position);
        holder.txtTitle.setText(sanPham.getTensp());
        Log.d("AAAA", sanPham.getHinhAnh());
        Glide.with(context)
                .load(sanPham.getHinhAnh())
                .into(holder.imgIcon);
        return row;
    }


}


