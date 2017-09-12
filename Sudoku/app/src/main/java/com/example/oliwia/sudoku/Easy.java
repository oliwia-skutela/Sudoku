package com.example.oliwia.sudoku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by A501 on 2017-05-28.
 */

public class Easy extends AppCompatActivity {

    Button currentButton;
    TableLayout tl;
    int currentX;
    int currentY;
    List<Button> mButtons = new ArrayList();
    final String [][] checkSudokuTab = new String[9][9];
    final String [][] properSudokuTab = new String[9][9];
    Chronometer time;
    SudokuDBHelper db;
    String login ="";
    int level;
    String boardLevel="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        db= new SudokuDBHelper(this);
        SudokuGenerator t = new SudokuGenerator();
        int [][] Sudoku = t.generateGrid();

        Bundle bundle = getIntent().getExtras();
        int level = 50; // or other values
        if(bundle != null) {
            level = bundle.getInt("key");
        }


        for(int i =0; i<9; i++)
        {
            for(int j =0; j<9; j++)
            {
                properSudokuTab[i][j]=String.valueOf(Sudoku[i][j]);
                checkSudokuTab[i][j]=String.valueOf(Sudoku[i][j]);
            }
        }

        Random generator = new Random();

        for(int i = 0; i<level; i++)
        {
            try
            {
                int row =  generator.nextInt(9);
                int column =  generator.nextInt(9);
                if(properSudokuTab[row][column]==" ") {
                    i=i-1;
                }
                else
                {
                    properSudokuTab[row][column] =" ";
                }

            }
            catch(IndexOutOfBoundsException e)
            {
                //todo error message
            }

        }
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        int buttonsize = width/9;
        tl=(TableLayout)findViewById(R.id.tableLayoutSudoku);
        for( int i = 0 ; i <9; i++)
        {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            for( int j = 0 ; j <9; j++)
            {
                Button b = new Button(this);
                b.setText(properSudokuTab[i][j]);
                b.setLayoutParams(new TableRow.LayoutParams(buttonsize, buttonsize));                mButtons.add(b);
                final int tempI=i;
                final int tempJ=j;
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setStroke(2, Color.BLACK);
                if(level==30) {
                    if ((j < 3 && i < 3) || (j > 5 && i > 5) || (j > 5 && i < 3) || (j < 3 && i > 5) || (j > 2 && j < 6 && i > 2 && i < 6)) {

                        drawable.setColor(Color.rgb(255, 255, 204));
                    } else {
                        drawable.setColor(Color.rgb(255, 255, 000));

                    }
                }

                if(level==45) {
                    if ((j < 3 && i < 3) || (j > 5 && i > 5) || (j > 5 && i < 3) || (j < 3 && i > 5) || (j > 2 && j < 6 && i > 2 && i < 6)) {

                        drawable.setColor(Color.rgb(171, 217, 233));
                    } else {
                        drawable.setColor(Color.rgb(44, 123, 182));

                    }
                }

                if(level==60) {
                    if ((j < 3 && i < 3) || (j > 5 && i > 5) || (j > 5 && i < 3) || (j < 3 && i > 5) || (j > 2 && j < 6 && i > 2 && i < 6)) {

                        drawable.setColor(Color.rgb(178, 171, 210));
                    } else {
                        drawable.setColor(Color.rgb(94, 60, 153));

                    }
                }


                b.setBackgroundDrawable(drawable);
                if(properSudokuTab[i][j] == null || properSudokuTab[i][j].isEmpty() || properSudokuTab[i][j] == " ") {
                    b.setTextColor(Color.BLUE);
                    b.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Button b = (Button) v;
                            currentButton = b;
                            currentX=tempI;
                            currentY=tempJ;
                        }
                    });
                }
                tr.addView(b);
            }

            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

        Button jeden = (Button)findViewById(R.id.jeden);
        jeden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button dwa = (Button)findViewById(R.id.dwa);
        dwa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button trzy = (Button)findViewById(R.id.trzy);
        trzy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button cztery = (Button)findViewById(R.id.cztery);
        cztery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button piec = (Button)findViewById(R.id.piec);
        piec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button szesc = (Button)findViewById(R.id.szesc);
        szesc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button siedem = (Button)findViewById(R.id.siedem);
        siedem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button osiem = (Button)findViewById(R.id.osiem);
        osiem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button dziewiec = (Button)findViewById(R.id.dziewiec);
        dziewiec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });
        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentButton != null) {
                    Button b = (Button) v;
                    Check(b);
                }
            }
        });

        Button check = (Button)findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckSolution(mButtons);
            }
        });

        time = (Chronometer) findViewById(R.id.chronometer2);
        time.start();



    }

    public void CheckSolution (List<Button> ButtonList){
        int counter=0;
        for(int i = 0; i<9; i++)
        {
            for (int j=0; j<9; j++){
                if(!checkSudokuTab[i][j].equals(ButtonList.get(counter).getText().toString())&& !ButtonList.get(counter).getText().toString().equals(" "))
                {
                    ButtonList.get(counter).setBackgroundColor(0xFFFF0000);
                }

                counter++;
            }
        }
    }

    public boolean CheckAllFullSudokuTab(List<Button> ButtonList)
    {
        int counter=0;
        for(int i = 0; i<9; i++)
        {
            for (int j=0; j<9; j++){
                if(!checkSudokuTab[i][j].equals(ButtonList.get(counter).getText().toString()))//|| ButtonList.get(counter).getText().toString().equals(" "))
                {
                   return false;
                }

                counter++;
            }
        }
        return true;
    }

    protected void Check(Button button)
    {
        String tempButton = button.getText().toString();
        if(tempButton.equals("usuń"))
        {
            tempButton=" ";
        }

        currentButton.setText(tempButton);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setStroke(2, Color.BLACK);
        drawable.setColor(Color.rgb(255, 255, 255));
        currentButton.setBackgroundDrawable(drawable);

        if(!checkAllButtons(mButtons) && !CheckAllFullSudokuTab(mButtons)){
            Toast.makeText(Easy.this, "Jeszcze do rozwiazania", Toast.LENGTH_SHORT).show();

        }else if(!checkAllButtons(mButtons) && CheckAllFullSudokuTab(mButtons))
        {
            Toast.makeText(Easy.this, "Ukonczona", Toast.LENGTH_SHORT).show();
            time.stop();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Czy chcesz zapisać swój wynik?");


            final EditText input = new EditText(this);

            input.setText("Podaj login");
            builder.setView(input);


            builder.setPositiveButton("Zapisz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    login = input.getText().toString();
                    switch(level) {
                        case 30:
                            boardLevel = "łatwy";
                            break;
                        case 45:
                            boardLevel = "średni";
                            break;
                        case 60:
                            boardLevel = "trudny";
                            break;
                    }

                    db.addRecord(login,time.getText().toString(),boardLevel);
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
    }





    boolean checkAllButtons(List<Button> buttons) {

        boolean isEmpty=false;
        for (Button b:buttons) {
            if(b.getText().equals(" "))
            {
                isEmpty=true;
                break;
            }

        }
        return isEmpty;
    }

    boolean checkIfCorrect(List<Button> buttons)
    {
        boolean isCorrect=true;
        for(Button b:buttons){
            if(b.getTextColors().getDefaultColor()==0xFFFF0000)
            {
                isCorrect=false;
                break;
            }

        }
        return isCorrect;
    }

    String saveBoard(List<Button> buttons)
    {
        String actuallyBoard="";
        int i=1;
        for(Button b:buttons)
        {
            if(i==9)
            {
                actuallyBoard+=b.getText().toString()+";";
                i=1;
            }else
            {
                actuallyBoard+=b.getText().toString()+",";
                i++;
            }


        }
        return actuallyBoard;
    }

    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
        String strDate = mdformat.format(calendar.getTime());
        return strDate;
    }
    @Override
    public void onBackPressed() {

        saveBoardToDB();

        super.onBackPressed();
    }


    public void saveBoardToDB()
    {
        time.stop();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        BoardHelper bh = new BoardHelper();
        String originalBoard = bh.convertToString(checkSudokuTab);
        String emptyBoard = bh.convertToString(properSudokuTab);
        String board = saveBoard(mButtons);
        switch(level) {
            case 30:
                boardLevel = "łatwy";
                break;
            case 45:
                boardLevel = "średni";
                break;
            case 60:
                boardLevel = "trudny";
                break;
        }



        db.addBoard(date,emptyBoard,originalBoard, board, time.getText().toString(), boardLevel);

    }


}
