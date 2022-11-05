package com.aaronj.androidnative;

public class AndroidNative {
    static AndroidNative instance;

    public static AndroidNative getInstance(){
        if(instance == null)
            instance = new AndroidNative();
        return instance;
    }
    
}
