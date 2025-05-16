package recursion.hard;

/*  Write a program to solve a Sudoku puzzle by filling the empty cells.
    A sudoku solution must satisfy all the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.

    Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]

    Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
*/

public class SudokuSolver {

    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c) return false;

            if(board[i][col] == c) return false;

            if(board[3 * (row/3) + i / 3][3 * (col/3) + i % 3] == c) return false;
        }
        return true;
    }

    public boolean solveSudokuBoard(char[][] board){
        // THE BELOW TWO LINES ARE LOOPS TO ITERATE IN THE SUDOKU WHICH IS KIND OF A 2-D MATRIX.
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                // CHECKS WHETHER THERE IS EMPTY OR NOT
                if(board[i][j] == '.'){

                    // WHEN FOUND EMPTY CHECK WHETHER ANY NUMBER FROM 1 TO 9 IS VALID TO BE PUT THERE OR NOT
                    for(char c = '1'; c <= '9'; c++){ // here it will be <= 9 not < 9

                        // IF TRUE THEN PUT THAT NUMBER IN THAT PLACE
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;

                            //  AND RECURSE IT FOR NEXT BLANK SPACE
                            if(solveSudokuBoard(board)) return true; // IF A RECURSION RETURN TRUE THAT MEANS THE NUMBER HAS BEEN PLACED IN THE EXACT POSITION ACCORDING TO RULES AND THE SUDOKU IS PERFECTLY COMPLETED

                            // IF NOT TRUE THEN REMOVE THE LAST PUT ELEMENT FROM THAT POSITION
                            else board[i][j] = '.';
                        }
                    }
                    // THIS MEANS THAT NONE OF THE NUMBERS FROM 1 TO 9 DOES NOT FIT ACCORDING TO THE RULES
                    return false;
                }
            }
        }
        // THIS RETURN TRUE MEANS THERE WAS NO EMPTY SPACE IN THE SUDOKU SINE THE BEGINNING
        return true;
    }

    public void sudokuSolver(char[][] board){
        solveSudokuBoard(board);
    }

}
