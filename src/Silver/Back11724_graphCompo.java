package Silver;
import java.io.*;
import java.util.*;
public class Back11724_graphCompo {
    public static boolean [] check; //방문 표시. 초기값 false
    public static boolean[][] node; //노드 관계 배열
    public static int jeong;
    public static int component;

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(bf.readLine());
        jeong= Integer.parseInt(st.nextToken()); //정점의 수 (노드) 1000개까지도 주어진다.
        int gan=Integer.parseInt(st.nextToken()); //간선의 수 (연결 선)
        node=new boolean[jeong+1][jeong+1];
        check=new boolean[jeong+1];

        for(int i=0; i<gan; i++){
            st= new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a][b]=true; //무방향 쌍방으로 연결 그래프.
            node[b][a]=true;
        }
        component=0;
        for(int k=jeong; k>0; k--){
            System.out.println("지금들어온"+k);
            if(!check[k]){
                dfs(k);//노드의 개수전달 (연결이 안되어 있을수도 있음)
                component++;
            }
        }
        System.out.println("컴포넌트의 수: "+component);
    }

    public static void dfs(int number){
        int i=jeong;
        check[number]=true;
        System.out.println(number);

        while(i-->0){
            if (!check[i]&&node[number][i]){//방문 하지 않았고, 연결되어 있는게 맞는 노드
                dfs(i);
            }
        }
    }
}
