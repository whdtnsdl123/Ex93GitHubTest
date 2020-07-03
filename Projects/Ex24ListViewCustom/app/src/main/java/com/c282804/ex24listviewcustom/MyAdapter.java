package com.c282804.ex24listviewcustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Member> members ;
    LayoutInflater inflater;

    //생성자 메소드 : 대량의 데이터를 전달받기 (여기 클래스 이름 기입.)
    public MyAdapter(ArrayList<Member> members, LayoutInflater inflater){
        //전달받은 데이터를 멤버변수에 대입.
        this.inflater = inflater;
        this.members=members;
    }


    //이 어댑터가 만들어야하는 총 아이템 개수를 리턴하는 메소드.(getCount,Item,ItemId 코드 고정)
    @Override
    public int getCount() {
        return members.size();
    }

    //Position 번 째 의 데이터를 리턴하는 기능
    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //뷰를 만들어서 어댑터 뷰에게 리턴하는 메소드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1.new View(뷰를 만들기)

        //재활용할 뷰가 없냐?[이 메소드의 2번 째 파라미터]
        if(convertView==null){

            //res/layout/listview_item.xml문서를 읽어와서 View객체로 만들어주는(부풀리다)객체(LayoutInflater)를 이용하여 View 소환
            convertView=inflater.inflate(R.layout.listview_item,null);
        }

        //2.binding(뷰안에 값들 설정하기)

        //만들어진 뷰안에 있는 View들을 참조하기.
        ImageView iv=convertView.findViewById(R.id.iv);
        TextView tvName=convertView.findViewById(R.id.tv_name);
        TextView tvNation=convertView.findViewById(R.id.tv_nation);

        Member member= members.get(position);
        iv.setImageResource(member.imgId);
        tvName.setText(member.name);
        tvNation.setText(member.nation);

        return convertView;
    }
}
