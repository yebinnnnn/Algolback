package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back2606_BasicDFS { //그래프 이론. 노드 따로 만들어야 할듯
    static boolean[] check;
    static int [][] arr;
    static int count=0; // 답이 될 값
    static int node, line; // 관계에 관한것
    static Queue<Integer> q= new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine()); //컴퓨터의 수 (그래프의 노드)
        line = Integer.parseInt(br.readLine()); //라인 -> 관계 줄에 해당하는것.
        arr=new int[node+1][node+1]; //왜 +1 씩이지..??
        check=new boolean[node+1]; //이건 왜?? -> dfs search 체크 용이다. (이 노드뿌리 탐색이 끝났나 확인)

        for(int i=0; i<line; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=arr[b][a]=1; //교차로 체크 해주기
        }
        dfs(1); //dfs 함수 구현
        System.out.println(count-1);
    }

    public static void dfs(int start){
        check[start]=true; //스타트할 노드 체크
        count++;

        for(int i=0; i<=node; i++){
            if(arr[start][i]==1 &&!check[i]){ //1이지만 아직 false 인 노드 체크
                dfs(i); //걔도 다시 돌려준다.
            }
        } //[start] 에서 걸린애들 다 체크 됐으면 탈출 가능.
    }
}
