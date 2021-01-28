package com.example.login.LogIn.Naver.Define;

import com.nhn.android.naverlogin.OAuthLogin;

public class NDefine {

    public OAuthLogin mOAuthLoginModule;    //!< 싱글턴 패턴을 이용하여 OAuthLogin 객체를 생성하여 리턴하거나 기존에 생성했던 걸 리턴한다

    /**
     * @author
     * @param	instance Singleton Pattern
     */
    private static NDefine instance;
    public static NDefine ins() {
        if(instance == null){
            instance = new NDefine();
        }
        return instance;

    }


}
