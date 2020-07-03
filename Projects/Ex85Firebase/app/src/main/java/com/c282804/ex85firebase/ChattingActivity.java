package com.c282804.ex85firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class ChattingActivity extends AppCompatActivity {

    ListView listView;

    FirebaseDatabase firebaseDatabase;
    ChatAdapter adapter;
    ArrayList<MessageItem> messageItems= new ArrayList<>();
    EditText etMsg;
    DatabaseReference chatRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        listView=findViewById(R.id.listview);

        etMsg=findViewById(R.id.et_msg);

        adapter= new ChatAdapter(this,messageItems);
        listView.setAdapter(adapter);

        //Firebase DB의 chat이라는 이름으 ㅣ자식노드에 채팅데이터들 저장
        //chat 이름을 변경하면 여러채팅방 제작이 가능
        firebaseDatabase = FirebaseDatabase.getInstance();
        chatRef= firebaseDatabase.getReference("chat");

        //채팅메세지의 변경 내역ㄷ에 반응하는 리스너 추가
        //ValueEventListener는 값 변경시 마다 전체 대이터를 다시 줌
        chatRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //추가된 메세지 데이터 하나의 스냅샷 줌 .
                MessageItem messageItem=dataSnapshot.getValue(MessageItem.class);

                //새로 추가 된 아이템을 리스트에 추가
                messageItems.add(messageItem);
                adapter.notifyDataSetChanged();
                //리스트뷰에 커서 위치를 가장 마지막 아이템 포지션
                listView.setSelection(messageItems.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public  void clicksend(View view){
        //firebase DB에 저장할 데이터들
        String name= G.nickname;
        String message=etMsg.getText().toString();
        String profileurl=G.profileUri;

        //메세지 작성시작 문자열
        Calendar calendar=Calendar.getInstance();
        String time=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);

        //객체를 한번에 저장하기 ㅜ이해
        MessageItem messageItem= new MessageItem(name,message,time,profileurl);

        chatRef.push().setValue(messageItem);//객체를 한번에 저장

        etMsg.setText("");

        //키패드를 안보이도록
        InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}
