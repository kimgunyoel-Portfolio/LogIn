package com.example.login.SignUP.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.login.R;

public class SignUpActivity extends AppCompatActivity {

    SignUp cSignUp; //!< Activity 하위클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        cSignUp = new SignUp(this); //!< Activity 하위클래스 객체 생성

    }
}