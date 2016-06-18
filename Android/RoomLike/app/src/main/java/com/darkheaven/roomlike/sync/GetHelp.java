package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.object.Group;
import com.darkheaven.roomlike.object.HelpItem;
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

/**
 * Created by tinyiota on 6/17/16.
 */
public class GetHelp extends AsyncTask<Void,Void,ArrayList<HelpItem>> {
    @Override
    protected ArrayList<HelpItem> doInBackground(Void... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2:8080/get_help");
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

        ArrayList<HelpItem> items = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONArray groupsArray = jsonObject.getJSONArray("Help");
            for(int i = 0; i < groupsArray.length(); i++){
                JSONObject row = groupsArray.getJSONObject(i);
                HelpItem item = new HelpItem();
                item.setHeader(row.getString("Header"));
                item.setDetail(row.getString("Detail"));
                items.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    protected void onPostExecute(ArrayList<HelpItem> helpItems) {
        for(HelpItem item : helpItems){
            MainActivity.os.addHelpItem(item);
        }
    }
}
