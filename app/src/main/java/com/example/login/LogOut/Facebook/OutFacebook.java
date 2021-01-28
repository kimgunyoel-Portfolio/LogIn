package com.example.login.LogOut.Facebook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Activity.MainActivity;
import com.example.login.LogIn.FaceBook.Define.FDefine;
import com.example.login.R;
import com.facebook.login.LoginManager;

public class OutFacebook {

    AppCompatActivity aOutFacebook; //!< Activity
    Button btn_custom_logout;   //!< 페이스북 로그아웃버튼

    /**
     * 생성자
     * @param appCompatActivity
     */
    public OutFacebook(AppCompatActivity appCompatActivity){
        aOutFacebook = appCompatActivity;   //!< Activity
        setOutFacebook();   //!< 로그아웃 메서드

    }

    public void setOutFacebook(){
        btn_custom_logout = (Button)aOutFacebook.findViewById(R.id.btn_fcustom_logout); //!< 로그아웃버튼 id값 연결
        btn_custom_logout.setOnClickListener(new View.OnClickListener() {   //!< 버튼클릭리스너
            @Override
            public void onClick(View view) {
                System.out.println("페이스북 로그아웃버튼 눌림");   //!< 디버그
                FDefine.ins().mLoginManager.getInstance().logOut(); //!< 싱글톤 페이스북 로그인매니저 로그아웃
                Intent intent = new Intent(aOutFacebook , MainActivity.class);  //!< 인텐트  로그아웃Activity -> 로그인 Activity
                aOutFacebook.startActivity(intent); //!< start
                aOutFacebook.finish();  //!< finish
            }
        });


    }
}
