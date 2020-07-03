package com.c282804.ex84firebasestorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.iv);

        String[] permission=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
         if (checkSelfPermission(permission[0])== PackageManager.PERMISSION_DENIED){
             requestPermissions(permission,100);
         }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100 && grantResults[0]==PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, "업로드 하지마.", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickLoad(View view) {


        //fire storage 에 있는 이미지 보여주기 .

        //저장된 이미지의 URL을 얻어와서 이미지뷰에 보여주기!

        //Firebase storage 관리객체 소환.
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        //최상위 참조객체 얻어오기.
        StorageReference rootRef= firebaseStorage.getReference();

        //읽어오길 원하는 파일의 참조객체 얻어오기.
//        StorageReference imgRef = rootRef.child("moana01.jpg");
        StorageReference imgRef = rootRef.child("photos/moana01.jpg");

        //파일 참조객체로 부터 이미지의 URL을 얻어오기.
        if( imgRef !=null){
            //참조객체로부터 URL을 얻어오는 작업이 성공되었다는
            imgRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(MainActivity.this).load(uri).into(iv);

                }
            });

        }

    }

    public void clickSelect(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");

        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==10 &&requestCode==RESULT_OK){
            Uri uri = data.getData();
            Glide.with(this).load(uri).into(iv);

            imgUri=uri;
        }
    }

    Uri imgUri;
    public void clickUpload(View view) {
        //Firebase Storage 관리자 소환
        FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();

        //업로드해서 저장될 파일명이 같으면 덮어쓰기 되므로..
        // 날짜를 이용해서 파일명을 만들어냄.
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName=sdf.format(new Date())+".png";//20200623142931

        //업로드할 파일의 참조객체 만들기
        StorageReference imgRef= firebaseStorage.getReference("uploads/"+fileName);

        //위 위치의 참조객체에 이미지파일데이터 덩어리 보내기 .
//        imgRef.putFile(imgUri);

        //업로드의 성공결과를 알고 싶다면..(Task : 별도 Thread객체와 비슷 )
        UploadTask task = imgRef.putFile(imgUri);
        task.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(MainActivity.this, "시발 ", Toast.LENGTH_SHORT).show();

            }
        });








    }
}
