package com.example.login.LogOut.Naver;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Activity.MainActivity;
import com.example.login.LogIn.Naver.Define.NDefine;
import com.example.login.R;

public class OutNaver {

    AppCompatActivity aOutNaver;    //!< Activity
    Context mContext;   //!< 컨텍스트
    Button btn_logout;  //!< 네이버 로그아웃 버튼

    /**
     * 생성자
     * @param appCompatActivity
     */
    public OutNaver(AppCompatActivity appCompatActivity){
        aOutNaver = appCompatActivity;  //!< Activity
        setOutNaver();  //!< 네이버 로그아웃 메서드

    }

    public void setOutNaver(){
        mContext = aOutNaver.getApplicationContext();   //!< 컨텍스트 연결

        btn_logout = (Button)aOutNaver.findViewById(R.id.btn_logout);   //!< 네이버 로그아웃버튼 id값 연결
        btn_logout.setOnClickListener(new View.OnClickListener() {  //!< 버튼클릭리스너
            @Override
            public void onClick(View view) {
                NDefine.ins().mOAuthLoginModule.logout(mContext);   //!< 싱글톤mOAuthLoginModule 로그아웃
                Toast.makeText(aOutNaver, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();    //!< 토스트메시지
                Intent intent = new Intent(aOutNaver, MainActivity.class);  //!< 인텐트 로그아웃Activity -> 로그인 Activity
                aOutNaver.startActivity(intent);    //!< start
                aOutNaver.finish(); //!< finish
            }
        });

    }
}
