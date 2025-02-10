package ReviewNotes;
import java.io.*;
import java.util.*;

public class Back11725_dfs_LIST {//그래프 아니고 트리. 트리 안해봤는데...? 무방향 그래프와는 다른 느낌이다.
    //메모리 초과 문제 --> 크기가 큰 트리엔 배열 대신 어레이 리스트를 쓰자.
    //public static int [][] tree;
    public static List<List<Integer>> tree;
    public static boolean [] check;
    public static StringBuilder sb= new StringBuilder();
    public static int node;
    public static int[] answer;

    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        node= Integer.parseInt(bf.readLine());
        tree= new ArrayList<>();
        check=new boolean [node+1];
        answer= new int[node+1];

        int n,m;
        //트리 초기화 추가
        for (int i = 0; i <= node; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i=0; i<node-1; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            tree.get(n).add(m);
            tree.get(m).add(n);
        }

        dfs(1,0);
        for(int j=2; j<=node; j++){
            sb.append(answer[j]).append("\n");
        }
        System.out.println(sb);
    }
    //그냥 dfs 돌아주며 한번에 처리.
    public static void dfs(int child, int parent) {
        answer[child] = parent; // 부모 저장

        for (int next:tree.get(child)) {
            if (next != parent){ // 부모 노드로 되돌아가지 않도록 방지
                dfs(next, child);
            }
        }
    }
}
