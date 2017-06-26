package com.example.oliwia.sudoku;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

/**
 * Created by A501 on 2017-05-28.
 */

public class Easy extends AppCompatActivity {

    Button currentButton;
    TableLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        SudokuGenerator t = new SudokuGenerator();
        int [][] Sudoku = t.generateGrid();

        String [][] properSudokuTab = new String[9][9];

        for(int i =0; i<9; i++)
        {
            for(int j =0; j<9; j++)
            {
                properSudokuTab[i][j]=String.valueOf(Sudoku[i][j]);
            }
        }

        Random generator = new Random();

        for(int i = 0; i<40; i++)
        {
            try
            {
                int row =  generator.nextInt(9);
                int column =  generator.nextInt(9);
                properSudokuTab[row][column] =" ";
            }
            catch(IndexOutOfBoundsException e)
            {
                //todo error message
            }

        }

        tl=(TableLayout)findViewById(R.id.tableLayoutSudoku);
        for(int i = 0 ; i <9; i++)
        {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            for(int j = 0 ; j <9; j++)
            {
                Button b = new Button(this);
                b.setText(properSudokuTab[i][j]);
                b.setLayoutParams(new TableRow.LayoutParams(60, 60));
                //b.setOnClickListener(this);
                if(properSudokuTab[i][j] == null || properSudokuTab[i][j].isEmpty() || properSudokuTab[i][j] == " ") {
                    b.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Button b = (Button) v;
                            currentButton = b;
                        }
                    });
                }
                //b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                tr.addView(b);
            }

            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

        Button jeden = (Button)findViewById(R.id.jeden);
        jeden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });

        Button dwa = (Button)findViewById(R.id.dwa);
        dwa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });

        Button trzy = (Button)findViewById(R.id.trzy);
        trzy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });

        Button cztery = (Button)findViewById(R.id.cztery);
        cztery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });

        Button piec = (Button)findViewById(R.id.piec);
        piec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });

        Button szesc = (Button)findViewById(R.id.szesc);
        szesc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });
        Button siedem = (Button)findViewById(R.id.siedem);
        siedem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });
        Button osiem = (Button)findViewById(R.id.osiem);
        osiem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });
        Button dziewiec = (Button)findViewById(R.id.dziewiec);
        dziewiec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    currentButton.setText(b.getText());
                }
            }
        });



    }

}
