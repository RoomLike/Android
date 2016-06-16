package com.darkheaven.roomlike.sync;

import android.content.Context;
import android.graphics.Paint;
import android.os.AsyncTask;

import com.darkheaven.roomlike.adapter.GroupSearchAdapter;
import com.darkheaven.roomlike.dialog.JoinGroupDialog;
import com.darkheaven.roomlike.object.Group;
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
 * Created by tinyiota on 6/16/16.
 */
public class GetGroupList extends AsyncTask<String,Void,ArrayList<Group> > {
    JoinGroupDialog dialog;
    Context context;

    public GetGroupList(Context context){
        this.context = context;
    }

    public void setDialog(JoinGroupDialog dialog){
        this.dialog = dialog;
    }

    @Override
    protected ArrayList<Group> doInBackground(String... params) {
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
        L.e("GetGroups: " + builder.toString());
        ArrayList<Group> groups = null;
        try {
            JSONObject jsonObject = new JSONObject(builder.toString());
            groups = new ArrayList<>();
            JSONArray groupsArray = jsonObject.getJSONArray("Groups");
            for(int i = 0; i < groupsArray.length(); i++){
                JSONObject row = groupsArray.getJSONObject(i);
                Group g = new Group();
                g.setGroupID(row.getInt("GroupID"));
                g.setGroupName(row.getString("GroupName"));
                groups.add(g);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return groups;
    }

    @Override
    protected void onPostExecute(ArrayList<Group> groups) {
        dialog.adapter = new GroupSearchAdapter(context, groups);
        dialog.groupSearchList.setAdapter(dialog.adapter);
    }
}
