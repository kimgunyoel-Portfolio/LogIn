package com.example.login.LogOut.LogOutButton;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Activity.MainActivity;
import com.example.login.R;

public class LogOutButton {

    AppCompatActivity aLogOutButton;    //!< Activity
    Button logout_bt;   //!< 로그아웃버튼

    /**
     * 생성자
     * @param appCompatActivity
     */
    public LogOutButton(AppCompatActivity appCompatActivity){
        aLogOutButton = appCompatActivity;  //!< Activity

        setLogOutButton(); //!< 로그아웃버튼 메서드
    }

    public void setLogOutButton(){
        logout_bt = (Button)aLogOutButton.findViewById(R.id.logout_bt); //!< 로그아웃버튼 id값 연결
        logout_bt.setOnClickListener(new View.OnClickListener() {   //!< 버튼 클릭리스너
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aLogOutButton, MainActivity.class);  //!< 인텐트 로그아웃Activity -> 로그인Activity
                aLogOutButton.startActivity(intent);    //!< start
                aLogOutButton.finish(); //!< finish
            }
        });



    }
}
