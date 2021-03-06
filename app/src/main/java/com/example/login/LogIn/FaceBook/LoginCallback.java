package com.example.login.LogIn.FaceBook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogOut.Activity.LogOutActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

public class LoginCallback implements FacebookCallback<LoginResult> {

    AppCompatActivity aLoginCallback;   //!< Activity

    /**
     * 생성자
     * @param appCompatActivity
     */
    public LoginCallback(AppCompatActivity appCompatActivity) {
        aLoginCallback = appCompatActivity; //!< Activity
    }


    // 로그인 성공 시 호출 됩니다. Access Token 발급 성공.
    @Override
    public void onSuccess(LoginResult loginResult) {
        System.out.println("로그인 성공1");  //!< 디버그
        requestMe(loginResult.getAccessToken());

        System.out.println("로그인 성공2");  //!< 디버그
        //!< 페이스북 로그인성공 인텐트
        Intent intent = new Intent(aLoginCallback, LogOutActivity.class);   //!< 로그인Activity -> 로그아웃Activity
        aLoginCallback.startActivity(intent);   //!< start
        aLoginCallback.finish();    //!< finish

    }

    // 로그인 창을 닫을 경우, 호출됩니다.
    @Override
    public void onCancel() {
        System.out.println("로그인 창 닫힘");
        Log.e("Callback :: ", "onCancel");
    }

    // 로그인 실패 시에 호출됩니다.
    @Override
    public void onError(FacebookException error) {
        System.out.println("로그인 실패");
        Log.e("Callback :: ", "onError : " + error.getMessage());
    }

    // 사용자 정보 요청
    public void requestMe(AccessToken token) {
        GraphRequest graphRequest = GraphRequest.newMeRequest(token,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        System.out.println("결과값 : " + object.toString());
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }
}
