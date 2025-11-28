import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] count = new int[1]; // to store number of components
        dfs(0, -1, graph, values, k, count);
        return count[0];
    }

    private long dfs(int node, int parent, List<List<Integer>> graph, int[] values, int k, int[] count) {
        long sum = values[node];
        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            sum += dfs(nei, node, graph, values, k, count);
        }
        if (sum % k == 0) {
            count[0]++; // this subtree can be a component
            return 0;   // cut here, don't pass sum upward
        }
        return sum;
    }
}