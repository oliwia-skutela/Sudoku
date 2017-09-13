package com.example.oliwia.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button btnCreate;
    Button btnRestore;
    Button btnEasy;
    Button btnMedium;
    Button btnHard;
    Button btnInstruction;
    Button btnScore;
    SudokuDBHelper sdb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreate=(Button)findViewById(R.id.btnCreate);
        btnRestore=(Button)findViewById(R.id.btnRestore);
        btnEasy=(Button)findViewById(R.id.btnEasy);
        btnMedium=(Button)findViewById(R.id.btnMedium);
        btnHard=(Button)findViewById(R.id.btnHard);
        btnInstruction=(Button)findViewById(R.id.btnInstruction);
        btnScore=(Button)findViewById(R.id.btnScore);

        sdb=new SudokuDBHelper(this);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cell = new Intent(getApplicationContext(), Create.class);
                startActivity(cell);
            }
        });

        btnRestore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cell = new Intent(getApplicationContext(), RestoreBoard.class);
                startActivity(cell);
            }
        });

        btnEasy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent cell = new Intent(getApplicationContext(), Levels.class);
                Bundle b = new Bundle();
                b.putInt("key", 30);
                cell.putExtras(b);
                startActivity(cell);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent cell = new Intent(getApplicationContext(), Levels.class);
                Bundle b = new Bundle();
                b.putInt("key", 45);
                cell.putExtras(b);
                startActivity(cell);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cell = new Intent(getApplicationContext(), Levels.class);
                Bundle b = new Bundle();
                b.putInt("key", 60);
                cell.putExtras(b);
                startActivity(cell);
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent cell = new Intent(getApplicationContext(), Score.class);
                startActivity(cell);
            }
        });

        btnInstruction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cell = new Intent(getApplicationContext(), Instruction.class);
                startActivity(cell);
            }
        });
    }




}
