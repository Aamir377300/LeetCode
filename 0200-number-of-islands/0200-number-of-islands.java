class Solution {

    private void dfs(int i, int j, char[][] grid, int[][] vis, int m, int n) {
        // boundary + visited + water check
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] == 1 || grid[i][j] == '0') {
            return;
        }

        vis[i][j] = 1;

        // explore in all 4 directions
        dfs(i + 1, j, grid, vis, m, n);
        dfs(i - 1, j, grid, vis, m, n);
        dfs(i, j + 1, grid, vis, m, n);
        dfs(i, j - 1, grid, vis, m, n);
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If it's land and not visited
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, vis, m, n);
                    count++;   // one island completed
                }
            }
        }

        return count;
    }
}