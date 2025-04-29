package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

//다 익은걸 어케 확인하지...
public class Back7576_BFS {
    public static int[][] tomato;
    public static List<List<Integer>> rot=new ArrayList<>();
    public static boolean[][] check;
    public static int N,M;
    public static int  day=-1;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        tomato=new int[M][N];
        check=new boolean[M][N];
        for(int i=0; i<M; i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                tomato[i][j]=Integer.parseInt(st.nextToken());
            }
        }//배정 후
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(tomato[i][j]==1){
                    //익은 토마토면 bfs 시작.
                    bfs(j,i);
                }
            }
        }
        if(day==-1){
            System.out.println("-1");
        }else{
            System.out.println(day+1);
        }
    }
    public static void bfs(int X, int Y){
        int[] Xgo={-1,1,0,0};
        int[] Ygo={1,-1,0,0};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{Y,X});
        check[Y][X]=true;
        while(!q.isEmpty()){
            int[] current=q.poll();
            X=current[1];
            Y=current[0];
            for(int i=0; i<4; i++){
                int nx=X+Xgo[i];
                int ny=Y+Ygo[i];
                if(nx>=0&&ny>=0&&nx<X&&ny<Y&&!check[ny][nx]){
                    //0아니면 1일때만 이동이 가능
                    if(tomato[Y][X]==0||tomato[Y][X]==1){
                        check[ny][nx]=true;
                        q.add(new int[]{ny,nx});
                        System.out.println("들어옴");
                    }
                }
            }
            //여기서 카운트 하면 bfs 들어온 토마토 개수 샘.
        }
    }
}
