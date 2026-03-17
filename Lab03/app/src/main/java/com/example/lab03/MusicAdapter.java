package com.example.lab03;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MusicAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Music> list;

    public MusicAdapter(Context context, int layout, List<Music> list) {
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtName, txtSinger, txtTime;
        ImageView imgavatar;
        txtName = view.findViewById(R.id.txtName);
        txtSinger = view.findViewById(R.id.txtSinger);
        txtTime = view.findViewById(R.id.txtTime);
        imgavatar = view.findViewById(R.id.imgavatar);
        Music music = list.get(i);
        txtName.setText(music.getName());
        txtTime.setText(music.getTime());
        txtSinger.setText(music.getSinger());
        imgavatar.setImageResource(music.getAvatar());
        return view;
    }
}
