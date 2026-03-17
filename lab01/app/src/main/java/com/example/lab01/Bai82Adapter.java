package com.example.lab01;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.List;

public class Bai82Adapter extends BaseAdapter {

    Context context;
    List<Bai82> ds;

    public Bai82Adapter(Context context, List<Bai82> ds) {
        this.context = context;
        this.ds = ds;
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

        if(view == null){
            view = LayoutInflater.from(context)
                    .inflate(R.layout.line_bai82, parent, false);
        }

        ImageView img = view.findViewById(R.id.img);
        TextView ten = view.findViewById(R.id.txtTen);
        TextView info = view.findViewById(R.id.txtInfo);

        Bai82 nv = ds.get(i);

        img.setImageResource(nv.getAvatar());
        ten.setText(nv.getTen());
        info.setText(nv.getGioitinh() + " - " + nv.getQue());

        return view;
    }
}