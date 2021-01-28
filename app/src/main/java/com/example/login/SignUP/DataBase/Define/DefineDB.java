package com.example.login.SignUP.DataBase.Define;

public class DefineDB {
    public static final String 	ADDR_SMART	= "http://192.168.0.91/";
    private boolean	bRequestError;

    // instance =======================
    private static DefineDB instance;
    public static DefineDB ins()
    {
        if(instance == null)
        {
            instance = new DefineDB();
        }
        return instance;
    }
    public static void insDestroy()
    {
        instance = null;
    }
    // ================================

    public void setRequestError(boolean bFlag)
    {
        bRequestError = bFlag;
    }
}
