package com.c282804.ex57recyclerview2;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdaptor extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;


    public MyAdaptor(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override


    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_item,parent,false);
        //뷰홀더 객체 생성 및 리턴
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh =(VH)holder;


        //현재번째 데이터를 가진 Item객체를 얻어오기
        Item item=items.get(position);


        vh.tvname.setText(item.name);
        vh.tvmsg.setText(item.msg);
        Glide.with(context).load(item.imgURL).into(vh.iv);
        Glide.with(context).load(item.profileImg).into(vh.civ);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //(이너클래스) 아이템뷰의 안에있는 뷰들의 참조변수를 멤버로 가진 클래스
    class VH extends RecyclerView.ViewHolder {

        CircleImageView civ;
        TextView tvname;
        TextView tvmsg;
        ImageView iv;


        public VH(@NonNull View itemView) {
            super(itemView);

            civ=itemView.findViewById(R.id.iv_profile);
            tvname= itemView.findViewById(R.id.tv_name);
            tvmsg= itemView.findViewById(R.id.tv_msg);
            iv= itemView.findViewById(R.id.iv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item item = items.get(getLayoutPosition());


                    Intent intent = new Intent(context,DetailActivity.class);

                    intent.putExtra("Name",item.name);
                    intent.putExtra("img",item.profileImg);

                    //전환 효과 (21버전 이상에서만 가능)
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,newPair<View)
                        context.startActivity(intent,options.toBundle());
                    }else {
                        context.startActivity(intent);
                    }

                }
            });
        }
    }


}
