package com.example.login.LogIn.Activity;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.FaceBook.Facebook;
import com.example.login.LogIn.Google.Google;
import com.example.login.LogIn.Kakao.Kakao;
import com.example.login.LogIn.LogInButton.LogInButton;
import com.example.login.LogIn.Naver.Naver;
import com.example.login.LogIn.SignUpButton.SignUpButton;
import com.example.login.LogIn.VideiView.BackgroundVideoView;

public class LogIn {

    AppCompatActivity aLogIn;   //!< Activity
    Kakao cKakao;   //!< 카카오클래스
    Naver cNaver;   //!< 네이버클래스
    Facebook cFacebook; //!< 페이스북클래스
    SignUpButton cSignUpButton;
    LogInButton cLogInButton;
    BackgroundVideoView cBackgroundVideoView;

    /**
     * 생성자
     * @param appCompatActivity
     */
    public LogIn(AppCompatActivity appCompatActivity){
        aLogIn = appCompatActivity; //!< Activity
        cKakao = new Kakao(aLogIn); //!< 카카오 객체생성
        cNaver = new Naver(aLogIn); //!< 네이버 객체생성
        cFacebook = new Facebook(aLogIn);   //!< 페이스북 객체생성
        cSignUpButton = new SignUpButton(aLogIn);
        cLogInButton = new LogInButton(aLogIn);
        cBackgroundVideoView = new BackgroundVideoView(aLogIn);
        cBackgroundVideoView.setVideoView();

    }

}
