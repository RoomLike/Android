package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.utils.L;
import com.darkheaven.roomlike.utils.SP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tinyiota on 6/16/16.
 */
public class CreateGroup extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(params[0]);
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
            }
        }
        return builder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        SP.saveInt(SP.GROUP_ID_KEY, Integer.parseInt(s));
    }
}
