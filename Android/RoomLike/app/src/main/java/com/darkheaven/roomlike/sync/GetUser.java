package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.listener.LoginListener;
import com.darkheaven.roomlike.object.Group;
import com.darkheaven.roomlike.object.User;
import com.darkheaven.roomlike.utils.L;
import com.darkheaven.roomlike.utils.SP;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tinyiota on 6/16/16.
 */
public class GetUser extends AsyncTask<String,Void,Boolean> {
    BaseListener listener;

    @Override
    protected Boolean doInBackground(String... params) {
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
        L.e("GetObjects");
        boolean success = false;
        if(!builder.toString().equals("DNE")){
            try {
                JSONObject object = new JSONObject(builder.toString());
                SP.saveInt(SP.USER_ID_KEY, object.getInt("UserID"));
                SP.saveString(SP.USER_NAME_KEY, object.getString("UserName"));
                SP.saveInt(SP.GROUP_ID_KEY, object.getInt("GroupID"));
                success = true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            loginSuccess();
        }
    }

    public void setListener(BaseListener listener){
        this.listener = listener;
    }

    public void loginSuccess(){
        ((LoginListener)listener).loginSuccess();
    }
}
