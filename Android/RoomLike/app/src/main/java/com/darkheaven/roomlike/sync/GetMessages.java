package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.listener.MessageListener;
import com.darkheaven.roomlike.object.Message;
import com.darkheaven.roomlike.utils.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created by tinyiota on 6/16/16.
 */
public class GetMessages extends AsyncTask<String,Void,Boolean> {
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
        L.e("GetMessages");
        boolean success = false;
        try {
            JSONObject object = new JSONObject(builder.toString());
            JSONArray list = object.getJSONArray("Messages");
            for(int i = 0; i < list.length(); i++){
                JSONObject row = list.getJSONObject(i);
                Message message = new Message();
                message.setText(row.getString("MessageText"));
                message.setMaker(MainActivity.os.getUserByID(row.getInt("MakerID")));
                message.setMessageTime(row.getString("TimeCreated"));
                message.setObjectID(row.getInt("MessageID"));
                MainActivity.os.addObject(message);
            }
            success = true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            messageGetSuccessful();
        }
    }

    public void setListener(BaseListener listener){
        this.listener = listener;
    }

    public void messageGetSuccessful(){
        ((MessageListener)listener).messageGetSuccess();
    }
}
