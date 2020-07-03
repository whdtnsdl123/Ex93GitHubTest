package com.c282804.ex91kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*



class MyAdapter constructor(var context: Context, val item:ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater=LayoutInflater.from(context)
        val itemView= layoutInflater.inflate(R.layout.recycler_item,parent,false)
        val vh= VH(itemView)
        return vh

    }

    override fun getItemCount(): Int {
        return  item.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh= holder as VH//코틀린의 형변환 연산자 as

        //현재번째 아이템
        val item= item.get(position)
        vh.itemView.tvTitle.setText(item.title)
        //코틀린에서는 setXXX메소드를 싫어함. 대신 set해서 설정할 값을
        //멤버변수(property:속성)로 설정하는 것을 권장
        vh.itemView.tvMsg.text=item.msg
        //Glide와 같은 역할을 한느 Picasso 라이브러리 사용
        Picasso.get().load(item.img).into(vh.itemView.iv)

        //코틀린에서는 이 위치에서 itemVeiw의 클릭이벤트를 처리를 함
//        vh.itemView.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                //아이템의 상세 정보 화면으로 이동
//            }
//        })
//


    }

    //inner class ViewHolder Class : itemView 안의 뷰들을 관리하는 클래스
    inner  class  VH(itemView: View): RecyclerView.ViewHolder(itemView){
//        val tvTitle=itemView.tvTitle
//        val tvMsg=itemView.tvMsg
//        val iv= itemView.iv


        init {

            //자바에서는 이 생성자에 getLayoutPosition()메소드로
            //클릭한 아이템을 구별했엇음..
            //코틀린에서는 getLayoutPosition()메소드 대신에
            //이 아탑터를 멤버변수로 이미 layoutPosition이 항상존재함
            //근데 layoutPosition 속성값이 언제나 항상-1임
            //그래서 이곳에서 클릭위치를 찾을 수 없음.
            itemView.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    //Toast.makeText(context,""+layoutPostition,Toast.LENGTH_SHORT).show()

                    val intent= Intent(context,ItemActivity::class.java)
                    intent.putExtra("title",item.get(layoutPosition).title)
                    intent.putExtra("msg",item.get(layoutPosition).msg)
                    intent.putExtra("img",item.get(layoutPosition).img)

                    context.startActivity(intent)

                }
            })

            //그래서 아이템의 위치정보가 존재하는 bindViewHolder()에서
            //클릭 이벤트 처리
        }

    }
}