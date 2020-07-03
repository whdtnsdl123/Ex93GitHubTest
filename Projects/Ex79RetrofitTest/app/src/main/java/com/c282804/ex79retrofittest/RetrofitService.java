package com.c282804.ex79retrofittest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitService {

    //1. 단순하게 Get방식으로 json문자열 읽어오는 추상메소드.
    @GET("/Retrofit/board.json")
    Call<BoardItem> getBoardJson();

    //2. 경로의 이름을 1번처럼 고정하지않고 파라미터로 받아 지정가능.
    @GET("/{folder}/board.json")
    Call<BoardItem> getBoardJsonByPath(@Path("folder") String folder);

    //3. GET방식으로 서버에 데이터 전달 [@Query]
    @GET("/Retrofit/getTest.php")
    Call<BoardItem> getMethodTest(String name, @Query("msg") String msg);

    //4. GET방식으로 값 전달하면서 경로파일명도 지정[@Query,@Path]
    @GET("/Retrofit/{filename}")
    Call<BoardItem> getMetodTest2(@Path("filename") String filename,@Query("name") String name, @Query("msg") String msg);

    //5.Get방식으로 보낼 값들을 Map collection 으로 한방에 전달하기!
    @GET("/Retrofit/getTest.php")
    Call<BoardItem> getMethodTest3(@QueryMap Map<String,String>datas);





}
