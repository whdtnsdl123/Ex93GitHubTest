package com.c282804.e36xmlpullparsermovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> items = new ArrayList<>();



    String apiKey="fbd5f768644c0ea41f5d012b802a65c4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);


        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
    }

    public void btn(View view) {
        //리스트뷰에 보여줄 데이터들을 네트워크를 통해 읽어아서 분석하기
        //인터넷 사용하려면 permission을 작성해야함.
        //네트워크작업은 반드시 별도의 Thread가 해야함.
        Thread t= new Thread(){
            @Override
            public void run() {


                Date date = new Date();//오늘 날짜
                date.setTime(date.getTime() - (1000*24*60*60));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//날짜를 지정한 패턴으로 만들어줌.

                String dateStr=sdf.format(date);//검색날짜 2020.05.26


                //영화진흥위원으 서버에서 '일일박스오피스'정보가 있는
                //xml문서를 읽어오기 .
                String address = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?"
                        +"key="+ apiKey
                        +"&targetDt="+dateStr;

                //###########################################################
                // api 28버전 부터 인터넷 주소가 https 가 아닌 http 로 하면 동작 안됨
                // 만약 http주소도 되게하려면... Manifest.xml에 추가작업..
                //############################################################
                //완성된 네크워크 주소와 연결 하여 데이터를 읽어오기.
                //무지개 로드(Stream)를 만들어주는 해임달(URL) 객체 생성
                try {
                    URL url = new URL(address);

                    //해임달에게 무지개로드 열어달라고 ..
                    InputStream is = url.openStream();//바이트 스트림
                    InputStreamReader isr = new InputStreamReader(is); //문자스트림으로 변경

                    //XML문서를 isr로부터 받아와서 분석해주는 분석가 객체를 만들어주는 공장생성"
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp= factory.newPullParser();//분석가 객체 생상!!
                    xpp.setInput(isr);

                    int eventType =xpp.getEventType();

                    StringBuffer buffer=new StringBuffer();//문자열을 모아놓는녀석.
                    while (eventType!=XmlPullParser.END_DOCUMENT){
                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "분석을 시작합니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;
                            case XmlPullParser.START_TAG:
                                String tagName=xpp.getName();

                                if(tagName.equals("dailyBoxOffice")){
                                    buffer= new StringBuffer();
                                }else  if(tagName.equals("rank")){
                                    buffer.append("순위 :");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else  if(tagName.equals("movieNm")){
                                    buffer.append("영화 제목 :");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");
                                }else  if(tagName.equals("openDt")){
                                    buffer.append("개봉일 :");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else  if(tagName.equals("audiCnt")){
                                    buffer.append("일 관객수 :");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else  if(tagName.equals("audiAcc")){
                                    buffer.append("누적 관객수 :");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }

                                break;
                            case XmlPullParser.TEXT:
                                break;
                            case XmlPullParser.END_TAG:
                                String tagName2=xpp.getName();
                                if (tagName2.equals("dailyBoxOffice")){
                                    //지금 까지누적된 StringBuffer를 String으로 변환
                                    String s= buffer.toString();
                                    items.add(s);
                                    //리스트뷰갱신 (화면변화는 반드시 UI Thread만
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });

                                }
                                break;
                        }
                        eventType= xpp.next();
                    }//while

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "분석이 끝났습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {


                }
            }
        };
        t.start();

    }
}
