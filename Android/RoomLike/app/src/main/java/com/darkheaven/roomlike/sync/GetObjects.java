package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.GroceryItem;
import com.darkheaven.roomlike.object.HelpItem;
import com.darkheaven.roomlike.object.Payment;
import com.darkheaven.roomlike.utils.L;
import com.darkheaven.roomlike.utils.SP;

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
 * Created by tinyiota on 6/14/16.
 */
public class GetObjects extends AsyncTask<String,Void,ArrayList<BaseObject>> {
    BaseListener listener;

    public GetObjects(BaseListener listener){
        this.listener = listener;
    }

    @Override
    protected ArrayList<BaseObject> doInBackground(String... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL("https://10.0.2.2:8080/objects/" + params[0] + "/" + SP.getInt(SP.GROUP_ID_KEY));
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

        ArrayList<BaseObject> objects = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONArray groupsArray = jsonObject.getJSONArray("Help");
            for(int i = 0; i < groupsArray.length(); i++){
                JSONObject row = groupsArray.getJSONObject(i);
                BaseObject object = new BaseObject();
                switch (params[0]){
                    case "Chore":
                        object = new Chore();
                        break;
                    case "GroceryItem":
                        object = new GroceryItem();
                        break;
                    case "Payment":
                        object = new Payment();
                        ((Payment)object).setAmount(row.getDouble("Amount"));
                        break;
                }
                object.setDibsUser(MainActivity.os.getUserByID(row.getInt("DibsUser")));
                object.setCompletedUser(MainActivity.os.getUserByID(row.getInt("CompletedUser")));
                object.setMaker(MainActivity.os.getUserByID(row.getInt("MakerID")));
                object.setText(row.getString("Text"));
                object.setGroup(MainActivity.os.group);
                object.setObjectID(row.getInt("ObjectID"));
                objects.add(object);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return objects;
    }

    @Override
    protected void onPostExecute(ArrayList<BaseObject> objects) {
        // parse and insert into local db
        for(int i = 0; i < objects.size(); i++){
            MainActivity.os.addObject(objects.get(i));
        }
        listener.initViews();
    }
}
