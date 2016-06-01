package com.darkheaven.roomlike.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.darkheaven.roomlike.R;

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

        sqlA.append("CREATE TABLE IF NOT EXISTS `Objects` ");
        sqlA.append("(");
        sqlA.append("   GroupID INTEGER ");
        sqlA.append(" , MakerID INTEGER ");
        sqlA.append(" , `Text` TEXT ");
        sqlA.append(" , ObjectID INTEGER ");
        sqlA.append(" , DibsUser INTEGER ");
        sqlA.append(" , CompletedUser INTEGER ");
        sqlA.append(" , ScheduleID INTEGER ");
        sqlA.append(" , TimeCreated DATE ");
        sqlA.append(" , Amount DOUBLE ");
        sqlA.append(" , FOREIGN KEY (GroupID) REFERENCES Groups(GroupID) ");
        sqlA.append(" , FOREIGN KEY (MakerID) REFERENCES Users(UserID) ");
        sqlA.append(" , FOREIGN KEY (DibsUser) REFERENCES Users(UserID) ");
        sqlA.append(" , FOREIGN KEY (CompletedUser) REFERENCES Users(UserID) ");
        sqlA.append(" , FOREIGN KEY (ScheduleID) REFERENCES Schedules(ScheduleID) ");
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

        sqlA.append("CREATE TABLE IF NOT EXISTS UsersScheduled ");
        sqlA.append("(");
        sqlA.append("   ScheduleID INTEGER ");
        sqlA.append(" , UserID INTEGER ");
        sqlA.append(" , FOREIGN KEY (ScheduleID) REFERENCES Schedules(ScheduleID) ");
        sqlA.append(" , FOREIGN KEY (UserID) REFERENCES Users(UserID) ");
        sqlA.append(")");
        db.execSQL(sqlA.toString());
        sqlA.setLength(0);
    }

    public void deleteTableData(){
        db.execSQL("DELETE FROM Users;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
