package com.example.oliwia.sudoku;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RestoreBoard extends AppCompatActivity {
ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore_board);

        SudokuDBHelper db = new SudokuDBHelper(this);

        String[] fromfieldsName = new String[]{ "_id", "Date"};
        int[] toViewID = new int[]{  R.id.item_id, R.id.item_date};
        Cursor cursor=db.getAllBoards();

        SimpleCursorAdapter mysimplecursor = new SimpleCursorAdapter(getBaseContext(), R.layout.restore_item_layout, cursor, fromfieldsName, toViewID, 0);
        lv = (ListView) findViewById(R.id.listRestore);
        lv.setAdapter(mysimplecursor);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {

                Cursor cursor = (Cursor) listView.getItemAtPosition(position);


                final String code =
                        cursor.getString(cursor.getColumnIndexOrThrow("_id"));

                int getid = Integer.parseInt(code);

                Intent cell = new Intent(getApplicationContext(), BoardFromDB.class);
                Bundle b = new Bundle();
                b.putInt("id", getid);
                cell.putExtras(b);
                startActivity(cell);
            }
            });
}}
