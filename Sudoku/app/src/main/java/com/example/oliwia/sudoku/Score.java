package com.example.oliwia.sudoku;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class Score extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        SudokuDBHelper db = new SudokuDBHelper(this);

        String[] fromfieldsName = new String[]{ "UserName", "Time", "Level"};
        int[] toViewID = new int[]{  R.id.item_user, R.id.item_time, R.id.item_level};
        Cursor cursor=db.getRecords();

        SimpleCursorAdapter mysimplecursor = new SimpleCursorAdapter(getBaseContext(), R.layout.item_layout, cursor, fromfieldsName, toViewID, 0);
        lv = (ListView) findViewById(R.id.listScore);
        lv.setAdapter(mysimplecursor);
    }
}
