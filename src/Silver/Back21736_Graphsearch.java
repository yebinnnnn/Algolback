package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

//NxM 크기. 상하좌우로만 이동가능하다. 또 좌표 배열 만들어야겠군
public class Back21736_Graphsearch {
    public static String[][] map;
    public static boolean[][] checking;
    //이동좌표
    public static int[] Xgo={0,0,-1,1};
    public static int[] Ygo={1,-1,0,0};
    public static int hereN=0, hereM=0; //시작지점 지정용
    public static int count;//만나는 친구 카운트용
    static int N;
    static int M;
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken()); //가로 세로 받음
        map=new String[N][M]; //가로 세로.
        checking=new boolean[N][M];
        for(int i=0;i<N;i++){
            String thisline=bf.readLine();
            for(int j=0;j<M;j++){
                map[i][j]= String.valueOf(thisline.charAt(j));
                if(map[i][j].equals("I")){
                    hereN=i;
                    hereM=j;
                }
            }
        }
        //지도 배정.
        dfs(hereN,hereM);//시작지점 y x 좌표
        if(count==0){
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }
    public static void dfs(int Y, int X){
        checking[Y][X]=true;

        for(int i=0; i<4; i++){
                if(Y+Ygo[i]>=0&&X+Xgo[i]>=0&&Y+Ygo[i]<N&&X+Xgo[i]<M) {
                    if (!checking[Y + Ygo[i]][X + Xgo[i]] && map[Y + Ygo[i]][X + Xgo[i]].equals("O")) {
                        dfs(Y + Ygo[i], X + Xgo[i]);
                    } else if (!checking[Y + Ygo[i]][X + Xgo[i]] && map[Y + Ygo[i]][X + Xgo[i]].equals("P")) {
                        dfs(Y + Ygo[i], X + Xgo[i]);
                        count++;
                    }
                }
        }
    }
}
