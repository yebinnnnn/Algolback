package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back1260 {
    static int node;
    static int line;
    static boolean[] check;
    static boolean[] checkbfs;
    static int[][] arr;
    static StringBuilder sbdfs= new StringBuilder();
    static StringBuilder sbbfs=new StringBuilder();
    public static Queue<Integer> q= new LinkedList<>(); //bfs 를 위한놈

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        node=Integer.parseInt(st.nextToken());
        line=Integer.parseInt(st.nextToken());
        int startpoint=Integer.parseInt(st.nextToken());

        //그래프 형태 구현
        arr= new int[node+1][node+1];
        check=new boolean[node+1];
        checkbfs=new boolean[node+1];

        for(int i=0; i<line; i++){
            StringTokenizer st2= new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st2.nextToken());
            int b=Integer.parseInt(st2.nextToken());
            arr[a][b]=arr[b][a]=1;
        }

        dfs(startpoint);
        bfs(startpoint);

        System.out.println(sbdfs.toString());
        System.out.println(sbbfs.toString());
    }

    public static void dfs(int start){
        sbdfs.append(start).append(" ");
        check[start]=true;

        for(int i=0; i<=node; i++){
            if(arr[start][i]==1&&!check[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int start){//bfs 는 "start"에 달린 애들부터 모두 탐색해야 한다.
        Queue<Integer> q = new LinkedList<>();// 큐 여기서 초기화
        q.offer(start);//큐 할당을 시작때 하는구나,,,;;;
        checkbfs[start] = true;
        sbbfs.append(start).append(" ");

        while (!q.isEmpty()) { //함수를 재귀적으로 사용하진 않네,,,,???
            int current=q.poll(); //현재 노드 인식
            for (int i=0;i<arr[current].length; i++){ //for문 돌리는 건 내가 생각한게 맞고
                if (arr[current][i]==1&&!checkbfs[i]){
                    q.offer(i);
                    checkbfs[i]=true;
                    sbbfs.append(i).append(" ");
                }
            }
        }
    }
}
