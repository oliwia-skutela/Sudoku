package com.example.oliwia.sudoku;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oliwia on 2017-05-14.
 */

public class SudokuGenerator {

        private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();

        private Random random = new Random();

        public SudokuGenerator(){}


        public int[][] generateGrid(){
            int[][] sudoku = new int[9][9];

            int currentPos = 0;


            while( currentPos < 81 ){
                if( currentPos == 0 ){
                    clearGrid(sudoku);
                }

                if( Available.get(currentPos).size() != 0 ){
                    int i = random.nextInt(Available.get(currentPos).size());
                    int number = Available.get(currentPos).get(i);


                    int xPos = currentPos % 9;
                    int yPos = currentPos / 9;


                    if( !checkConflict(sudoku, xPos, yPos , number)){


                        sudoku[xPos][yPos] = number;

                        Available.get(currentPos).remove(i);

                        currentPos++;
                    }else{
                        Available.get(currentPos).remove(i);
                    }

                }else{
                    for( int i = 1 ; i <= 9 ; i++ ){
                        Available.get(currentPos).add(i);
                    }
                    currentPos--;
                }
            }


            return sudoku;
        }



        private void clearGrid(int [][] Sudoku){
            Available.clear();

            for( int y =  0; y < 9 ; y++ ){
                for( int x = 0 ; x < 9 ; x++ ){
                    Sudoku[x][y] = -1;
                }
            }

            for( int x = 0 ; x < 81 ; x++ ){
                Available.add(new ArrayList<Integer>());
                for( int i = 1 ; i <= 9 ; i++){
                    Available.get(x).add(i);
                }
            }
        }

        private boolean checkConflict( int[][] sudoku , int xPos, int yPos , final int number){

            if( checkRow(sudoku, xPos, yPos, number) || checkCol(sudoku, xPos, yPos, number) || checkBox(sudoku, xPos, yPos, number) ){
                return true;
            }

            return false;
        }


        private boolean checkRow( int[][] sudoku , int xPos , int yPos , int number ){
            for( int x = xPos - 1; x >= 0 ; x-- ){
                if( number == sudoku[x][yPos]){
                    return true;
                }
            }

            return false;
        }

        private boolean checkCol( int[][] sudoku , int xPos , int yPos , int number ){
            for( int y = yPos - 1; y >= 0 ; y-- ){
                if( number == sudoku[xPos][y] ){
                    return true;
                }
            }

            return false;
        }

        private boolean checkBox( int[][] sudoku , int xPos , int yPos , int number ){
            int xRegion = xPos / 3;
            int yRegion = yPos / 3;

            for( int x = xRegion * 3 ; x < xRegion * 3 + 3 ; x++ ){
                for( int y = yRegion * 3 ; y < yRegion * 3 + 3 ; y++ ){
                    if( ( x != xPos || y != yPos ) && number == sudoku[x][y] ){
                        return true;
                    }
                }
            }

            return false;
        }

        public int[][] removeElements( int[][] Sudoku ){
            int i = 0;

            while( i < 3 ){
                int x = random.nextInt(9);
                int y = random.nextInt(9);

                if( Sudoku[x][y] != 0 ){
                    Sudoku[x][y] = 0;
                    i++;
                }
            }
            return Sudoku;

        }
    }

