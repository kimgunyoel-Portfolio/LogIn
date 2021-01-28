package com.example.login.LogOut.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogOut.Facebook.OutFacebook;
import com.example.login.LogOut.Kakao.OutKakao;
import com.example.login.LogOut.LogOutButton.LogOutButton;
import com.example.login.LogOut.Naver.OutNaver;

public class LogOut {
    AppCompatActivity aLogOut;

    OutKakao cOutKakao;
    OutNaver cOutNaver;
    OutFacebook cOutFacebook;
//    OutGoogle cOutGoogle;
    LogOutButton cLogOutButton;


    public LogOut(AppCompatActivity appCompatActivity){
        aLogOut = appCompatActivity;

        cOutKakao = new OutKakao(aLogOut);
        cOutNaver = new OutNaver(aLogOut);
        cOutFacebook = new OutFacebook(aLogOut);
//        cOutGoogle = new OutGoogle(aLogOut);
        cLogOutButton = new LogOutButton(aLogOut);

    }
}
