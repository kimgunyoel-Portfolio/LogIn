package com.example.login.LogIn.Kakao;

import com.example.login.LogIn.Kakao.Define.KDefine;
import com.example.login.LogOut.Activity.LogOutActivity;
import com.kakao.auth.Session;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Activity.MainActivity;
import com.example.login.R;
import com.kakao.auth.AuthType;

public class Kakao {

    AppCompatActivity aKakao;   //!< Activity

    private Button btn_custom_login;    //!< 카카오 로그인 버튼
    private SessionCallback sessionCallback = new SessionCallback();    //!< 세션콜백

    /**
     * 생성자
     * @param appCompatActivity
     */
    public Kakao(AppCompatActivity appCompatActivity){
        aKakao = appCompatActivity; //!< Activity
        setKakao(); //!< 카카오 행동처리 메서드

    }

    public void setKakao(){
        //session = KDefine.ins().mSession.getCurrentSession();
        KDefine.ins().mSession = Session.getCurrentSession();   //!< 싱글톤 세션에 로그인 정보저장
        KDefine.ins().mSession.addCallback(sessionCallback);    //!< 싱글톤 세션에 세션콜백 저장

        btn_custom_login = (Button) aKakao.findViewById(R.id.btn_custom_login); //!< 카카오로그인버튼 id값 연결
        btn_custom_login.setOnClickListener(new View.OnClickListener() {    //!< 버튼클릭리스너
            @Override
            public void onClick(View view) {
                KDefine.ins().mSession.open(AuthType.KAKAO_LOGIN_ALL, aKakao);  //!< 세션오픈
                Intent intent = new Intent(aKakao, LogOutActivity.class);   //!< 인텐트 로그인Activity -> 로그아웃Activity
                aKakao.startActivity(intent);   //!< start
                aKakao.finish();    //!< finish
            }
        });

    }

}
