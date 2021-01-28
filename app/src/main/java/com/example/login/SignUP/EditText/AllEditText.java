package com.example.login.SignUP.EditText;

import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.SignUP.EditText.Define.Defineedittext;

import java.util.regex.Pattern;

public class AllEditText {

    AppCompatActivity aAllEditText; //!< Activity

    EditText id;            //!< 에딧텍스트 아이디 변수
    EditText pw;            //!< 에딧텍스트 비밀번호 변수
    EditText pwConfirm;     //!< 에딧텍스트 2차비밀번호 변수
    EditText email;         //!< 에딧텍스트 이메일 변수
    EditText phonenumber;   //!< 에딧텍스트 전화번호 변수

    //!< 정규식 패턴
    String sIdPattern = "^[a-zA-Z]*$";  //!< 아이디 패턴 영어만 사용
    String sPwPattern = "^[a-zA-Z0-9]*$";   //!< 비밀번호 패턴 영어 숫자만 사용
//    String sPWCPattern = "^[a-zA-Z0-9]*$";  //!< 영어 숫자만
    String sPhPattern = "^(\\d{3}|\\d{4})[-]?(\\d{4})$";    //!< 전화번호 패턴 중간3~4자리 숫자 마지막4자리 숫자 사용
    String sEmailPattern = "^[a-zA-Z0-9]*$";    //!< 이메일 패턴 영어 숫자만 사용

    /**
     * 생성자
     * @param appCompatActivity
     */
    public AllEditText(AppCompatActivity appCompatActivity) {

        aAllEditText = appCompatActivity;   //!< Activity
        id = (EditText) aAllEditText.findViewById(R.id.id_edittext);    //!< 아이디 id값 연결
        pw = (EditText) aAllEditText.findViewById(R.id.pw_edittext);    //!< 비밀번호 id값 연결
        pwConfirm = (EditText) aAllEditText.findViewById(R.id.pw2_edittext);    //!< 2차비밀번호 id값 연결
        phonenumber = (EditText) aAllEditText.findViewById(R.id.phone_edittext);//!< 전화번호 id값 연결
        email = (EditText) aAllEditText.findViewById(R.id.email_edittext);  //!< 이메일 id값 연결
    }

    /**
     * 아이디 bollean메서드
     */
    public boolean idCheck() {
        //!<id 값
        boolean bIdCheck = false;   //!< 불변수 거짓상태
        if(id.getText().toString().length() != 0) { //!< 아이디 정보가 없지 않으면
            bIdCheck = Pattern.matches(sIdPattern, id.getText().toString());    //!< 아이디 패턴확인
        }

        if (bIdCheck) { //!< 아이디 정규식이 참이면
            System.out.println(id + "는 아이디 패턴 일치함");    //!< 디버그
            Defineedittext.ins().idedit = id.getText().toString();  //!< 아이디 변수에 아이디 정보 저장
            return true;    //!< 리턴 true
        } else {    //!< 아이디 정규식이 참이 아니면
            System.out.println("아이디 패턴 불일치"); //!< 디버그
            return false;   //!< 리턴 false
        }

    }

    /**
     * 1차 2차 비밀번호
     */
    public boolean pwCheck() {
        //!< 비밀번호 값
        boolean bPwCheck = false;   //!< 1차비밀번호 불변수 거짓상태
        boolean bPwCCheck = false;  //!< 2차비밀번호 불변수 거짓상태

        //!< 1차 2차 비밀번호값이 0이 아닐때
        if(pw.getText().toString().length() != 0 && pwConfirm.getText().toString().length() != 0){
            bPwCheck = Pattern.matches(sPwPattern, pw.getText().toString());    //!< 1차비밀번호 패턴확인
            bPwCCheck = Pattern.matches(sPwPattern, pwConfirm.getText().toString());    //!< 2차비밀번호 패턴확인
        }

        //!< 1차 2차 비밀번호 정규식
        if(bPwCheck && bPwCCheck) { //!< 1차 , 2 차 비밀번호가 정규식이 참이면
            System.out.println("정규식 일치");   //!< 디버그
            //!< 1차 2차 비밀번호 일치 여부 확인
            if(pw.getText().toString().equals(pwConfirm.getText().toString())) {
                System.out.println("1 차 2 차 비밀번호 일치");  //!< 디버그
                Defineedittext.ins().pwedit = pw.getText().toString();  //!< 비밀번호 변수에 비밀번호 정보 저장
                return true;    //!< 리턴 true
            }else { //!< 1차 2차 비밀번호가 일치하지않으면
                System.out.println("1 차 2 차 비밀번호 불일치"); //!< 디버그
                return false;   //!< 리턴 false
            }
        }

        return false;   //!< 리턴 false

    }

    /**
     * 이메일
     */
    public boolean emailCheck() {

        boolean bemailCheck = false;    //!< 이메일 불변수 거짓상태

        if(email.getText().toString().length() != 0 ){  //!< 이메일값이 0이 아닐때
            bemailCheck = Pattern.matches(sEmailPattern, email.getText().toString());   //!< 이메일 패턴확인
        }
        if (bemailCheck) {  //!< 이메일 정규식이 참이면
            System.out.println(email + "는 이메일 패턴 일치함"); //!< 디버그
            Defineedittext.ins().emailedit = email.getText().toString();    //!< 이메일변수에 이메일정보 저장
            return true;    //!< 리턴 true
        } else {    //!< 이메일 정규식이 참이 아니면
            System.out.println("이메일 패턴 불일치");   //!< 디버그
            return false;   //!< 리턴 false
        }

    }

    /**
     * 전화번호
     */
    public boolean phCheck() {

        boolean bphCheck = false;   //!< 전화번호 불변수 거짓상태

        if(phonenumber.getText().toString().length() != 0){ //!< 전화번호값이 0이 아닐때
            bphCheck = Pattern.matches(sPhPattern, phonenumber.getText().toString()); //!< 전화번호 패턴확인
        }
        if (bphCheck) { //!< 전화번호 정규식이 참이면
            System.out.println(phonenumber + "는 전화번호 일치함"); //!< 디버그
            Defineedittext.ins().phoneedit = phonenumber.getText().toString();  //!< 전화번호 변수에 전화번호 정보 저장
            return true;    //!< 리턴 true
        } else {    //!< 전화번호 정규식이 참이 아니면
            System.out.println("전화번호 패턴 불일치");  //!< 디버그
            return false;   //!리턴 false
        }
    }
}
