package com.darkheaven.roomlike.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.darkheaven.roomlike.activity.RLApplication;

/**
 * Created by tinyiota on 5/31/16.
 */
public class SP {
    public static final String PREFFS_NAME = "ROOM_LIKE_PREFFS";
    public static final String USER_NAME_KEY = "PREFFS_USER_NAME_KEY";
    public static final String USER_ID_KEY = "PREFFS_USER_ID_KEY";
    public static final String GROUP_ID_KEY = "PREFFS_GROUP_ID_KEY";

    public static SharedPreferences getSharedPreferences(){
        return RLApplication.getContext().getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
    }

    public static void saveString(String key, String value){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void saveInt(String key, int value){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static String getString(String key){
        return getSharedPreferences().getString(key, "");
    }

    public static int getInt(String key){
        return getSharedPreferences().getInt(key, -1);
    }
}
