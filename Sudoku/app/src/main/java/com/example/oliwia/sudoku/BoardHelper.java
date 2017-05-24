package com.example.oliwia.sudoku;

/**
 * Created by Oliwia on 2017-05-24.
 */

public class BoardHelper {

    public String convertToString(int[][] board) {
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

    public int[][] convertToInt(String boardString) {
        String[] rows = boardString.split(";");
        String[] columns;

        int sizeRow = rows.length;
        //int sizeCol=columns.length;

        int[][] board = new int[sizeRow][sizeRow];

        for (int x = 0; x < 9; x++) {
            columns = rows[x].split(",");
            for (int y = 0; y < 9; y++) {
                board[x][y] = Integer.parseInt(columns[y]);
            }

        }
        return board;

    }
}
