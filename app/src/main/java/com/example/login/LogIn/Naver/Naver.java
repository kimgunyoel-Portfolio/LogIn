package com.example.login.LogIn.Naver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Naver.Define.NDefine;
import com.example.login.LogOut.Activity.LogOutActivity;
import com.example.login.R;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;

public class Naver {

    AppCompatActivity aNaver;   //!< Activity
    LinearLayout ll_naver_login;    //!< 리니어레이아웃

    OAuthLogin mOAuthLoginModule;
    Context mContext;   //!< 컨텍스트

    /**
     * 생성자
     * @param appCompatActivity
     */
    public Naver(AppCompatActivity appCompatActivity){
        aNaver = appCompatActivity; //!< Activity
        setNaver(); //!< 네이버 메서드

    }

    public void setNaver(){

        mContext = aNaver.getApplicationContext();  //!< 컨텍스트 연결

        ll_naver_login = aNaver.findViewById(R.id.ll_naver_login);  //!< 네이버로그인버튼 레이아웃 id값 연결
        ll_naver_login.setOnClickListener(new View.OnClickListener() {  //!< 버튼클릭리스너
            @Override
            public void onClick(View view) {
                NDefine.ins().mOAuthLoginModule = OAuthLogin.getInstance(); //!< 싱글톤변수에 정보저장
                NDefine.ins().mOAuthLoginModule.init(   //!<초기화
                        mContext
                        ,aNaver.getString(R.string.naver_client_id) //!< 네이버 아이디 저장
                        ,aNaver.getString(R.string.naver_client_secret)  //!< 네이버 비번저장
                        ,aNaver.getString(R.string.naver_client_name)   //!< 네이버이름저장
                        //,OAUTH_CALLBACK_INTENT
                        // SDK 4.1.4 버전부터는 OAUTH_CALLBACK_INTENT변수를 사용하지 않습니다.
                );

                @SuppressLint("HandlerLeak")
                OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {    //!< 핸들러객체생성
                    @Override
                    public void run(boolean success) {
                        if (success) {  //!< 로그인성공할때
                            String accessToken = NDefine.ins().mOAuthLoginModule.getAccessToken(mContext);
                            String refreshToken = NDefine.ins().mOAuthLoginModule.getRefreshToken(mContext);
                            long expiresAt = NDefine.ins().mOAuthLoginModule.getExpiresAt(mContext);
                            String tokenType = NDefine.ins().mOAuthLoginModule.getTokenType(mContext);


                            System.out.println("accessToken :" + accessToken);
                            System.out.println("refreshToken :" + refreshToken);
                            System.out.println("expiresAt : " + expiresAt);
                            System.out.println("tokenType : " + tokenType );

                            Intent intent = new Intent(aNaver , LogOutActivity.class);  //!< 인텐트 로그인Activity -> 로그아웃Activity
                            aNaver.startActivity(intent);   //!< start
                            aNaver.finish();    //!< finisg

                        } else {    //!< 로그인실패할때
                            String errorCode = NDefine.ins().mOAuthLoginModule
                                    .getLastErrorCode(mContext).getCode();
                            String errorDesc = NDefine.ins().mOAuthLoginModule.getLastErrorDesc(mContext);
                            Toast.makeText(mContext, "errorCode:" + errorCode
                                    + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
                        }
                    };
                };

                NDefine.ins().mOAuthLoginModule.startOauthLoginActivity(aNaver, mOAuthLoginHandler);    //!< 메서드를 직접 실행해 로그인하면 먼저 갱신 토큰이 있는지 확인

            }
        });

    }
}
