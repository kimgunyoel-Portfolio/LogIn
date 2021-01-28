package com.example.login.LogIn.SignUpButton;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.SignUP.Activity.SignUpActivity;

public class SignUpButton {


    AppCompatActivity aSignUpButton;    //!< Activity
    Button button;      //!< 회원가입 버튼 선언

    /**
     * 생성자
     * @param appCompatActivity -Activity
     */
    public SignUpButton(AppCompatActivity appCompatActivity){
        aSignUpButton = appCompatActivity;    //!< Activity
        setSignUpButton();                    //!< 회원가입버튼 메서드
    }

    /**
     * 회원가입버튼누르면  회원가입 엑티비티로 전환
     */
    public void setSignUpButton(){
        button = (Button)aSignUpButton.findViewById(R.id.sign_up_bt);       //!< 회원가입버튼 id값 연결
        button.setOnClickListener(new View.OnClickListener() {              //!< 회원가입 버튼 클릭리스너
            @Override
            public void onClick(View view) {
                System.out.println("회원가입 버튼 눌림");   //!< 디버그
                Intent intent = new Intent(aSignUpButton, SignUpActivity.class);  //!< 로그인 엑티비티에서 회원가입 엑티비티로 이동
                aSignUpButton.startActivity(intent);       //!< start
            }
        });
    }
}
