package com.example.login.SignUP.DataBase;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogOut.Activity.LogOutActivity;
import com.example.login.SignUP.DataBase.Define.DefineDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request3rdParty extends Thread{
    AppCompatActivity aRequest3rdParty; //!< Activity
    private String sStats;
    private String sAddr;
    private String sId;
    private String sPw;
    private String sEmail;
    private String sPhone;
    private String sResult;

    /**
     * 생성자
     * @param appCompatActivity
     */
    public Request3rdParty(AppCompatActivity appCompatActivity) {
        aRequest3rdParty = appCompatActivity;   //!< Activity
    }

    //!< 리퀘스트 정보 메서드
    public void Setting(String stats ,String addr, String id, String pw, String email, String phone) {
        sStats = stats;
        sAddr	= DefineDB.ADDR_SMART + addr;
        sId = id;
        sPw = pw;
        sEmail = email;
        sPhone = phone;
        sResult 	= "";
    }
    //!< 로그인 체크 메서드
    public void loginCheck(String stats, String addr,String id, String pw) {
        this.sAddr = DefineDB.ADDR_SMART + addr;
        this.sStats = stats;
        this.sId = id;
        this.sPw = pw;
    }

    @Override
    public void run() {
        super.run();

        StringBuilder html = new StringBuilder();
        BufferedReader bufferReader = null;
        PrintWriter printWriter	= null;

        System.out.println("add : "+sAddr);
        try {
            URL url = new URL(sAddr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);

            connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");

            StringBuffer buffer = new StringBuffer();

            if(sStats.equals("signIn")) {
                buffer.append("id").append("=").append(sId).append("&");
                buffer.append("pw").append("=").append(sPw).append("&");
                buffer.append("email").append("=").append(sEmail).append("&");
                buffer.append("phone").append("=").append(sPhone);
                System.out.println("Send : " + buffer.toString());
            }
            else if(sStats.equals("longinCheck")) {
                buffer.append("id").append("=").append(sId).append("&");
                buffer.append("pw").append("=").append(sPw);
                System.out.println("Send : " + buffer.toString());
            }

            OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            printWriter = new PrintWriter(output);
            printWriter.write(buffer.toString());
            printWriter.flush();

            InputStreamReader input = new InputStreamReader(connection.getInputStream());
            bufferReader = new BufferedReader(input);

            while (true)
            {
                String line = bufferReader.readLine();
                if (line == null)
                {
                    break;
                }
                html.append(line).append("&");
            }

            bufferReader.close();
            input.close();
            printWriter.close();
            output.close();
            connection.disconnect();

            sResult = html.toString();
            System.out.println("sResult : " + sResult);

            //!< 로그인성공하면 로그아웃Activity로 이동
            if(sStats.equals("longinCheck")) {
                if(sResult.contains("login_success")) {
                    System.out.println("로그인 성공");
                    Intent intent = new Intent(aRequest3rdParty, LogOutActivity.class);
                    aRequest3rdParty.startActivity(intent);
                    aRequest3rdParty.finish();
                }
            //!< 로그인실패하면 토스트메시지 출력
                if(sResult.contains("login_fail")) {
                    System.out.println("로그인 실패");
                    aRequest3rdParty.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(aRequest3rdParty.getApplicationContext(),"로그인실패", Toast.LENGTH_SHORT).show();
                        }
                    });


                }

            }

        } catch (Exception e) {
            e.printStackTrace();

            DefineDB.ins().setRequestError(true);

            try {
                if(printWriter != null) printWriter.close();
                if(bufferReader != null) bufferReader.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public String getResult() {
        return sResult;
    }


}
