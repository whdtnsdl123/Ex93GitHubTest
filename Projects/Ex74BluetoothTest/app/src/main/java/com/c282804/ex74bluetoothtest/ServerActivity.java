package com.c282804.ex74bluetoothtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ServerActivity extends AppCompatActivity {

    //블루투스 하드웨어 장치에 대한 식별자 UUID
    static final UUID BT_UUID= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    TextView tv;

    BluetoothAdapter bluetoothAdapter;

    BluetoothServerSocket serverSocket;
    BluetoothSocket socket;

    //데이터를 주고받기 위한 스트림(자료형 단위로 보낼 수 있는 Stream)
    DataInputStream dis;
    DataOutputStream dos;


    ServerThread serverThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);


        //액션바 제목명 변경
        getSupportActionBar().setTitle("SERVER");

        tv=findViewById(R.id.tv);


        //블루투스 관리자 객체 생성
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter== null){
            Toast.makeText(this, "이 기기에는 블루투스가 없습니다.", Toast.LENGTH_SHORT).show();
            finish(); //바로 이곳에 애기비티가 종료되지 않음. 그래서..아래  return
            return;
        }


        //위에서 return되지 않았다면 블루투스 장치가 이|ㅆ다는 것임.
        //블루투스 장치가 켜져있는지 체크 및  On하도록 요청
        if(bluetoothAdapter.isEnabled()){
            //서버소켓 생성 작업 실행
            createServerSocket();

        }else {
            //블루투스 장치를On선택하도록 하는 화면 (액티비티로)전환
            Intent intent =new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,10);

       }


    }//onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 10:
                if (resultCode==RESULT_CANCELED){
                    //서버 소켓 생성 작업

                    Toast.makeText(this, "블루투스 허용하지 않았습니다.\n 앱을 종료합니다.", Toast.LENGTH_SHORT).show();
                    createServerSocket();
                    finish();
                }else {//블루투스를 켰으므로..
                    //서버소켓 생성 작업

                    createServerSocket();

                }
                break;
        }
    }

    //서버 소켓 생성작업 메소드
    void  createServerSocket(){
        //통신작업은 반드시 별도의 Thread가 해야 함 .

        serverThread= new ServerThread();
        serverThread.start();

    }
    //서버 소켓 작업 및 통신을 하는 별도 Thread 클래스 설계 : Inner class
    class  ServerThread extends Thread{
        @Override
        public void run() {
            //서버소켓 생성
            try {
                serverSocket= bluetoothAdapter.listenUsingRfcommWithServiceRecord("SERVER",BT_UUID);

                //클라이언트 접속을 기다리
                socket= serverSocket.accept();//커서가 여기서 대기하고
                setUI()
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//run
        //Ui Thread로 메세지 출력하는 기능.
        void SetUI(final String msg){
            onActivityResult(new On);


        }
    }//ServerThread

}
