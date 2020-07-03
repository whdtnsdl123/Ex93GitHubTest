package com.c282804.ex70cameratest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);

    }

    public void clickFAB(View view) {

        //카메라 앱 실행하는 인텐트 생성
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //결과를 받아와야함
        startActivityForResult(intent, 20);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 20:
                //카메라 앱 에서 캡처한 결과를 가져왔는지?
                if (requestCode == RESULT_OK) {
                    //디바이스마다 프로그래밍으로 실행한 카메라앱은
                    //사진 캡쳐 후 저장방식이 다름
                    //M이후 버전부터 대부분의 디바이스에서는 인텐트로 실행한 카메라앱으로 직은 사진을 디바이스에 저장하지 않음.
                    //저장하지 않고 사진의 BItmap 객체를 만들어 전달해 줌 .
                    //즉, 사진의 경로인 Uri가 없을 수 있다는 것 임.

                    //인텐트객체에게 Uri를 가져왔는지..
                    Uri uri = data.getData();

                    if (uri != null) {//파일러 저장되는 방식의 디바이스
                        Toast.makeText(this, "Uri로 저장", Toast.LENGTH_SHORT).show();
                        Glide.with(this).load(uri).into(iv);
                    } else {//Bitmap으로 전달되는 방식의 디바이스
                        Toast.makeText(this, "저장없이 Bitmap으로 ", Toast.LENGTH_SHORT).show();

                        //Bitmap객체를 Intent의 Extra데이터로 전달 해줌
                        Bundle bundle = data.getExtras();
                        Bitmap bm = (Bitmap) bundle.get("data");

                        Glide.with(this).load(bm).into(iv);

                        //비트맵으로 왔다는 것은 캡처한 사진이 디바이스에 저장되어 있지 않다는 것임.
                        //만약 저장하고 싶다면.. 꽤 복잡한 코드 작업이 추가됨.. 다음 예제로..
                        //Bitmap으로 전달 된 데이터는 해상도가 낮은 섬네일 이미지임.

                    }
                    break;
                }
        }
    }
}
