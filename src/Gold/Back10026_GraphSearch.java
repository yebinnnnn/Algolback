package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

//정상인은 빨파초 , 적록색약인은 빨초를 같이 보고 파랑을 따로본다. 두가지만 구분가능
//순서대로 출력하면 된다.
public class Back10026_GraphSearch {
    public static String[][] graph;
    public static boolean [][]check;
    public static int[] Xgo={0,0,-1,1};
    public static int[] Ygo={-1,1,0,0};
    public static int N;
    public static int blindcount=0;

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(bf.readLine());
        graph= new String[N][N];
        check= new boolean[N][N];
        for(int i=0; i<N; i++){
            String thisSt=bf.readLine();
            //RGB 입력
            for(int j=0; j<N; j++){
                graph[i][j]=String.valueOf(thisSt.charAt(j));
            }
            //그래프 입력
        }
        int count=0;
        for(int j=0; j<N; j++){ //좌표 하나씩 순서대로 췍 -> 구역 카운트를 어디에 하지?
            for(int k=0; k<N; k++){
                if (!check[j][k]){
                    dfs(j,k);
                    count++;
                }
            }
        }
        //여기까지 일반인 RGB 는 완성.
        check=new boolean[N][N];
        //초기화
        blindcount=0;
        //blindcount의 search 조건 : 빨강 초록을 같이 봐야함
        for(int j=0; j<N; j++){
            for(int k=0; k<N; k++){
                if (!check[j][k]){
                    blinddfs(j,k);
                    blindcount++;
                }
            }
        }
        System.out.println(count+" "+blindcount);
    }
    //나는야 DFS성애자...
    public static void dfs(int X, int Y){
        check[X][Y]=true;
        for(int i=0; i<4; i++){
            //indexOut 방지
            if (X + Xgo[i] >= 0 && Y + Ygo[i] >= 0 && X + Xgo[i] < N && Y + Ygo[i] < N) {
                if (!check[X + Xgo[i]][Y + Ygo[i]] && graph[X + Xgo[i]][Y + Ygo[i]].equals(graph[X][Y])){
                    dfs(X + Xgo[i], Y + Ygo[i]);
                }
            }
        }
    }
    //적록색맹 용 dfs...
    public static void blinddfs(int X, int Y){
        check[X][Y]=true;
        for(int i=0; i<4; i++){
            if (X + Xgo[i] >= 0 && Y + Ygo[i] >= 0 && X + Xgo[i] < N && Y + Ygo[i] < N) {
                if (!check[X + Xgo[i]][Y + Ygo[i]] &&!graph[X][Y].equals("B")){
                    if(!graph[X+Xgo[i]][Y+Ygo[i]].equals("B")){
                        blinddfs(X + Xgo[i], Y + Ygo[i]);
                    }
                }else if(!check[X + Xgo[i]][Y + Ygo[i]]&&graph[X][Y].equals("B")){
                    if(graph[X + Xgo[i]][Y + Ygo[i]].equals("B")){
                        blinddfs(X + Xgo[i], Y + Ygo[i]);
                    }
                }
            }
        }
    }
}
