package com.example.login.LogOut.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.login.R;

public class LogOutActivity extends AppCompatActivity {

    LogOut cLogOut; //!< Activity 하위클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        cLogOut = new LogOut(this); //!< Acitvity하위클래스 객체생성
    }

}