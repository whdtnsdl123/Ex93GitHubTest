package com.c282804.edittest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Member> members;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<Member> members,LayoutInflater inflater){
        this.members=members;
        this.inflater=inflater;


    }


    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.list_view, null);
        }

        TextView tv1 =convertView.findViewById(R.id.tv1);
        TextView tv2 =convertView.findViewById(R.id.tv2);
        TextView tv3 =convertView.findViewById(R.id.tv3);
        TextView tv4 =convertView.findViewById(R.id.tv4);

        Member member = members.get(position);
        tv1.setText(member.name);
        tv2.setText(member.nick);
        tv3.setText(member.title);
        tv4.setText(member.write);


        return convertView;
    }
}
