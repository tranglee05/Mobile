package com.example.lab01;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.List;

public class Bai82Adapter extends BaseAdapter {

    Context context;
    List<Bai82> ds;
    int layout;

    public Bai82Adapter(Context context, List<Bai82> ds, int layout) {
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
        return ds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtTen, txtInfo;
        ImageView img;
        txtTen = view.findViewById(R.id.txtTen);
        txtInfo = view.findViewById(R.id.txtInfo);
        img = view.findViewById(R.id.img);
        Bai82 bai82 = ds.get(i);
        txtTen.setText(bai82.getTen());
        txtInfo.setText(bai82.getGioitinh() + "-" + bai82.getQue());
        img.setImageResource(bai82.getAvatar());
        return view;
    }
}