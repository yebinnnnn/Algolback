package Silver;
import java.util.*;
import java.io.*;

public class Back1697_BFS {
    public static boolean[] check;
    public static int [][] line;
    public static int searchCount;
    public static int[] time= new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int start= Integer.parseInt(st.nextToken());
        int sister= Integer.parseInt(st.nextToken());
        check=new boolean[100001];

        searchCount=1;
        int answer=bfs(start,sister);
        System.out.println(answer);

    }
    public static int bfs(int start, int sister){
        Queue<Integer> q= new LinkedList<>();
        check[start]=true;
        q.add(start);
        time[start]=0;

        while(!q.isEmpty()){
            int current=q.poll();//내가 현재 있는 노드.
            if(current==sister){
                return time[current];
            }
            for (int next : new int[]{current-1,current+ 1,current*2}) {
                if (next >= 0 && next <= 100000 && !check[next]) {//예외처리, 방문
                    check[next] = true; //next 는 current 에서 이동하는 노드들
                    q.add(next);
                    time[next]=time[current]+1;
                }
            }
        }
        return -1;
    }
}
