package vn.edu.vtn.applistfilms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.vtn.applistfilms.R;
import vn.edu.vtn.applistfilms.model.Film;

public class FilmAdapter extends ArrayAdapter<Film> {
    private Context context;
    private int resource;
    private ArrayList<Film> list;

    public FilmAdapter(Context context, int resource, ArrayList<Film> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(this.resource, parent, false);
            holder = new ViewHolder();
            holder.imgImage = convertView.findViewById(R.id.imgImage);
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtContent = convertView.findViewById(R.id.txtContent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Film film = this.list.get(position);
        holder.txtName.setText(film.getName());
        holder.txtContent.setText(film.getContent());
        holder.imgImage.setImageResource(film.getImage());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgImage;
        TextView txtName;
        TextView txtContent;
    }
}
