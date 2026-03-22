package com.example.lab01;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Bai9Adapter extends BaseAdapter {
    Context context;
    List<Bai9> ds;
    int layout;

    public Bai9Adapter(Context context, List<Bai9> ds, int layout) {
        this.context = context;
        this.ds = ds;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return ds.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtTen, txtInfo, txtDes;
        ImageView img;
        txtTen = view.findViewById(R.id.txtTen);
        txtInfo = view.findViewById(R.id.txtInfo);
        txtDes = view.findViewById(R.id.txtDes);
        img = view.findViewById(R.id.img);
        Bai9 bai9 = ds.get(i);
        txtTen.setText(bai9.getTen());
        txtInfo.setText(bai9.getGioitinh() + "-" + bai9.isVb());
        txtDes.setText(bai9.getDes());
        img.setImageResource(bai9.getAvatar());
        return view;
    }
}
