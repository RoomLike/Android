package com.darkheaven.roomlike.sync;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.listener.MessageListener;
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
public class SendMessage extends AsyncTask<String,Void,Boolean> {
    Context context;
    BaseListener listener;

    public SendMessage(Context context){
        this.context = context;
    }

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
        return success;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            Toast.makeText(context, "Message sent.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Message failed.", Toast.LENGTH_SHORT).show();
        }
        updateMessages();
    }

    public void setListener(BaseListener listener){
        this.listener = listener;
    }

    public void updateMessages(){
        GetMessages messageTask = new GetMessages();
        messageTask.setListener(listener);
        messageTask.execute("http://10.0.2.2:8080/get_messages/" + SP.getInt(SP.GROUP_ID_KEY));
    }
}
