package com.c282804.ex85firebasechatting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {

    ListView listView;
    EditText etMsg;
    ArrayList<MessageItem> items = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        listView=findViewById(R.id.listview);
        etMsg=findViewById(R.id.et_msg);

    }

    public void clickSend(View view) {
    }
}
