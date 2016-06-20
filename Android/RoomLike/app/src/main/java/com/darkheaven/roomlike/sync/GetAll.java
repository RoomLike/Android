package com.darkheaven.roomlike.sync;

import android.os.AsyncTask;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.frequency.Frequency;
import com.darkheaven.roomlike.frequency.FrequencyStore;
import com.darkheaven.roomlike.listener.BaseListener;
import com.darkheaven.roomlike.listener.LoginListener;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.Day;
import com.darkheaven.roomlike.object.GroceryItem;
import com.darkheaven.roomlike.object.Message;
import com.darkheaven.roomlike.object.Payment;
import com.darkheaven.roomlike.object.Schedule;
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
public class GetAll extends AsyncTask<Void,Void,Void> {
    BaseListener listener;

    public GetAll(BaseListener listener){
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... params) {
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
        try {
            JSONObject jsonObject = new JSONObject(builder.toString());
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
            JSONArray objectsArray = jsonObject.getJSONArray("Objects");
            for(int i = 0; i < objectsArray.length(); i++){
                JSONObject row = objectsArray.getJSONObject(i);
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
                    case "Message":
                        object = new Message();
                        L.e("MessageType Found");
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
                MainActivity.os.addObject(object);
            }
            JSONArray scheduleArray = jsonObject.getJSONArray("Schedules");
            for(int i = 0; i < scheduleArray.length(); i++){
                JSONObject row = scheduleArray.getJSONObject(i);
                Schedule schedule = new Schedule();
                schedule.setObjectID(row.getInt("ObjectID"));
                schedule.setFrequency(FrequencyStore.getFrequencyByText(row.getString("Frequency")));
                if(!row.getString("Year").equals("None")) {
                    schedule.setYear(row.getInt("Year"));
                }
                if(!row.getString("RepeatEvery").equals("None")) {
                    schedule.setRepeatEvery(row.getInt("RepeatEvery"));
                }
                if(!row.getString("MonthOfYear").equals("None")) {
                    schedule.setMonthOfYear(row.getInt("MonthOfYear"));
                }
                if(!row.getString("AnyDay").equals("None")) {
                    schedule.setAnyDay(row.getInt("AnyDay") == 1);
                }
                if(!row.getString("DayOfMonth").equals("None")) {
                    schedule.setDayOfMonth(row.getInt("DayOfMonth"));
                }
                if(!row.getString("Hour").equals("None")) {
                    schedule.setHour(row.getInt("Hour"));
                }
                if(!row.getString("Minute").equals("None")) {
                    schedule.setMinute(row.getInt("Minute"));
                }
                if(!row.getString("isAM").equals("None")) {
                    schedule.setIsAM(row.getInt("isAM") == 1);
                }
                if(!row.getString("NextDate").equals("None")) {
                    schedule.setNextDate(row.getString("NextDate"));
                }
                if(!row.getString("LastDate").equals("None")) {
                    schedule.setNextDate(row.getString("LastDate"));
                }
                if(!row.getString("DaysOfWeek").equals("None")) {
                    ArrayList<Day> daysOfWeek = new ArrayList<>();
                    String dOW = row.getString("DaysOfWeek");
                    for (int j = 0; j < dOW.length(); j++) {
                        switch (dOW.charAt(j)) {
                            case 'M':
                                daysOfWeek.add(Day.Monday);
                                break;
                            case 'T':
                                if (dOW.charAt(j + 1) == 'h') {
                                    j++;
                                    daysOfWeek.add(Day.Thursday);
                                } else {
                                    daysOfWeek.add(Day.Tuesday);
                                }
                                break;
                            case 'W':
                                daysOfWeek.add(Day.Wednesday);
                                break;
                            case 'F':
                                daysOfWeek.add(Day.Friday);
                                break;
                            case 'S':
                                if (dOW.charAt(j + 1) == 'a') {
                                    daysOfWeek.add(Day.Saturday);
                                } else if (dOW.charAt(j + 1) == 'u') {
                                    daysOfWeek.add(Day.Sunday);
                                }
                                j++;
                                break;
                        }
                    }
                    schedule.setDaysOfWeek(daysOfWeek);
                }
                MainActivity.os.addSchedule(schedule);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        ((LoginListener)listener).downloadComplete();
    }
}
