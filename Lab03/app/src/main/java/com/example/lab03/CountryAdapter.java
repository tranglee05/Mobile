package com.example.lab03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Country> list;

    public CountryAdapter(Context context, int layout, List<Country> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtName, txtPop, txtArea;
        ImageView imgavatar;
        txtName = view.findViewById(R.id.txtName);
        txtPop = view.findViewById(R.id.txtPop);
        txtArea = view.findViewById(R.id.txtArea);
        imgavatar = view.findViewById(R.id.imgavatar);

        Country country = list.get(i);

        txtName.setText(country.getName());
        txtPop.setText("Population: " + country.getPopulation());
        txtArea.setText("Area: " + country.getArea());
        imgavatar.setImageResource(country.getAvatar());

        return view;
    }
}
