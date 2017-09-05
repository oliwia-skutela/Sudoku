package com.example.oliwia.sudoku;

/**
 * Created by Oliwia on 2017-07-04.
 */

public class BoardHelper {

    public String convertToString(String[][] board) {
        String boardString = "";

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (y == 8) {
                    boardString = boardString.concat(String.valueOf(board[x][y]));

                } else {
                    boardString = boardString.concat(String.valueOf(board[x][y]) + ",");
                }
            }
            boardString = boardString.concat(";");
        }

        return boardString;
    }

    public String[][] convertToTable(String boardString) {
        String[] rows = boardString.split(";");
        String[] columns;

        int sizeRow = rows.length;
        //int sizeCol=columns.length;

        String[][] board = new String[sizeRow][sizeRow];

        for (int x = 0; x < 9; x++) {
            columns = rows[x].split(",");
            for (int y = 0; y < 9; y++) {
                board[x][y] = columns[y];
            }

        }
        return board;

    }
}

