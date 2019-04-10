package vn.edu.vtn.baithuchanhtuan5.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.vtn.baithuchanhtuan5.R;
import vn.edu.vtn.baithuchanhtuan5.model.Drink;
import vn.edu.vtn.baithuchanhtuan5.model.Food;

public class DrinkAdapter extends ArrayAdapter<Drink> {
    Context context;
    int resource;
    List<Drink> list;

    public DrinkAdapter(Context context, int resource, List<Drink> list) {
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
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.imgImage = convertView.findViewById(R.id.imgImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Drink drink = this.list.get(position);
        holder.txtName.setText(drink.getName());
        holder.imgImage.setImageResource(drink.getImage());

        return convertView;

    }

    static class ViewHolder {
        ImageView imgImage;
        TextView txtName;
    }
}
