package recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N_Queens {
    /*

            // THIS METHOD TAKES A LOT OF TIME TO TRAVERSE THROUGH THE BOARD TO CHECK WHETHER THERE IS A Q OR NOT.

    public boolean isSafe(int row, int col, char[][] board, int n){
        int dupRow = row;
        int dupCol = col;

        // UPPER DIAGONAL CHECK
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // LOWER DIAGONAL CHECK
        row = dupRow;
        col = dupCol;
        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        // ENTIRE ROW ON LEFT SIDE
        row= dupRow;
        col = dupCol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        return true;
    }

    public void placeNQueens(int col, char[][] board, List<List<String>> ans, int n){
        if(col == n){
            // CONVERTING BOARD OF char[][] TO List<String> TYPE
            List<String> ansBoard = new ArrayList<>();
            for(char[] row : board){
                ansBoard.add(new String(row));
            }
            // ADDING THE ANSBOARD TO ANS
            ans.add(ansBoard);
            return;
        }
        for(int row = 0; row < n; row++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q';
                placeNQueens(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> NQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i],'.'); // TO FILL EACH ROW OF BOARD WITH '.'
        }
        placeNQueens(0, board, ans, n);
        return ans;
    }

    */

    public void placeNQueens(int col, char[][] board, List<List<String>> ans, int n, boolean[] leftRow, boolean[] upperDiagonal, boolean[] lowerDiagonal){
        if(col == n){
            // CONVERTING BOARD OF char[][] TO List<String> TYPE
            List<String> ansBoard = new ArrayList<>();
            for(char[] row : board){
                ansBoard.add(new String(row));
            }
            // ADDING THE ANSBOARD TO ANS
            ans.add(ansBoard);
            return;
        }
        for(int row = 0; row < n; row++){
            if(!leftRow[row] && !upperDiagonal[n-1 + col - row] && !lowerDiagonal[row + col]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                upperDiagonal[n - 1 + col - row] = true;
                lowerDiagonal[row + col] = true;

                placeNQueens(col + 1, board, ans, n, leftRow, upperDiagonal, lowerDiagonal);

                board[row][col] = '.';
                leftRow[row] = false;
                upperDiagonal[n - 1 + col - row] = false;
                lowerDiagonal[row + col] = false;
            }
        }
    }

    public List<List<String>> NQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i],'.'); // TO FILL EACH ROW OF BOARD WITH '.'
        }

        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];

        placeNQueens(0, board, ans, n, leftRow, upperDiagonal, lowerDiagonal);
        return ans;
    }
}
