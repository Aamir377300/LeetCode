class Solution {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.'){

                    for(char c = '1'; c <= '9'; c++){

                        if(isSafe(board, i, j, c)){

                            board[i][j] = c;

                            if(backtracking(board))
                                return true;

                            board[i][j] = '.'; // backtrack
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, char c){

        for(int i = 0; i < 9; i++){

            // check row
            if(board[row][i] == c)
                return false;

            // check column
            if(board[i][col] == c)
                return false;

            // check 3x3 grid
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c)
                return false;
        }

        return true;
    }
}