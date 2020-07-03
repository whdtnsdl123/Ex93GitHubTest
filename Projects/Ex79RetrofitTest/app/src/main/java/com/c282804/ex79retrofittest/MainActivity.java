package com.c282804.ex79retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
    }

    public void Btn(View view) {
        //네트워크에서 읽어들이 json을 곧바로 객체로 생성까지..

        //Retrofit2 라이브러리로 HTTP 통신작업을 시작.
        //1. retrofit객체 생성 및 설정.
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://c282804.dothome.co.kr");//서버의 기본주소
        builder.addConverterFactory(GsonConverterFactory.create());//읽어온 json을 GSON을 이용해서 파싱하기 위해나 설정.;
        Retrofit retrofit= builder.build();

        //2. RetrofitService 인터페이스 설계
        //원하는 기능의 추상메소드를 설계

        //3. RetrofitService 인터페이스를 객체로 생성
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        //서비스객체의 추상메소드의 기능들을 알아서  retrofit이 만들어냄..

        //4. 서비스객체의 원하는 기능메소드 실행해서 Call객체 얻어오기.
        Call<BoardItem>call= retrofitService.getBoardJson();

        //5. 원하는 기능을 network작업을 수행하도록 call객체를 큐에 삽입.
        call.enqueue(new Callback<BoardItem>() {
            @Override
            public void onResponse(Call<BoardItem> call, Response<BoardItem> response) {
                Toast.makeText(MainActivity.this, "응답완료", Toast.LENGTH_SHORT).show();

                if(response.isSuccessful()){
                    //응답객체로부터 Gson라이브러리에 의해 자동으로 BoardItem으로
                    //파싱되어 있는 json문자열의 데이터 body얻어오기
                    BoardItem item = response.body();
                    tv.setText(item.name+","+ item.msg);

                }
            }

            @Override
            public void onFailure(Call<BoardItem> call, Throwable t) {
                Toast.makeText(MainActivity.this, "응답실패", Toast.LENGTH_SHORT).show();

            }
        });




    }

    public void Btn2(View view) {
        //1.Retrofit객체 생성 밀 설정.
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://c282804.dothome.co.kr");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();

        //2.RetrofitService 인터페이스에 원하는 기능 추상메소드설계.
        //getBoardbypath()

        //3.RetrofitService 객체 생성
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);

        //4. 원하는 기능메소드를 호출하여 네트워크 작업을 하는 객체를 리턴.
        Call<BoardItem> call = retrofitService.getBoardJsonByPath("Retrofit");

        //5. 실제 네트워크 작업 실행.
        call.enqueue(new Callback<BoardItem>() {
            @Override
            public void onResponse(Call<BoardItem> call, Response<BoardItem> response) {
                if(response.isSuccessful()){
                    BoardItem item =response.body();
                    tv.setText(item.name+","+item.msg);
                }
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BoardItem> call, Throwable t) {

            }
        });
    }

    public void Btn3(View view) {
        //1.
        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();

        //2. getMethodTest()

       RetrofitService retrofitService=retrofit.create(RetrofitService);
       Call<BoardItem> call = retrofitService.getMethodTest("robin","")
    }

    public void clickBtn4(View view) {
        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<BoardItem> call = retrofitService.getMethodTest2("get");
        call.enqueue(new Callback<BoardItem>() {
            @Override
            public void onResponse(Call<BoardItem> call, Response<BoardItem> response) {
                if(response.isSuccessful()){
                    BoardItem item = response.body();

                    tv.setText(item.name+","+item.msg);
                }
            }

            @Override
            public void onFailure(Call<BoardItem> call, Throwable t) {

            }
        });

    }

    public void clickBtn5(View view) {
        Retrofit retrofit =RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        //서버에 전달할 데이터들을 Map Collection에 저장
        Map<String,String> datas= new HashMap<>();
        datas.put("name", "pack");
        datas.put("msg")
        // Call<BoardItem> call =retrofitService.getMethodTest3();
    }
}
