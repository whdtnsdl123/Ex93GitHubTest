package com.c282804.ex56recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<String> items ;



    public MyAdapter(ArrayList<String> items, Context context) {
        this.context = context;
        this.items = items;

    }

    //재활용할 뷰가 없으면 뷰를 만들어내는 작업을 수행하는 메소드.
    //단, Viewholder객체를 만들어서 리턴
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_item,parent,false);

        //뷰홀더 객체 생성 및 리턴
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH) holder;
        vh.tv.setText(items.get(position));

    }

    //뷰에 값을 연결하는 작업메소드.
    //뷰 설정된 tag 객체 (View holder)를 첫번째 파라미터로 전달해줌.
    @Override
    public int getItemCount() {
        return items.size();
    }
    //이너클래스 : 아이템뷰안에 뷰들의 참조변수를 멤버변수로 가질 클래스
    class VH extends RecyclerView.ViewHolder{
        TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);

            //리사이클러의 아이템클릭에 반응하는 리스너객체 생성 및 추가
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //이 아이템 뷰의 위치 index번호
                    int position= getLayoutPosition();
                    Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
