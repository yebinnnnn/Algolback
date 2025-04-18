package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

//새마을금고 선풍기 문제랑 비슷한 백트래킹문제!!!
public class Back14889_BackTracking { //브루트포스, 백트래킹(퇴각검색. 트리형태로 탐색이 가능하다)
    public static int[][] map;
    public static boolean[] visited;
    public static int min= Integer.MAX_VALUE;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(bf.readLine());
        map=new int[N][N];
        visited=new boolean[N];
        StringTokenizer st;

        for(int i=0;i<N;i++){ //입력하면서 비교?
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        Tracking(0,0);
        System.out.println(min);
    }

    //짝수로 분배시키는 모든 경우의 수를 알아야함.
    //DFS 응용으로 풀어야할거같은데,,,
    public static void Tracking(int depth, int indx){
        if(depth==N/2){
            int start=0, link=0;

            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    if(visited[i]&&visited[j]){
                        start+=map[i][j];
                        start+=map[j][i];
                    }
                    else if(!visited[i]&&!visited[j]){
                        link+=map[i][j];
                        link+=map[j][i];
                    }
                }
            }
            int minus=Math.abs(link-start);

            if(minus==0){
                System.out.println(minus);
                System.exit(0);
            }

            min=Math.min(minus,min);
        }
        for(int i=indx; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                Tracking(depth+1, i+1);
                visited[i]=false;
            }
        }
    }
}
