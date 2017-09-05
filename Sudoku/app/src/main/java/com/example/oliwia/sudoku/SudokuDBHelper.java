package com.example.oliwia.sudoku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;

/**
 * Created by Oliwia on 2017-05-10.
 */

public class SudokuDBHelper extends SQLiteOpenHelper {
    public static final String LOGCAT=null;

    public static final String DBName="Sudoku.db";
    public static final String TableRecords="Records";
    public static final String Col_0R="_id";
    public static final String Col_1R="UserName";
    public static final String Col_2R="Time";
    public static final String Col_3R="Level";

    public static final String TableBoards="Boards";
    public static final String Col_0B="_id";
    public static final String Col_1B="Date";
    public static final String Col_2B="Board";
    public static final String Col_3B="OriginalBoard";




    public SudokuDBHelper(Context context) {

        super(context, DBName, null, 1);
        Log.d(LOGCAT,"Create DB");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TableRecords + " ( " + Col_0R + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Col_1R + " text, " +
                Col_2R + " text, " +
                Col_3R + " text" + ")");
        Log.d(LOGCAT,"Create table Records");

        db.execSQL("CREATE TABLE " + TableBoards + " ( " + Col_0B + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Col_1B + " text, " +
                Col_2B + " text,"  +
                Col_3B + " text"+ ")");
        Log.d(LOGCAT,"Create table Boards");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public synchronized void close() {
        super.close();
    }

    public void addRecord(String username, String time,String level){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Col_1R,username);
        value.put(Col_2R,time);
        value.put(Col_3R,level);
        db.insertOrThrow(TableRecords, null, value);
        db.close();
        Log.d(LOGCAT,"Add to table Records");
    }

    public void addBoard(String date, String board, String originalBoard){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Col_1B,date);
        value.put(Col_2B,board);
        value.put(Col_3B,originalBoard);
        db.insert(TableBoards, null, value);
        db.close();
        Log.d(LOGCAT,"Add to table Boards");
    }

    public Cursor getRecords(){
        String[] columns = {Col_0R,Col_1R,Col_2R,Col_3R};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TableRecords, columns, null, null, null, null, null);
        return cursor;
    }

    public void removeRecords()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TableRecords, null, null);
    }


    public String getLastBoard(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] columns = {Col_1B,Col_2B};
        String where = Col_0B + "=" + id;
        Cursor cursor = db.query(TableBoards, columns, where, null, null, null, null);
        String board="";

        if(cursor != null && cursor.moveToFirst()) {
            board = cursor.getString(2);
        }
        return board;
    }

    public Cursor getAllBoards(){
        String[] columns = {Col_0B,Col_1B,Col_2B};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TableRecords, columns, null, null, null, null, null);
        return cursor;
    }

    public boolean doesDatabaseExist(Context context) {
        File dbFile = context.getDatabasePath(DBName);
        return dbFile.exists();
    }

}
