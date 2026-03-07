class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // creating a board with only has the '.' and whenever we get the coniguration of the placing the queen then we change the particular to the 'Q'
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
      List<List<String>> result = new ArrayList<>();
      helper(board, 0, result); 
    return result;
    }

    public void helper(char[][] board, int row, List<List<String>> res){
        int n = board.length;
        List<String> l = new ArrayList<>();

        // base condition
        if(row == n){// hame mil gaya apne chess configuation which follow the rule so what we have to convert/construct in the List<List<String>> because we have to answer this only 

            for(int i =0; i<n; i++){
                String str = "";
                for(int j=0; j<n; j++){
                    str = str + board[i][j];
                }
                l.add(str);
            }
            res.add(l);
            return;
        }

        // fix the row
        for(int j=0; j<n; j++){
            if(isSafe(board, row,j)){
                board[row][j] = 'Q';
                helper(board, row+1, res); // recurrsion
                board[row][j] = '.'; // backtracking
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // check row(row is fix and column is varying)
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q')
                return false;
        }

        // check col(col is fix and row is varying)
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // check NE
        int i = row;
        int j = col;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        // check SE
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }

        i = row;
        j = col;
        // check SE
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }

        i = row;
        j = col;
        //check NW
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        return true; // agar kuch nahi hua to return true

    }
}