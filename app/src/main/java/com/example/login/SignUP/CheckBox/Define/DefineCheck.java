package com.example.login.SignUP.CheckBox.Define;

import com.example.login.SignUP.EditText.Define.Defineedittext;

public class DefineCheck {

    public boolean bCheck = false;  //!< 이용약관동의 불변수 거짓
    public boolean bCheckk = false; //!< 개인정보보호 이용동의 불변수 거짓

    /**
     * @author
     * @param	instance Singleton Pattern
     */
    private static DefineCheck instance;
    public static DefineCheck ins() {
        if(instance == null){
            instance = new DefineCheck();
        }
        return instance;

    }

}
