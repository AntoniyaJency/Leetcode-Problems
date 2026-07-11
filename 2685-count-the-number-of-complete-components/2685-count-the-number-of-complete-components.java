import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i, adj, visited);
                int nodes = res[0];
                int edgesCount = res[1];

                // since each edge counted twice
                edgesCount /= 2;

                if (edgesCount == nodes * (nodes - 1) / 2)
                    count++;
            }
        }
        return count;
    }

    private int[] dfs(int node, List<Integer>[] adj, boolean[] visited) {
        visited[node] = true;
        int nodes = 1;
        int edges = adj[node].size();

        for (int nei : adj[node]) {
            if (!visited[nei]) {
                int[] res = dfs(nei, adj, visited);
                nodes += res[0];
                edges += res[1];
            }
        }
        return new int[]{nodes, edges};
    }
}