package com.c282804.ex82retrofitboard;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class BoardAdapter extends RecyclerView.Adapter  {

    Context context;
    ArrayList<BoardItem> items;

    public BoardAdapter(Context context, ArrayList<BoardItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.board_item,parent,false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;

        BoardItem item = items.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class VH extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView price,msg,title;
        ToggleButton favor;
        public VH(@NonNull View itemView) {
            super(itemView);


            iv=itemView.findViewById(R.id.iv);
            price=itemView.findViewById(R.id.tv_price);
            msg=itemView.findViewById(R.id.tv_msg);
            title=itemView.findViewById(R.id.tv_title);
            favor=itemView.findViewById(R.id.tb);


            //좋아요 버튼 선택 리스너.
            favor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    //바꿔야할 데이튼 'favor' 할뿐이지만 나중에 확장성을 위해서.

                    //현재 누른 아이템 항목 불러오기 .

                    BoardItem item = items.get(getLayoutPosition());

                    item.favor=isChecked() 1:0;




                }
           });





        }
    }
}
