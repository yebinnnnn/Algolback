package KB_Algol.week2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public void bfs(List<List<Integer>> graph, int startVertex ){
        Queue<Integer> queue = new LinkedList<Integer>();
        final int N=graph.size();
        boolean[] visited = new boolean[N];
        queue.add(startVertex);
        visited[startVertex] = true;
        while(!queue.isEmpty()){
            int curVertex=queue.poll();
            for(int next: graph.get(curVertex)){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }
    }
    public void solve(List<List<Integer>> graph){
        bfs(graph,0);
    }
}


