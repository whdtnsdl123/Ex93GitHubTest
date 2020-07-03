package com.c282804.ex85firebasechatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends BaseAdapter {

    Context context;
    ArrayList<MessageItem> messageItems;

    public ChatAdapter(Context context, ArrayList<MessageItem> messageItems) {
        this.context = context;
        this.messageItems = messageItems;
    }


    @Override
    public int getCount() {
        return messageItems.size();
    }

    @Override
    public Object getItem(int position) {
        return messageItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MessageItem item = messageItems.get(position);

        //1.create view[my_msgbox or other_msgbox]
        View itemView=null;
        if(G.nickname.equals(item.name)) itemView= LayoutInflater.from(context).inflate(R.layout.my_msgbox,parent,false);
        else itemView=LayoutInflater.from(context).inflate(R.layout.other_msgbox,parent,false);

        //2. bind view
        CircleImageView iv= itemView.findViewById(R.id.iv_circle);
        TextView tvName= itemView.findViewById(R.id.tv_Name);

        return null;
    }
}
