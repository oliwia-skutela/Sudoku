package com.example.oliwia.sudoku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by A501 on 2017-09-11.
 */

public class Create extends AppCompatActivity {

    Button currentButton;
    TableLayout tl;
    List<Button> mButtons = new ArrayList();
    int currentX;
    int currentY;
   final String [][] properSudokuTab = new String[9][9];
    SudokuDBHelper db;
    String login ="";
    Chronometer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        db=new SudokuDBHelper(this);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        int buttonsize = width/9;
        tl=(TableLayout)findViewById(R.id.tableLayoutSudoku2);
        for( int i = 0 ; i <9; i++)
        {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            for( int j = 0 ; j <9; j++)
            {
                Button b = new Button(this);
                b.setText(" ");
                b.setLayoutParams(new TableRow.LayoutParams(buttonsize, buttonsize));                mButtons.add(b);
                final int tempI=i;
                final int tempJ=j;
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setStroke(2, Color.BLACK);
                    if ((j < 3 && i < 3) || (j > 5 && i > 5) || (j > 5 && i < 3) || (j < 3 && i > 5) || (j > 2 && j < 6 && i > 2 && i < 6)) {

                        drawable.setColor(Color.rgb(166, 217, 106));
                    } else {
                        drawable.setColor(Color.rgb(77, 172, 80));
                    }




                b.setBackgroundDrawable(drawable);
                    b.setTextColor(Color.BLUE);
                    b.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Button b = (Button) v;
                            currentButton = b;
                            currentX=tempI;
                            currentY=tempJ;

                        }
                    });
                tr.addView(b);
            }

            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
        Button jeden = (Button)findViewById(R.id.one);
        jeden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button dwa = (Button)findViewById(R.id.two);
        dwa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button trzy = (Button)findViewById(R.id.three);
        trzy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button cztery = (Button)findViewById(R.id.four);
        cztery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button piec = (Button)findViewById(R.id.five);
        piec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button szesc = (Button)findViewById(R.id.six);
        szesc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button siedem = (Button)findViewById(R.id.seven);
        siedem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button osiem = (Button)findViewById(R.id.eight);
        osiem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button dziewiec = (Button)findViewById(R.id.nine);
        dziewiec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button delete = (Button)findViewById(R.id.delete2);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button check = (Button)findViewById(R.id.check2);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(CheckSolution(mButtons)) {
                    Toast.makeText(Create.this, "Gratulacje", Toast.LENGTH_SHORT).show();
                    time.stop();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("Czy chcesz zapisać swój wynik?");


                    final EditText input = new EditText(getApplicationContext());

                    input.setText("Podaj login");
                    builder.setView(input);


                    builder.setPositiveButton("Zapisz", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            login = input.getText().toString();

                            db.addRecord(login,time.getText().toString(), "własny");
                            Intent cell = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(cell);
                        }
                    });
                    builder.setNegativeButton("Nie zapisuj", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            Intent cell = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(cell);
                        }
                    });

                    builder.show();


                }
                else
                {
                    Toast.makeText(Create.this, "Próbuj dalej", Toast.LENGTH_SHORT).show();
                }
            }
        });

        time = (Chronometer) findViewById(R.id.chronometer3);
        time.start();

    }

    public boolean CheckSolution (List<Button> buttons){

        int[][] arr = new int[9][9];
        int counter=0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(buttons.get(counter).getText().toString().equals(" ")){
                    return false;
                }
                else {
                    arr[i][j] = Integer.parseInt(buttons.get(counter).getText().toString());
                }
                counter++;
            }
        }

            if (arr.length != 9)
                return false;

            for (int i = 0; i < 9; i++)
            {
                if (arr[i].length != 9)
                    return false;
                for (int j = 0; j < 9; j++)
                    if (arr[i][j] < 1 || arr[i][j] > 9)
                        return false;
            }

            int[]   counts = new int[9];
            int good_count = 0;
            Arrays.fill(counts, 0);

            // rows
            for (int i = 0; i < 9; i++)
            {
                good_count++;
                for (int j = 0; j < 9; j++)
                {
                    counts[arr[i][j] - 1]++;
                    if (counts[arr[i][j] - 1] != good_count)
                        return false;
                }
            }

            // columns
            for (int j = 0; j < 9; j++)
            {
                good_count++;
                for (int i = 0; i < 9; i++)
                {
                    counts[arr[i][j] - 1]++;
                    if (counts[arr[i][j] - 1] != good_count)
                        return false;
                }
            }

            // blocks
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    good_count++;
                    for (int r = i * 3; r < i * 3 + 3; r++)
                    {
                        for (int c = j * 3; c < j * 3 + 3; c++)
                        {
                            counts[arr[r][c] - 1]++;
                            if (counts[arr[r][c] - 1] != good_count)
                            return false;
                        }
                    }
                }
            }
            return true;
        }

    protected void Check(Button button) {
        String tempButton = button.getText().toString();
        if (tempButton.equals("usuń")) {
            tempButton = " ";
        }

        currentButton.setText(tempButton);
    }
}
