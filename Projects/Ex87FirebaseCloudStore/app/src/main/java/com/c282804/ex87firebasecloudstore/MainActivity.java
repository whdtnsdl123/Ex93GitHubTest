package com.c282804.ex87firebasecloudstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickSave(View view) {

        //firestore에 db에 저장 - Collection을 통으로 저장
        //저장헬 데이터를 Map으로 생성
        Map<String, Object> user= new HashMap<>();
        user.put("name","sam");
        user.put("age",20);
        user.put("address","seoul");

        FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();

        //"users"이라는 이름의 Collection(자식노드같은 개념 )참조
        CollectionReference userRef= firebaseFirestore.collection("user");//하위 폴더같은느낌
        Task task =userRef.add(user);

        task.addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void clickLoad(View view) {
        //firestore db에서 get()메소드를 이용하여 DB값 읽기

        FirebaseFirestore firebaseFirestore= FirebaseFirestore.getInstance();
        CollectionReference userRef= firebaseFirestore.collection("user");

        Task<QuerySnapshot> task=userRef.get();
        task.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    QuerySnapshot queryDocumentSnapshots= task.` `
                }
            }
        })
    }
}
