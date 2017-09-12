package com.example.oliwia.sudoku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.Calendar;
import java.util.List;

public class BoardFromDB extends AppCompatActivity {
    int id;
    final String [][] checkSudokuTab = new String[9][9];
    final String [][] properSudokuTab = new String[9][9];
    Button currentButton;
    TableLayout tl;
    int currentX;
    int currentY;
    List<Button> mButtons = new ArrayList();
    Chronometer time;
    SudokuDBHelper db;
    String login="";
    String previousTime="";
    String level="";
    String emptyBoardstr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_from_db);

        db = new SudokuDBHelper(this);
        BoardHelper boardHelper=new BoardHelper();

        Bundle bundle = getIntent().getExtras();

        id=1;
        if(bundle != null) {
            id = bundle.getInt("id");
        }

        Cursor cursor = db.getBoard(id);
        String originalBoardstr="";
        String boardstr="";
        if(cursor != null && cursor.moveToFirst()) {
            boardstr = cursor.getString(2);
            originalBoardstr=cursor.getString(1);
            emptyBoardstr=cursor.getString(0);
            previousTime=cursor.getString(3);
            level=cursor.getString(4);
        }



        String [][] emptyBoard =boardHelper.convertToTable(emptyBoardstr);
        String [][] originalBoard = boardHelper.convertToTable(originalBoardstr);
        String [][] board = boardHelper.convertToTable(boardstr);

        for(int i =0; i<9; i++)
        {
            for(int j =0; j<9; j++)
            {
                properSudokuTab[i][j]=board[i][j];
                checkSudokuTab[i][j]=originalBoard[i][j];
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
                if((j<3 && i<3 )||(j>5 && i>5) ||(j>5 && i<3) ||(j<3 && i>5)||(j>2 && j<6 && i>2 && i<6)) {

                    drawable.setColor(Color.rgb(255, 255, 204));
                }
                else
                {
                    drawable.setColor(Color.rgb(255, 255, 000));

                }
                b.setBackgroundDrawable(drawable);

                if(emptyBoard[i][j] == null || emptyBoard[i][j].isEmpty() || emptyBoard[i][j].equals(" ") || emptyBoard.equals("")) {

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

    protected void Check(Button button)
    { String tempButton = button.getText().toString();
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
            Toast.makeText(BoardFromDB.this, "Jeszcze do rozwiazania", Toast.LENGTH_SHORT).show();

        }else if(!checkAllButtons(mButtons) && CheckAllFullSudokuTab(mButtons))
        {
            Toast.makeText(BoardFromDB.this, "Ukonczona", Toast.LENGTH_SHORT).show();
            time.stop();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Czy chcesz zapisać swój wynik?");



            final EditText input = new EditText(this);

            input.setText("Podaj login");
            builder.setView(input);


            builder.setPositiveButton("Zapisz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(BoardFromDB.this, "jestem w zapisz", Toast.LENGTH_LONG).show();
                    login = input.getText().toString();
                    String [] t1=previousTime.split(":");
                    String actuallyTime=time.getText().toString();
                    String [] t2=actuallyTime.split(":");

                    int min1=Integer.parseInt(t1[0]);
                    int sek1=Integer.parseInt(t1[1]);
                    int min2=Integer.parseInt(t2[0]);
                    int sek2=Integer.parseInt(t2[1]);

                    int minuty=min1+min2;

                    int sekundy=(sek1+sek2);

                    if(sekundy>59)
                    {
                        minuty=minuty+1;
                        sekundy=sekundy-60;
                    }
                    String czas= minuty+":"+sekundy;



                    db.addRecord(login, czas,level);
                    db.removeBoard(String.valueOf(id));
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
        String emptyBoard = emptyBoardstr;
        String board = saveBoard(mButtons);

        String [] t1=previousTime.split(":");
        String actuallyTime=time.getText().toString();
        String [] t2=actuallyTime.split(":");

        int min1=Integer.parseInt(t1[0]);
        int sek1=Integer.parseInt(t1[1]);
        int min2=Integer.parseInt(t2[0]);
        int sek2=Integer.parseInt(t2[1]);

        int minuty=min1+min2;

        int sekundy=(sek1+sek2);

        if(sekundy>59)
        {
            minuty=minuty+1;
            sekundy=sekundy-60;
        }
        String czas= minuty+":"+sekundy;



        db.addBoard(date,emptyBoard,originalBoard, board, czas, level);
        db.removeBoard(String.valueOf(id));

    }
    }

