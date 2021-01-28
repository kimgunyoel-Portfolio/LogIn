package com.example.login.LogIn.FaceBook;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.FaceBook.Define.FDefine;
import com.example.login.LogOut.Activity.LogOutActivity;
import com.example.login.R;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class Facebook {

    AppCompatActivity aFacebook;            //!< Activity
    private Context mContext;               //!< 컨텍스트
    private LoginCallback mLoginCallback;   //!< 로그인콜백 클래스
    private Button btn_custom_login;        //!< 페이스북 로그인버튼

    /**
     * 생성자
     * @param appCompatActivity
     */
    public Facebook(AppCompatActivity appCompatActivity){

        aFacebook = appCompatActivity;                  //!< Activity
        mContext = aFacebook.getApplicationContext();   //!< 컨텍스트 연결

        mLoginCallback = new LoginCallback(aFacebook);  //!< 로그인콜백 객체생성
        FDefine.ins().mCallbackManager = CallbackManager.Factory.create();  //!< 로그인응답 콜백관리자

        btn_custom_login = (Button) aFacebook.findViewById(R.id.btn_facebook_custom_login); //!< 페이스북버튼 id값연결
        btn_custom_login.setOnClickListener(new View.OnClickListener() {    //!< 버튼클릭리스너
            @Override
            public void onClick(View view) {
                FDefine.ins().mLoginManager = LoginManager.getInstance();   //!< 싱글톤 로그인매니저 변수에 정보받기
                FDefine.ins().mLoginManager.logInWithReadPermissions(aFacebook, //!< logInWithPermissionName 메서드에서 UI를 열고, 필요에 따라 추가 권한을 요청하는 메시지를 사용자에게 표시
                        Arrays.asList("public_profile", "email"));
                FDefine.ins().mLoginManager.registerCallback(FDefine.ins().mCallbackManager, mLoginCallback);   //!< 주소반환
                System.out.println("로그인 성공 :" + FDefine.ins().mLoginManager.toString() );   //!<디버그

        }
        });

    }

    /**
     *안드로이드에서는 onActivityResult() 메소드를 통해 호출된 Activity에서 저장한 결과를 돌려줍니다.
     * 이 때 requestCode는 처음 startActivityForResult()의 두번째 인수 값이며,
     * resultCode는 호출된 Activity에서 설정한 성공(RESULT_OK)/실패(RESULT_CANCEL) 값입니다.
     * 이를 통해 어떤 호출 (REQUST_TEST) 이었는지와 결과가 어떠한지 (RESULT_OK)를 알 수 있으므로 그에 맞는 동작을 진행할 수 있습니다.
     * 마지막으로 세번째 인수 Intent는 호출된 Activity에서 저장한 결과입니다.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void resultFaceBook(int requestCode, int resultCode, @Nullable Intent data) {
        FDefine.ins().mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
