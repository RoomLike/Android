package com.darkheaven.roomlike.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.activity.RLApplication;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.GroceryItem;
import com.darkheaven.roomlike.object.HelpItem;
import com.darkheaven.roomlike.object.Message;
import com.darkheaven.roomlike.object.Payment;
import com.darkheaven.roomlike.object.User;
import com.darkheaven.roomlike.utils.SP;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tinyiota on 5/31/16.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    public DBOpenHelper(Context context) {
        super(context, context.getResources().getString(R.string.db_name), null, DATABASE_VERSION);
        onCreate(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        init();
    }

    public void init(){
        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS Users ");
        sqlA.append("(");
        sqlA.append("   UserID INTEGER ");
        sqlA.append(" , UserName TEXT ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS Groups ");
        sqlA.append("(");
        sqlA.append("   GroupID INTEGER ");
        sqlA.append(" , GroupName TEXT ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS UsersGroups ");
        sqlA.append("(");
        sqlA.append("   GroupID INTEGER ");
        sqlA.append(" , UserID INTEGER ");
        sqlA.append(" , FOREIGN KEY (GroupID) REFERENCES Groups(GroupID) ");
        sqlA.append(" , FOREIGN KEY (UserID) REFERENCES Users(UserID) ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS Objects ");
        sqlA.append("(");
        sqlA.append("   GroupID INTEGER ");
        sqlA.append(" , MakerID INTEGER ");
        sqlA.append(" , ObjectType TEXT ");
        sqlA.append(" , Text TEXT ");
        sqlA.append(" , ObjectID INTEGER ");
        sqlA.append(" , DibsUser INTEGER ");
        sqlA.append(" , CompletedUser INTEGER ");
        sqlA.append(" , TimeCreated DATE ");
        sqlA.append(" , Amount DOUBLE ");
        sqlA.append(" , FOREIGN KEY (GroupID) REFERENCES Groups(GroupID) ");
        sqlA.append(" , FOREIGN KEY (MakerID) REFERENCES Users(UserID) ");
        sqlA.append(" , FOREIGN KEY (DibsUser) REFERENCES Users(UserID) ");
        sqlA.append(" , FOREIGN KEY (CompletedUser) REFERENCES Users(UserID) ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS Schedules ");
        sqlA.append("(");
        sqlA.append("   Frequency INTEGER ");
        sqlA.append(" , ObjectID INTEGER ");
        sqlA.append(" , NextDate DATE ");
        sqlA.append(" , LastDate DATE ");
        sqlA.append(" , DaysOfWeek TEXT ");
        sqlA.append(" , DayOfMonth INTEGER ");
        sqlA.append(" , MonthOfYear INTEGER ");
        sqlA.append(" , Year INTEGER ");
        sqlA.append(" , Hour INTEGER ");
        sqlA.append(" , Minute INTEGER ");
        sqlA.append(" , isAM INTEGER ");
        sqlA.append(" , RepeatEvery INTEGER ");
        sqlA.append(" , AnyDay INTEGER ");
        sqlA.append(" , FOREIGN KEY (ObjectID) REFERENCES `Objects`(ObjectID) ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS ObjectsSchedules ");
        sqlA.append("(");
        sqlA.append("   ObjectID INTEGER ");
        sqlA.append(" , ScheduleID INTEGER ");
        sqlA.append(" , FOREIGN KEY (ObjectID) REFERENCES `Objects`(ObjectID) ");
        sqlA.append(" , FOREIGN KEY (ScheduleID) REFERENCES Schedules (ScheduleID) ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("CREATE TABLE IF NOT EXISTS Help ");
        sqlA.append("(");
        sqlA.append("   HelpID ");
        sqlA.append(" , HelpHeader ");
        sqlA.append(" , HelpDetail ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);
    }

    public void deleteTableData(){
        db.execSQL("DELETE FROM Users;");
        db.execSQL("DELETE FROM Groups;");
        db.execSQL("DELETE FROM UsersGroups;");
        db.execSQL("DELETE FROM Objects;");
        db.execSQL("DELETE FROM Schedules;");
        db.execSQL("DELETE FROM Help;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertObject(BaseObject object){
        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);
        sqlA.append("INSERT INTO Objects ");
        sqlA.append("(");
        sqlA.append("     GroupID, MakerID, ObjectType, Text, ObjectID, DibsUser, CompletedUser, TimeCreated, Amount ");
        sqlA.append(")");
        sqlA.append("VALUES");
        sqlA.append("(");
        sqlA.append(Integer.toString(SP.getInt(SP.GROUP_ID_KEY)));
        sqlA.append(",").append(Integer.toString(object.getMaker().getUserID()));
        String objectType = "";
        if(object instanceof Chore){
            objectType = "Chore";
        }else if(object instanceof GroceryItem){
            objectType = "GroceryItem";
        }else if(object instanceof Payment){
            objectType = "Payment";
        }else if(object instanceof Message){
            objectType = "Message";
        }
        sqlA.append(",'").append(objectType).append("'");
        sqlA.append(",'").append(object.getText()).append("'");
        sqlA.append(",").append(object.getObjectID());
        if(object.getDibsUser() != null) {
            sqlA.append(",").append(object.getDibsUser().getUserID());
        }else{
            sqlA.append(",0");
        }
        if(object.getCompletedUser() != null) {
            sqlA.append(",").append(object.getCompletedUser().getUserID());
        }else{
            sqlA.append(",0");
        }
        sqlA.append(",'").append(object.getTimeCreated()).append("'");
        if(object instanceof Payment){
            sqlA.append(",").append(((Payment) object).getAmount());
        }else{
            sqlA.append(",0");
        }
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);
    }

    public void insertUser(User user){
        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);
        sqlA.append("INSERT INTO Users ");
        sqlA.append("(");
        sqlA.append("UserID, UserName ");
        sqlA.append(")");
        sqlA.append("VALUES");
        sqlA.append("(");
        sqlA.append(user.getUserID());
        sqlA.append(",'").append(user.getUserName()).append("'");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);

        sqlA.append("INSERT INTO UsersGroups ");
        sqlA.append("(");
        sqlA.append("UserID");
        sqlA.append(",").append(user.getGroup().getGroupID());
        sqlA.append(")");
    }

    public void initObjects(){
        MainActivity.os.group.setGroupID(SP.getInt(SP.GROUP_ID_KEY));
        MainActivity.os.group.setGroupName(SP.getString(SP.GROUP_NAME_KEY));

        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);
        sqlA.append("SELECT ");
        sqlA.append("   UserID ");
        sqlA.append(" , UserName ");
        sqlA.append("FROM Users;");
        Cursor cursor = db.rawQuery(sqlA.toString(), null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                User user = new User();
                user.setUserID(cursor.getInt(cursor.getColumnIndex("UserID")));
                user.setUserName(cursor.getString(cursor.getColumnIndex("UserName")));
                MainActivity.os.addUserToGroup(user);
                cursor.moveToNext();
            }
        }

        sqlA.setLength(0);
        sqlA.append("SELECT ");
        sqlA.append("   GroupID ");
        sqlA.append(" , MakerID ");
        sqlA.append(" , ObjectType");
        sqlA.append(" , Text ");
        sqlA.append(" , ObjectID ");
        sqlA.append(" , DibsUser ");
        sqlA.append(" , CompletedUser ");
        sqlA.append(" , TimeCreated ");
        sqlA.append(" , Amount ");
        sqlA.append("FROM Objects ");
        cursor = db.rawQuery(sqlA.toString(), null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String objectType = cursor.getString(cursor.getColumnIndex("ObjectType"));
                BaseObject object = new BaseObject();
                switch (objectType){
                    case "Chore":
                        object = new Chore();
                        break;
                    case "GroceryItem":
                        object = new GroceryItem();
                        break;
                    case "Payment":
                        object = new Payment();
                        ((Payment)object).setAmount(cursor.getDouble(cursor.getColumnIndex("Amount")));
                        break;
                    case "Message":
                        object = new Message();
                        break;
                }
                object.setObjectID(cursor.getInt(cursor.getColumnIndex("ObjectID")));
                object.setGroup(MainActivity.os.group);
                object.setText(cursor.getString(cursor.getColumnIndex("Text")));
                object.setMaker(MainActivity.os.getUserByID(cursor.getInt(cursor.getColumnIndex("MakerID"))));
                if(cursor.getInt(cursor.getColumnIndex("CompletedUser")) == 0) {
                    object.setCompletedUser(MainActivity.os.getUserByID(cursor.getInt(cursor.getColumnIndex("CompletedUser"))));
                }
                if(cursor.getInt(cursor.getColumnIndex("DibsUser")) == 0) {
                    object.setDibsUser(MainActivity.os.getUserByID(cursor.getInt(cursor.getColumnIndex("DibsUser"))));
                }
                object.setTimeCreated(cursor.getString(cursor.getColumnIndex("TimeCreated")));
                MainActivity.os.addObject(object);
                cursor.moveToNext();
            }
        }
        cursor.close();
    }

    public ArrayList<BaseObject> getWidgetObjects(){
        ArrayList<BaseObject> objects = new ArrayList<>();
        HashMap<Integer,User> users = new HashMap<>();
        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);
        sqlA.append("SELECT ");
        sqlA.append("   UserID ");
        sqlA.append(" , UserName ");
        sqlA.append("FROM Users;");
        Cursor cursor = db.rawQuery(sqlA.toString(), null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                User user = new User();
                user.setUserID(cursor.getInt(cursor.getColumnIndex("UserID")));
                user.setUserName(cursor.getString(cursor.getColumnIndex("UserName")));
                users.put(user.getUserID(), user);
                cursor.moveToNext();
            }
        }

        sqlA.setLength(0);
        sqlA.append("SELECT ");
        sqlA.append("   GroupID ");
        sqlA.append(" , MakerID ");
        sqlA.append(" , ObjectType");
        sqlA.append(" , Text ");
        sqlA.append(" , ObjectID ");
        sqlA.append(" , DibsUser ");
        sqlA.append(" , CompletedUser ");
        sqlA.append(" , TimeCreated ");
        sqlA.append(" , Amount ");
        sqlA.append("FROM Objects ");
        sqlA.append("WHERE NOT ObjectType = 'Message' ");
        cursor = db.rawQuery(sqlA.toString(), null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String objectType = cursor.getString(cursor.getColumnIndex("ObjectType"));
                BaseObject object = new BaseObject();
                switch (objectType){
                    case "Chore":
                        object = new Chore();
                        break;
                    case "GroceryItem":
                        object = new GroceryItem();
                        break;
                    case "Payment":
                        object = new Payment();
                        ((Payment)object).setAmount(cursor.getDouble(cursor.getColumnIndex("Amount")));
                        break;
                    case "Message":
                        object = new Message();
                }
                object.setObjectID(cursor.getInt(cursor.getColumnIndex("ObjectID")));
                object.setText(cursor.getString(cursor.getColumnIndex("Text")));
                object.setMaker(users.get(cursor.getInt(cursor.getColumnIndex("MakerID"))));
                if(cursor.getInt(cursor.getColumnIndex("CompletedUser")) == 0) {
                    object.setCompletedUser(users.get(cursor.getInt(cursor.getColumnIndex("CompletedUser"))));
                }
                if(cursor.getInt(cursor.getColumnIndex("DibsUser")) == 0) {
                    object.setDibsUser(users.get(cursor.getInt(cursor.getColumnIndex("DibsUser"))));
                }
                object.setTimeCreated(cursor.getString(cursor.getColumnIndex("TimeCreated")));
                objects.add(object);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return objects;
    }

    public boolean userExists(){
        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);
        sqlA.append("SELECT * FROM Users;");
        Cursor model = db.rawQuery(sqlA.toString(), null);
        boolean userExists = model.moveToFirst();
        model.close();
        sqlA.setLength(0);
        return userExists;
    }

    public ArrayList<HelpItem> getHelpItems(){
        ArrayList<HelpItem> items = new ArrayList<>();
        StringBuilder sqlA = new StringBuilder();
        sqlA.setLength(0);
        sqlA.append("SELECT * ");
        sqlA.append("FROM Help");
        Cursor model = db.rawQuery(sqlA.toString(), null);
        if(model.moveToFirst()){
            while(!model.isAfterLast()){
                HelpItem item = new HelpItem();
                item.setHeader(model.getString(model.getColumnIndex("Header")));
                item.setDetail(model.getString(model.getColumnIndex("Detail")));
                items.add(item);
                model.moveToNext();
            }
        }
        model.close();
        return items;
    }
}
