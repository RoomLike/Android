package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;
import android.widget.Toast;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.object.Group;
import com.darkheaven.roomlike.object.User;
import com.darkheaven.roomlike.utils.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tinyiota on 6/16/16.
 */
public class GetGroupsUsers extends AsyncTask<String,Void,Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        boolean success = false;
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
                success = true;
            }
        }
        L.e("GetGroups: " + builder.toString());
        try {
            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONArray groupsArray = jsonObject.getJSONArray("Groups");
            for(int i = 0; i < groupsArray.length(); i++){
                JSONObject row = groupsArray.getJSONObject(i);
                User user = new User();
                user.setUserID(row.getInt("UserID"));
                user.setUserName(row.getString("UserName"));
                MainActivity.os.addUserToGroup(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            L.e("successfully inserted users.");
        }else{
            L.e("users not inserted correctly.");
        }
    }
}
