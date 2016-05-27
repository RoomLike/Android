package com.darkheaven.roomlike.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by tinyiota on 5/27/16.
 */
public class RLApplication extends Application {
    public static RLApplication instance;

    public RLApplication(){
        instance = this;
    }

    public static Context getContext(){
        if(instance == null){
            instance = new RLApplication();
        }
        return instance;
    }
}
