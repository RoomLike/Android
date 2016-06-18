package com.darkheaven.roomlike.sync;

import android.content.Context;
import android.os.AsyncTask;

import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.utils.L;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tinyiota on 6/16/16.
 */
public class CreateChore extends AsyncTask<Chore,Void,Boolean> {
    Context context;

    public CreateChore(Context context){
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(Chore... params) {
        boolean success = false;

        HttpURLConnection connection = null;
        try {
            connection = submitChore(params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
                success = true;
            }
        }

        connection = null;
        if(success) {
            try {
                connection = submitSchedule(params[0]);
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                if(connection != null){
                    connection.disconnect();
                    success = true;
                }
            }
        }
        return success;
    }

    @Override
    public void onPostExecute(Boolean success){

    }

    public HttpURLConnection submitChore(Chore chore) throws IOException {
        StringBuilder builder = new StringBuilder();
        URL url = new URL("http://10.0.2.2:8080/add_chore/"
                + chore.getGroupID() + "/"
                + chore.getMaker().getUserID() + "/"
                + chore.getText());
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        L.e(builder.toString());
        int objectID = Integer.parseInt(builder.toString());
        chore.setObjectID(objectID);
        return connection;
    }

    public HttpURLConnection submitSchedule(Chore chore) throws IOException {
        StringBuilder builder = new StringBuilder();
        StringBuilder daysOfWeek = new StringBuilder();
        for(int i = 0; i < chore.getSchedule().getDaysOfWeek().size(); i++){
            daysOfWeek.append(chore.getSchedule().getDaysOfWeek().get(i));
        }
        URL url = new URL("http://10.0.2.2:8080/add_schedule/"
                + chore.getObjectID() + "/"
                + chore.getSchedule().getFrequency().getFrequencyText() + "/"
                + chore.getSchedule().getNextDate() + "/"
                + chore.getSchedule().getLastDate() + "/"
                + daysOfWeek.toString() + "/"
                + chore.getSchedule().getDayOfMonth() + "/"
                + chore.getSchedule().getMonthOfYear() + "/"
                + chore.getSchedule().getYear() + "/"
                + chore.getSchedule().getHour() + "/"
                + chore.getSchedule().getMinute() + "/"
                + (chore.getSchedule().isAM() ? 1 : 0) + "/"
                + chore.getSchedule().getRepeatEvery() + "/"
                + (chore.getSchedule().isAnyDay() ? 1 : 0));
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        L.e(builder.toString());
        int scheduleID = Integer.parseInt(builder.toString());
        chore.setObjectID(scheduleID);
        return connection;
    }
}
