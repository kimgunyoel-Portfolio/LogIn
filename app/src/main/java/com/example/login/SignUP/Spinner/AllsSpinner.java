package com.example.login.SignUP.Spinner;


import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.SignUP.Spinner.Define.Definespinner;

public class AllsSpinner {

    AppCompatActivity aAllsSpinner;     //!< Activity
    android.widget.Spinner eamilspinner, phonespinner;  //!< 이메일 , 전화번호 스피너 변수

    /**
     * 생성자
     * @param appCompatActivity
     */
    public AllsSpinner(AppCompatActivity appCompatActivity){
        aAllsSpinner = appCompatActivity;   //!< Activity
        setSpinner();   //!< 스피너 메서드
    }

    public void setSpinner(){

        eamilspinner = (android.widget.Spinner) aAllsSpinner.findViewById(R.id.email_spinner);  //!< 이메일 스피너 id값 연결
        eamilspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   //!< 이메일 스피너클릭 리스너
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("이메일 스피너 눌림");   //!< 디버그
                Definespinner.ins().emailspinner = eamilspinner.getSelectedItem().toString();   //!< 싱글톤 변수에 이메일정보 저장
                System.out.println("이메일 스피너 정보 : " + Definespinner.ins().emailspinner );    //!< 디버그
                System.out.println("이메일은 : " + parent.getItemAtPosition(position)); //!< 디버그
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        phonespinner = (android.widget.Spinner) aAllsSpinner.findViewById(R.id.phone_spinner);  //!< 전화번호 스피너 id값 연결
        phonespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   //!< 전화번호 스피너클릭 리스너
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("전화번호 스피너 눌림");  //!< 디버그
                Definespinner.ins().phonespinner = phonespinner.getSelectedItem().toString();   //!< 싱글톤 변수에 전화번호 정보 저장
                System.out.println("전화번호 스피너 정보 : " + Definespinner.ins().phonespinner);//!< 디버그
                System.out.println("전화번호는 : " + parent.getItemAtPosition(position) );   //!< 디버그
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
