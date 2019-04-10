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

public class CountryAdapter extends ArrayAdapter<Country> {
    Context context;
    int resource;
    List<Country> list;


    public CountryAdapter(Context context, int resource, List<Country> list) {
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
            holder.imgFlag = convertView.findViewById(R.id.imgFlag);
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtPopulation = convertView.findViewById(R.id.txtPopulation);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Country country = this.list.get(position);
        holder.txtName.setText(country.getName());
        holder.txtPopulation.setText(country.getPopulation());
        holder.imgFlag.setImageResource(country.getImage());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgFlag;
        TextView txtName;
        TextView txtPopulation;
    }

}
