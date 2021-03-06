package com.example.prototypenew;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Car> dataModelArrayList;

    public ListAdapter(Context context, ArrayList<Car> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;


        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (dataModelArrayList.get(position).getEmail().equals(dataModelArrayList.get(position).getEmail1())) {

                convertView = inflater.inflate(R.layout.car1, null, true);

                holder.name = (TextView) convertView.findViewById(R.id.name);

                holder.price = (TextView) convertView.findViewById(R.id.price);

                convertView.setTag(holder);
            }else {
                convertView = inflater.inflate(R.layout.car, null, true);

                holder.name = (TextView) convertView.findViewById(R.id.name);

                holder.price = (TextView) convertView.findViewById(R.id.price);

                convertView.setTag(holder);
            }
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.name.setText(dataModelArrayList.get(position).getNameOfCar());
        holder.price.setText(dataModelArrayList.get(position).getPrice());

//        holder.name.setText(dataModelArrayList.get(position).getEmail());
//        holder.price.setText(dataModelArrayList.get(position).getEmail1());

        return convertView;
    }

    private class ViewHolder {

        protected TextView name, price;
    }

}