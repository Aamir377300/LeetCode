// you only allow to move the vertical and horizontal of the particular element of the matrix

// https://drive.google.com/file/d/1G0xOmKh6HIn6fSvYfL4PZET4Vd_2k4MK/view?usp=sharing

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
    // grid.length is define as the no of the rows
        for (int i = 0; i < grid.length; i++){
            // grid.length[0] is define as the no of the coloumns
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == '0') {
            return;
        }
        // we do not create a visited matrix or list whoever we moved we just replace them with the 0(here 1 is replace by the 0)
        grid[i][j] = '0'; // Mark the cell as visited

        // Explore all four directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}