package com.example.login.SignUP.CheckBox;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.SignUP.CheckBox.Define.DefineCheck;

import java.util.regex.Pattern;

public class AllCheckBox {

    AppCompatActivity aAllCheckBox; //!< Activity
    CheckBox checkBox , checkBoxx;  //!< 체크박스 변수

    /**
     * 생성자
     * @param appCompatActivity
     */
    public AllCheckBox(AppCompatActivity appCompatActivity){

        aAllCheckBox = appCompatActivity;   //!< Activity

        //!< 체크박스 id값 연결
        checkBox =(CheckBox)aAllCheckBox.findViewById(R.id.checkbox_1); //!< 이용약관동의 체크박스 id값 연결
        checkBoxx = (CheckBox)aAllCheckBox.findViewById(R.id.checkbox_2);//!< 개인정보 보호 체크박스 id값 연결

        setAllCheckBox();   //!< 체크박스 메서드

    }


    public void setAllCheckBox(){
        checkBox.setOnClickListener(new CheckBox.OnClickListener() {    //!< 이용약관동의 체크박스 클릭리스너
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) { //!< 이용약관동의 체크박스가 클릭되면
                    System.out.println("이용약관 체크박스 체크됨");    //!< 디버그
                    DefineCheck.ins().bCheck = true;    //!< 싱글톤 불변수 true
                } else {    //!< 이용약관동의 체크박스가 클릭안되면
                    DefineCheck.ins().bCheck = false;   //!< 싱글톤 불변수 false
                    System.out.println("이용약관 체크박스 체크안됨");   //!< 디버그
                }
            }
        });

        checkBoxx.setOnClickListener(new CheckBox.OnClickListener() {   //!< 개인정보 보호 체크박스 클릭리스너
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){   //!< 개인정보 보호 체크박스가 클릭되면
                    System.out.println("개인정보 보호 체크박스 체크됨"); //!< 디버그
                    DefineCheck.ins().bCheckk = true;   //!< 싱글톤 불변수 true
                } else {    //!< 개인정보 보호 체크박스가 클릭안되면
                    System.out.println("개인정보 보호 체크박스 체크안됨");    //!< 디버그
                    DefineCheck.ins().bCheckk = false;  //!< 싱글톤 불변수 false
                }
            }
        });

    }
}
