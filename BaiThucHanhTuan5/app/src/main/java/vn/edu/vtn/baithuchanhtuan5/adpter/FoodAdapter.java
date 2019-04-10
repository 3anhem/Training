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
import vn.edu.vtn.baithuchanhtuan5.model.Country;
import vn.edu.vtn.baithuchanhtuan5.model.Food;

public class FoodAdapter extends ArrayAdapter<Food> {
    Context context;
    int resource;
    List<Food> list;

    public FoodAdapter(Context context, int resource, List<Food> list) {
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
        Food food = this.list.get(position);
        holder.txtName.setText(food.getName());
        holder.imgImage.setImageResource(food.getImage());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgImage;
        TextView txtName;
    }
}
