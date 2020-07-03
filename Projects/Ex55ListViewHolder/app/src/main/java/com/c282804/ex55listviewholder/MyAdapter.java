package com.c282804.ex55listviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<String> items ;
    //대량의 데이터를 뷰객체로 만들어주는 아답터객체 참좁ㄴ수

    Context context;


    //생성자


    public MyAdapter(ArrayList<String> items, Context context) {
        this.items = items;
        this.context=context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1. 재활용할 뷰가 없는가?
        if( convertView==null){
            //없다면 만들어라
            LayoutInflater inflater =LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.listview_item,parent,false);

            //참조변수를 멤버로 가지고 있는 객체 생성
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }


        //뷰에 저장되어 있는 태그 객체(Viewholder)를 얻어오기.
        ViewHolder holder= (ViewHolder) convertView.getTag();

        //텍스트뷰에 넣을 현재번째(position)데이터
        String s= items.get(position);
        holder.tv.setText(s);

        return convertView;
    }

    //이너클래스
    class ViewHolder{
        TextView tv;

        public ViewHolder(View itemView){
            tv= itemView.findViewById(R.id.tv);

        }
    }
}
