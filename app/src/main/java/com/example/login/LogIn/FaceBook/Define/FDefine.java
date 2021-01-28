package com.example.login.LogIn.FaceBook.Define;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.LogIn.FaceBook.LoginCallback;
import com.example.login.LogIn.Kakao.Define.KDefine;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

public class FDefine {

    public CallbackManager mCallbackManager;
    public LoginManager mLoginManager;


    /**
     * @author
     * @param	instance Singleton Pattern
     */
    private static FDefine instance;
    public static FDefine ins() {
        if(instance == null){
            instance = new FDefine();
        }
        return instance;

    }
}
