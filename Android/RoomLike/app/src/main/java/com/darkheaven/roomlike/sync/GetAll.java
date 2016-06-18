package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.listener.LoginListener;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.GroceryItem;
import com.darkheaven.roomlike.object.Message;
import com.darkheaven.roomlike.object.Payment;
import com.darkheaven.roomlike.object.User;
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
 * Created by tinyiota on 6/17/16.
 */
public class GetAll extends AsyncTask<Void,Void,ArrayList<BaseObject>> {
    BaseListener listener;

    public GetAll(BaseListener listener){
        this.listener = listener;
    }

    @Override
    protected ArrayList<BaseObject> doInBackground(Void... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        L.e("IN GetAll");
        builder.setLength(0);
        try {
            URL url = new URL("http://10.0.2.2:8080/get_all/" + SP.getInt(SP.GROUP_ID_KEY));
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
        L.e(builder.toString());
        ArrayList<BaseObject> objects = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONArray groupsArray = jsonObject.getJSONArray("Objects");
            JSONArray usersArray = jsonObject.getJSONArray("Users");
            for(int i = 0; i < usersArray.length(); i++){
                JSONObject row = usersArray.getJSONObject(i);
                User user = new User();
                user.setUserID(row.getInt("UserID"));
                user.setUserName(row.getString("UserName"));
                if(MainActivity.os.group.getGroupID() > 0){
                    MainActivity.os.group.setGroupID(row.getInt("GroupID"));
                    MainActivity.os.group.setGroupName(row.getString("GroupName"));
                }
                MainActivity.os.addUserToGroup(user);
            }
            for(int i = 0; i < groupsArray.length(); i++){
                JSONObject row = groupsArray.getJSONObject(i);
                BaseObject object = new BaseObject();
                switch (row.getString("ObjectType")){
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
                if(!row.getString("DibsUser").equals("None")){
                    object.setDibsUser(MainActivity.os.getUserByID(row.getInt("DibsUser")));
                }
                if(!row.getString("CompletedUser").equals("None")) {
                    object.setCompletedUser(MainActivity.os.getUserByID(row.getInt("CompletedUser")));
                }
                if(!row.getString("MakerID").equals("None")) {
                    object.setMaker(MainActivity.os.getUserByID(row.getInt("MakerID")));
                }

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
        for(BaseObject object : objects){
            MainActivity.os.addObject(object);
        }
        ((LoginListener)listener).downloadComplete();
    }
}
