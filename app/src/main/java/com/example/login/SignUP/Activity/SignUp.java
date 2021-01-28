package com.example.login.SignUP.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.SignUP.Button.AllButton;
import com.example.login.SignUP.CheckBox.AllCheckBox;
import com.example.login.SignUP.EditText.AllEditText;
import com.example.login.SignUP.Spinner.AllsSpinner;

public class SignUp {

    AppCompatActivity aSignUp;  //!< Activity
    AllsSpinner cAllsSpinner;   //!< 스피너클래스
    AllEditText cAllEditText;   //!< 에딧텍스트클래스
    AllButton cAllButton;       //!< 버튼 클래스
    AllCheckBox cAllCheckBox;   //!< 체크박스 클래스

    /**
     * 생성자
     * @param appCompatActivity
     */
    public SignUp(AppCompatActivity appCompatActivity){

        aSignUp = appCompatActivity;                //!< Activity
        cAllsSpinner = new AllsSpinner(aSignUp);    //!< 스피너클래스 객체생성
        cAllEditText = new AllEditText(aSignUp);    //!< 에딧텍스트 객체생성
        cAllButton = new AllButton(aSignUp);        //!< 버튼클래스 객체생성
        cAllCheckBox = new AllCheckBox(aSignUp);    //!< 체크박스 객체생성

    }
}
