package KB_Algol.week2;

import java.util.List;

public class DFS {
    public void dfs(List<List<Integer>> graph, boolean[] visited, int curVertex){
        visited[curVertex] = true;
        for (int nextVertex : graph.get(curVertex)) {
            if (!visited[nextVertex]) {
                dfs(graph, visited, nextVertex);
            }
        }
    }

    public void solve(List<List<Integer>> graph) {
        final int N = graph.size();
        boolean[] visited = new boolean[N];
        dfs(graph, visited, 0);
    }
}
