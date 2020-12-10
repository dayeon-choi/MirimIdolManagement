package org.techtown.mirimidolmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    //DB 생성
    public MyDBHelper(@Nullable Context context) {
        super(context, "groupDB", null, 1);
    }
    //table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("[DB]", "테이블 생성");
        db.execSQL("create table groupTBL(gName CHAR(20) PRIMARY KEY, gNumber INTEGER)");
    }
    //db가 update 되었을 때 기존의 table을 삭제하고 새로 생성
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //만약 groupTBL이 있다면 지움
        Log.d("[DB]", "테이블 지우고 생성");
        db.execSQL("drop table if exists groupTBL");
        onCreate(db);
    }
}
