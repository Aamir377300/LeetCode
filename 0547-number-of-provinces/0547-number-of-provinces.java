// here is given the matrix which tell which is connected to which one.

class Solution {

    // DFS function to visit all connected cities
    public void dfs(int start, int[][] isConnected, boolean[] visited) {
        visited[start] = true; // mark current city as visited

        // explore all possible neighboring cities
        for (int next = 0; next < isConnected.length; next++) {

            // if city is connected and not visited → go deeper
            if (isConnected[start][next] == 1 && !visited[next]) {
                dfs(next, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;   // number of cities
        boolean[] visited = new boolean[n];
        int provinces = 0;            // count of connected components

        // check each city
        for (int i = 0; i < n; i++) {

            // if city is not visited → it starts a new province
            if (!visited[i]) {
                provinces++;          // found a new province
                dfs(i, isConnected, visited); // visit all cities in this province
            }
        }

        return provinces;
    }
}