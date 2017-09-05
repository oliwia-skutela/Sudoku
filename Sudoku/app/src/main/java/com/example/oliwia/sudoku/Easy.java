package com.example.oliwia.sudoku;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.DigitsKeyListener;
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
    @SuppressWarnings("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        db= new SudokuDBHelper(this);
        SudokuGenerator t = new SudokuGenerator();
        int [][] Sudoku = t.generateGrid();




        for(int i =0; i<9; i++)
        {
            for(int j =0; j<9; j++)
            {
                properSudokuTab[i][j]=String.valueOf(Sudoku[i][j]);
                checkSudokuTab[i][j]=String.valueOf(Sudoku[i][j]);
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
                b.setLayoutParams(new TableRow.LayoutParams(buttonsize, buttonsize));
                mButtons.add(b);
                final int tempI=i;
                final int tempJ=j;
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setStroke(2, Color.BLACK);
                if((j<3 && i<3 )||(j>5 && i>5) ||(j>5 && i<3) ||(j<3 && i>5)||(j>2 && j<6 && i>2 && i<6)) {

                    drawable.setColor(Color.rgb(255, 255, 204));
                }
                else
                {
                    drawable.setColor(Color.rgb(255, 255, 000));

                }
                b.setBackgroundDrawable(drawable);
                //b.setOnClickListener(this);
                if(properSudokuTab[i][j] == null || properSudokuTab[i][j].isEmpty() || properSudokuTab[i][j] == " ") {
                   // GradientDrawable font = new GradientDrawable();
                    //font.setColor(Color.rgb(255, 000, 000));
                    //b.setForeground(font);
                    b.setTextColor(Color.BLUE);
                    b.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Button b = (Button) v;
                            currentButton = b;
                            currentX=tempI;
                            currentY=tempJ;
                        }
                    });

                    /*GradientDrawable border = new GradientDrawable();
                    border.setStroke(1, Color.MAGENTA);
                    border.setGradientType(GradientDrawable.RECTANGLE);

                    Drawable[] layers = {border};*/
                   // b.setBackgroundColor(0xff0000ff);

                    //drawable.setGradientType(GradientDrawable.RECTANGLE);

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

        time = (Chronometer) findViewById(R.id.chronometer2);
        time.start();

    }

    protected void Check(Button button)
    {
        String tempButton = button.getText().toString();
        currentButton.setText(tempButton);

        if(tempButton.equals(checkSudokuTab[currentX][currentY]))
        {
            currentButton.setBackgroundColor(0x00000000);


        }else
        {
            currentButton.setBackgroundColor(0xFFFF0000);

        }


        if(checkAllButtons(mButtons)){
            Toast.makeText(Easy.this, "Jeszcze do rozwiazania", Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(Easy.this, "Ukonczona", Toast.LENGTH_SHORT).show();
            if(checkIfCorrect(mButtons))
            {
                Toast.makeText(Easy.this, "Ukonczone i bez bledow", Toast.LENGTH_SHORT).show();

                time.stop();

                String date = getCurrentDate();
                BoardHelper bh = new BoardHelper();
                String originalBoard = bh.convertToString(checkSudokuTab);
                String currentBoard = bh.convertToString(properSudokuTab);
                db.addBoard(date,currentBoard,originalBoard );
            }else
            {
                Toast.makeText(Easy.this, "Plansza zawiera błędy", Toast.LENGTH_SHORT).show();
            }

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

    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
        String strDate = mdformat.format(calendar.getTime());
        return strDate;
    }

}
