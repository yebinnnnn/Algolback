package Silver;
import java.io.*;
import java.util.*;

public class Back14940_BFS {
    public static int sero;
    public static int garo;
    public static int[][] map;
    public static boolean [][]check;
    public static int startX;
    public static int startY;

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(bf.readLine());
        sero=Integer.parseInt(st.nextToken());
        garo=Integer.parseInt(st.nextToken());
        check=new boolean[sero][garo];
        map= new int[sero][garo];
        //지도 입력
        for(int i=0 ; i<sero; i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0; j<garo; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    startX=i;
                    startY=j;
                }
                check[i][j]=false; //체크초기화
            }
        }
        map[startX][startY]=0;
        bfs(startX,startY);

        for(int i=0;i<sero; i++){
            for(int j=0;j<garo; j++){
                if(!check[i][j] && map[i][j]!=0){
                    map[i][j]=-1;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(int startX,int startY){
        Queue<Integer> Xq= new LinkedList<>();
        Queue<Integer> Yq= new LinkedList<>();
        Xq.add(startX);
        Yq.add(startY);
        check[startX][startY]=true;

        int count=1;
        int [] X = {0,0,-1,1};
        int [] Y = {1,-1,0,0};

        while(!Xq.isEmpty()){
            startX=Xq.poll();
            startY=Yq.poll();

            for (int i = 0; i < 4; i++){
                if(startX+X[i]>=0 && startY+Y[i]>=0 &&startX+X[i]<sero && startY+Y[i]<garo){
                    if (!check[startX+X[i]][startY+Y[i]] && map[startX+X[i]][startY + Y[i]] == 1) {
                        check[startX + X[i]][startY + Y[i]] = true;
                        Xq.add(startX + X[i]);
                        Yq.add(startY + Y[i]);
                        map[startX + X[i]][startY + Y[i]]= map[startX][startY]+1;
                    } else if(map[startX + X[i]][startY + Y[i]] == 0) {
                        map[startX + X[i]][startY + Y[i]] = 0;
                    }
                }
            }
        }
    }
}
