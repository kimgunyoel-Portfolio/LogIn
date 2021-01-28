package com.example.login.SignUP.Spinner.Define;

import com.example.login.SignUP.CheckBox.Define.DefineCheck;

public class Definespinner {

    public String phonespinner = "";    //!< 싱글톤 전화번호 스피너 변수
    public String emailspinner = "";    //!< 싱글톤 이메일 스피너 변수

    /**
     * @author
     * @param	instance Singleton Pattern
     */
    private static Definespinner instance;
    public static Definespinner ins() {
        if(instance == null){
            instance = new Definespinner();
        }
        return instance;

    }
}
