package com.example.login.LogIn.LogInButton;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.SignUP.DataBase.Request3rdParty;

public class LogInButton {

    AppCompatActivity aLogInButton; //!< Activity

    EditText id;    //!< 아이디 에딧텍스트
    EditText pw;    //!< 비밀번호 에딧텍스트
    Button loginbutton; //!< 로그인 버튼

    /**
     * 생성자
     * @param appCompatActivity
     */
    public LogInButton(AppCompatActivity appCompatActivity) {

        aLogInButton = appCompatActivity;   //!< Activity
        id = (EditText) aLogInButton.findViewById(R.id.main_id_edit);   //!< 아이디 에딧텍스트 id값 연결
        pw = (EditText) aLogInButton.findViewById(R.id.main_pw_edit);   //!< 비밀번호 에딧텍스트 pw 값 연결
        setLogInButton();   //!< 로그인버튼 메서드

    }

    public void setLogInButton() {
        loginbutton = (Button) aLogInButton.findViewById(R.id.login_bt);    //!< 로그인버튼 id값 연결
        loginbutton.setOnClickListener(new View.OnClickListener() { //!< 버튼클릭 리스너
            @Override
            public void onClick(View view) {

                String sid = id.getText().toString();   //!< 스트링변수에  에딧텍스트 아이디값 저장
                String spw = pw.getText().toString();   //!< 스트링변수에  에딕텍스트 비밀번호 값 저장

                final Request3rdParty loginRequest = new Request3rdParty(aLogInButton);   //!< Request3rdParty객체생성
                loginRequest.loginCheck("longinCheck", "login_check.php", sid, spw);    //!< 로그인체크 로그인php값 , 아이디값 비밀번호값
                loginRequest.start();   //!< start

                }
            });

        }
    }
