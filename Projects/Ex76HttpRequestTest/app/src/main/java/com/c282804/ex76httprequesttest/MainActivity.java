package com.c282804.ex76httprequesttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMsg;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= findViewById(R.id.et_name);
        etMsg= findViewById(R.id.et_msg);
        tv=findViewById(R.id.tv);
    }

    public void clickGEt(View view) {
        //별도의 Thread만이 Network작업 가능
        new Thread(){
            @Override
            public void run() {

                //보낼 데이터 얻어오기
                String name= etName.getText().toString();
                String msg=etMsg.getText().toString();

                //GET방식으로 보낼 서버에 주소
                String serverUrl="http://c282804.dothome.co.kr/HttpRequest/Android/getTest.php";

                //GEt방식 보낼 데이터를 URL뒤에 ?하고 덧붙여서 보내는 방식.

                //단, 한글은URL에 사용 불가! 그래서 한글을 utf-8로 인코딩해야 함.
                try {
                    name=URLEncoder.encode(name,"utf-8");
                    msg= URLEncoder.encode(msg,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                //데이터를 포함한 최종 요청url
                String geturl = serverUrl+"?name="+name+"&msg"+msg;

                //getUrl주소의 서버와 연결하는 무지개로드를 만들어주는 해임달객체생성
                try {
                    URL url =new URL(geturl);

                    //URL은 InputStream만 열수 잇음.
                    //Input,Output을 모두 열수잇는 해임달의 후계자객체사용.
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);

                    //보낼 데이타가 이싿면 여기서 OutputStream을 만들어서 write..
                    //Get방식은 이미 URL에 보낼 데이터가 전달되었기에 별도의 write작업이불필요함.
                    //wmr,GEt방식을 서버와 연결하는 순간(new URL(getUrl))에 이미 데이터를 보낸
                    OutputStream os= connection.getOutputStream();
                    //os.write();
                    //os.flush();

                    //getTest.php가 echo해준 문자열을 읽어오기 위해 InputStream필요
                    InputStream is =connection.getInputStream();
                    InputStreamReader isr= new InputStreamReader(is);
                    BufferedReader reader =new BufferedReader(isr);

                    final StringBuffer buffer= new StringBuffer();
                    while (true){

                        String line= reader.readLine();
                        if(line==null)break;

                        buffer.append(line+"\n");
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(buffer.toString());
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    public void clickPost(View view) {
        new Thread() {
            @Override
            public void run() {

                String name=etName.getText().toString();
                String msg =etMsg.getText().toString();

                //서버주소
                String serverUrl="http://c282804.dothome.co.kr/Android/postTest.php";

                //POST방식이므로 OUTPUTStream을 만들어ㅓ 데이터를 Write해야함.

                try {
                    URL url = new URL(serverUrl);

                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("Post");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);

                    //보낼데이터
                    String query= "name"+name+"$msg="+msg;

                    OutputStream os= connection.getOutputStream();
                    OutputStreamWriter writer= new OutputStreamWriter(os);

                    writer.write(query,0,query.length());
                    writer.flush();
                    writer.close();

                    //postTest.php에서 echo된 결과 데이터 받아오기
                    InputStream is = connection.getInputStream();
                    InputStreamReader isr= new InputStreamReader(is);
                    BufferedReader reader = new BufferedReader(isr);

                    final StringBuffer buffer=new StringBuffer();
                    while (true){
                        String line = reader.readLine();
                        if(line==null) break;

                        buffer.append(line+"\n");
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(buffer.toString());
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }.start();
    }

    public void clickUpload(View view) {
        //서버의 Datebase에 저장하기
        new Thread(){
            @Override
            public void run() {
                String name= etName.getText().toString();
                String msg = etMsg.getText().toString();

                String serverUrl="";

                try {
                    URL url = new URL(serverUrl);
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);

                    String query= "name="+name+"&msg="+msg;

                    OutputStream os = connection.getOutputStream();
                    os.write(query.getBytes());//String->byte[]
                    os.flush();
                    os.close();

                    InputStream is = connection.getInputStream();
                    InputStreamReader isr= new InputStreamReader(is);
                    BufferedReader reader =new BufferedReader(isr);

                    StringBuffer buffer =new StringBuffer();
                    while (true){
                        String line = reader.readLine();
                        if(line==null)break;
                        buffer.append(line+"\n");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clickload(View view) {
    }
}


