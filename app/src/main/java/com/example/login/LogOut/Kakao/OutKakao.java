package com.example.login.LogOut.Kakao;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Activity.MainActivity;
import com.example.login.LogOut.Activity.LogOutActivity;
import com.example.login.R;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class OutKakao {

    AppCompatActivity aOutKakao;    //!< Activity
    private Button btn_custom_login_out;    //!< 카카오 로그아웃 버튼

    /**
     * 생성자
     * @param appCompatActivity
     */
    public OutKakao(AppCompatActivity appCompatActivity){
        aOutKakao = appCompatActivity;  //!< Activity
        setOutKakao();  //!< 카카오 메서드

    }

    public void setOutKakao(){
        btn_custom_login_out = (Button) aOutKakao.findViewById(R.id.btn_custom_login_out);  //!< 카카오 로그아웃 버튼 id값 연결
        btn_custom_login_out.setOnClickListener(new View.OnClickListener() {    //!< 버튼 클릭리스너
            @Override
            public void onClick(View v) {
                System.out.println("로그아웃 버튼 눌림");   //!< 디버그
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {   //!< 카카오 매니저 정보 로그아웃
                    @Override
                    public void onCompleteLogout() {
                        System.out.println("로그아웃 확인");  //!< 디버그
                        Intent intent = new Intent(aOutKakao, MainActivity.class);  //!< 인텐트 로그아웃Activity -> 로그인 Activity
                        aOutKakao.startActivity(intent);    //!< start
                        aOutKakao.finish(); //!< finish
                    }
                });
            }
        });

    }
}
