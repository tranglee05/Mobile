package com.example.lab03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClothesAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Clothes> list;

    public ClothesAdapter(Context context, int layout, List<Clothes> list) {
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
        TextView txtname, txtprice;
        ImageView imgavatar;
        txtname = view.findViewById(R.id.txtname);
        txtprice = view.findViewById(R.id.txtprice);
        imgavatar = view.findViewById(R.id.imgavatar);
        Clothes clothes = list.get(i);
        txtname.setText(clothes.getName());
        txtprice.setText(clothes.getPrice());
        imgavatar.setImageResource(clothes.getImg());
        return view;
    }
}
