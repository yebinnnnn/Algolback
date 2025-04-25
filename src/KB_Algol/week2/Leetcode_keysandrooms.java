package KB_Algol.week2;

import java.util.List;

public class Leetcode_keysandrooms {
    public static boolean[] visited;
    public static List<List<Integer>> rooms;
    static int count=0;
    static int size;
    public static void main(String[] args) {
            size= rooms.size();
            visited= new boolean[size];
            for(int i=0; i<size; i++){
                if(!visited[i]){
                    dfs(i,rooms);
                    count++;
                }
            }
        System.out.println(count == 1);
    }
    public static void dfs(int start, List<List<Integer>> rooms) {
        visited[start] = true;
        for (int i = 0; i <size; i++){
            if(!visited[i]&&rooms.get(start).contains(i)){
                dfs(i,rooms);
            }
        }
    }
}
