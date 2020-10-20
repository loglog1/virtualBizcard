package com.matsumoto.bizcard.DB_controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB_controller extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DB_NAME = "bizcard_info.sqlite3";

    public class USER_NAME{
        public int id;
        public String image_name;
    }

    public class NET_INFO{
        public int id;
        public String net_spec;
        public String net_acount;
    }

    public class ADRESS_INFO{
        public int id;
        public String company_name;
        public String address;
        public String tel_num;
        public String role;
    }


    public DB_controller(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRY = "create table USER_NAME(" +
                "id integer primary key," +
                "user_name text);";
        SQL_CREATE_ENTRY +="create table IMAGE_NAME( " +
                "id integer, " +
                "image_name text, " +
                "foreign key(id) references USER_NAME);";
        SQL_CREATE_ENTRY +="create table NET_INFO( " +
                "id integer, " +
                "net_spec text, " +
                "net_acount text, " +
                "foreign key(id) references USER_NAME);";
        SQL_CREATE_ENTRY +="create table ADRESS_INFO( " +
                "id integer, " +
                "company_name text, " +
                "address text," +
                " tel_num text," +
                " role text, " +
                "foreign key(id) references USER_NAME)";
        db.execSQL(SQL_CREATE_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "drop table USER_NAME;";
        SQL_DELETE_ENTRIES += "drop table IMAGE_NAME;";
        SQL_DELETE_ENTRIES += "drop table NET_INFO;";
        SQL_DELETE_ENTRIES += "drop table ADRESS_INFO;";
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void getUSERNAME(){}

    public void putSNSData(){}
}
