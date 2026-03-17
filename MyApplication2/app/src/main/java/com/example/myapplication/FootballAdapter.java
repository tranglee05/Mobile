package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FootballAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Football> list;

    public FootballAdapter(Context context, int layout, List<Football> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {//trả về số luwowjng dòng số dòng list view
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {// trả về dòng dữ liệu activity con trong activity
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtFullname, txtAddress;
        ImageView imgAvatar, imgFlag;
        txtFullname = view.findViewById(R.id.txtFullname);
        txtAddress = view.findViewById(R.id.txtAddress);
        imgAvatar = view.findViewById(R.id.imgAvatar);
        imgFlag = view.findViewById(R.id.imgFlag);
        Football foot = list.get(i);
        txtFullname.setText(foot.getFullname());
        txtAddress.setText(foot.getAddress());
        imgAvatar.setImageResource(foot.getAvatar());
        imgFlag.setImageResource(foot.getFlag());
        return view;
    }
}
