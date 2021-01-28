package com.example.login.SignUP.Button;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.Activity.MainActivity;
import com.example.login.R;
import com.example.login.SignUP.CheckBox.Define.DefineCheck;
import com.example.login.SignUP.DataBase.Request3rdParty;
import com.example.login.SignUP.EditText.AllEditText;
import com.example.login.SignUP.EditText.Define.Defineedittext;
import com.example.login.SignUP.Spinner.Define.Definespinner;

public class AllButton {

    AppCompatActivity aAllButton;   //!< Activity
    Button Signupbutton;            //!< 회원가입 버튼
    Button Backpressbutton;         //!< 회원가입 뒤로가기 버튼
    CheckBox checkBox , checkBoxx;  //!< 체크박스

    String emailspinner;    //!< 이메일 스피너
    String phonespinner;    //!< 전화번호 스피너

    AllEditText cAllEditText;   //!< 에딧텍스트 클래스

    private boolean bID = false;    //!< boolean 아이디변수 거짓
    private boolean bPW = false;    //!< boolean 비밀번호변수 거짓
    private boolean bEmail = false; //!< boolean 이메일변수 거짓
    private boolean bPhone = false; //!< boolean 전화번호변수 거짓
    private boolean bCheck1 = false;//!< boolean 이용약관동의체크박스변수 거짓
    private boolean bCheck2 = false;//!< boolean 개인정보보호약관동의변수 거짓


    /**
     * 생성자
     * @param appCompatActivity
     */
    public AllButton(AppCompatActivity appCompatActivity){

        aAllButton = appCompatActivity; //!< Activity
        cAllEditText = new AllEditText(aAllButton); //!< 에딧텍스트 클래스 객체 생성

        //!< 체크박스 id값 연결
        checkBox =(CheckBox)aAllButton.findViewById(R.id.checkbox_1);   //!< 이용약관체크박스 id값 연결
        checkBoxx = (CheckBox)aAllButton.findViewById(R.id.checkbox_2); //!< 개인정보체크박스 id값 연결

        setAllButton();
    }

    public void setAllButton(){
        Backpressbutton = (Button)aAllButton.findViewById(R.id.backpress_bt);   //!< 회원가입 뒤로가기버튼 id값 연결
        Backpressbutton.setOnClickListener(new View.OnClickListener() { //!< 버튼클릭 리스너
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aAllButton , MainActivity.class);    //!< 인텐트 SignUpActivity -> MainActivity
                aAllButton.startActivity(intent);   //!< start
                aAllButton.finish();    //!< finish
            }
        });

        Signupbutton = (Button)aAllButton.findViewById(R.id.signup_button); //!< 회원가입 id값 연결
        Signupbutton.setOnClickListener(new View.OnClickListener() {    //!< 버튼 클릭리스너
            @Override
            public void onClick(View view) {
                System.out.println("회원가입버튼 눌림");            //!< 디버그
                phonespinner = Definespinner.ins().phonespinner;   //!< 전화번호스피너 = 디파인전화번호스피너정보
                System.out.println("전화번호 스피너 정보라라 : " + phonespinner ); //!<디버그
                emailspinner = Definespinner.ins().emailspinner;   //!< 이메일스피너변수 = 디파인이메일스피너정보
                System.out.println("이메일 스피너 정보라라라 : " + emailspinner ); //!< 디버그

                if (cAllEditText.idCheck()) {  //!< 에딧텍스트클래스에 아이디메서드
                    bID = true;     //!< 아이디 정규식이 참이면 true
                    //!< 비밀번호
                    if (cAllEditText.pwCheck()) {  //!< 에딧텍스트클래스에 비밀번호메서드
                        bPW = true;   //!< 비밀번호 정규식이 참이면 true
                        //!< 이메일
                        if (cAllEditText.emailCheck()) {    //!<에딧텍스트클래스에 이메일 메서드
                            bEmail = true;  //!< 이메일 정규식이 참이면 true
                            //!< 전화번호
                            if (cAllEditText.phCheck()) {   //!< 에딧텍스트클래스에 전화번호 메서드
                                bPhone = true;  //!< 전화번호 정규식이 참이면 true
                                //!< 이용약관동의 체크박스
                                if (DefineCheck.ins().bCheck) { //!< 체크박스클래스에 이용약관체크박스 메서드
                                    bCheck1 = true;     //!< 이용약관체크박스가 눌렷으면 true
                                    //!< 개인정보 동의 체크박스
                                    if (DefineCheck.ins().bCheckk) {    //!< 체크박스 클래스에 개인정보보호 메서드
                                        bCheck2 = true; //!< 개인정보보호 체크박스가 눌렷으면 true
                                    } else {    //!< 개인정보보호 체크박스가 안눌렷으면 토스트메시지 출력
                                        Toast.makeText(aAllButton, "개인정보 취급방침 동의 체크하세요", Toast.LENGTH_SHORT).show();
                                    }
                                } else {    //!< 이용약관동의 체크박스가 안눌렷으면 토스트메시지 출력
                                    Toast.makeText(aAllButton, "이용약관동의 체크 하세요", Toast.LENGTH_SHORT).show();
                                }
                            } else {    //!< 전화번호 정규식에 어긋나면 토스트메시지 출력
                                Toast.makeText(aAllButton, "전화번호 정보를 확인하세요", Toast.LENGTH_SHORT).show();
                            }
                        } else {    //!< 이메일 정규식에 어긋나면 토스트메시지 출력
                            Toast.makeText(aAllButton, "이메일정보를 확인하세요", Toast.LENGTH_SHORT).show();
                        }
                    } else {    //!< 비밀번호 정규식에 어긋나면 토스트메시지 출력
                        Toast.makeText(aAllButton, "비밀번호정보를 확인하세요", Toast.LENGTH_SHORT).show();
                    }
                } else {    //!< 아이디 정규식에 어긋나면 토스트메시지 출력
                    Toast.makeText(aAllButton, "아이디정보를 확인하세요", Toast.LENGTH_SHORT).show();
                }

                //!< DB 정보 전달
                if(bID && bPW && bEmail && bPhone && bCheck1 && bCheck2) {
                    //!< boolean 아이디, 비밀번호, 이메일, 전화번호 , 체크박스가 참이면
                    System.out.println("저장시작"); //!< 디버그

                    String sid = Defineedittext.ins().idedit;   //!< 스트링변수에 아이디 정보 저장
                    String spw = Defineedittext.ins().pwedit;   //!< 스트링변수에 비밀번호 정보 저장
                    String semail = Defineedittext.ins().emailedit +"@"+ emailspinner ; //!< 스트링변수에 이메일정보 저장
                    System.out.println("semail : " + semail);   //!< 디버그
                    String sphone = phonespinner + "-" +Defineedittext.ins().phoneedit ; //!< 스트링변수에 전화번호정보 저장
                    System.out.println("sphone : " + sphone);   //!< 디버그

                    Request3rdParty loginRequest = new Request3rdParty(aAllButton);   //!< Request3rdParty객체생성
                    loginRequest.Setting("signIn", "login.php", sid, spw , semail , sphone);  //!< 리퀘스트세팅 php,아이디,비번,이메일,전화번호

                    loginRequest.start();   //!< 리퀘스트 시작
                    //!< try
                    try {
                        loginRequest.join();

                    }catch (InterruptedException e){
                        e.printStackTrace();

                    }
                    System.out.println(loginRequest.getResult());




                }
            }
        });

    }


}
