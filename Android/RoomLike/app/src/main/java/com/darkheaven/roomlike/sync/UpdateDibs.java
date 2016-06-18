package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;
import android.renderscript.BaseObj;

import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.utils.L;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tinyiota on 6/17/16.
 */
public class UpdateDibs extends AsyncTask<BaseObject,Void,Boolean> {
    @Override
    protected Boolean doInBackground(BaseObject... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        boolean success = false;
        try {
            URL url = new URL("http://10.0.2.2:8080/call_dibs/"
                    + params[0].getObjectID() + "/"
                    + params[0].getDibsUser().getUserID());
            connection = (HttpURLConnection)url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            L.e(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
                success = true;
            }
        }
        return success;
    }
}