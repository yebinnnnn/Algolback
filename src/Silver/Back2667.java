package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back2667 { //문자열다루기도 일부 포함, 오름차순 정렬 주의!!! 복합
    public static int[][] map;
    public static boolean[][] check;
    public static int house;
    public static ArrayList<Integer> answer=new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bf.readLine());
        map= new int[num][num];
        check= new boolean[num][num];

        //map에 미로 입력하기
        boolean notyet=true;
        int startX=0;
        int startY=0;

        for(int i=0; i<num; i++){
            String input;
            input=bf.readLine();
            for(int j=0; j<num; j++){
                map[i][j]=Integer.parseInt(String.valueOf(input.charAt(j))); //이걸 제대루 못해서;;;
                if(map[i][j]==1&&notyet){
                    startX=i;
                    startY=j;
                    notyet=false;
                }
                check[i][j]=false; //초기화
            }
        }

        int cluster=0;
        int k=0;

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if(!check[i][j]&&map[i][j]==1){
                    house=1;
                    answer.add(dfs(i,j));
                    cluster++;
                }
            }
        }
        answer.sort(Integer::compareTo);
        System.out.println(cluster);
        for(int init: answer){
            System.out.println(init);
        }
    }

    public static int dfs(int startX, int startY){
        int[] X={-1,1,0,0};
        int[] Y={0,0,-1,1};
        check[startX][startY]=true;

        for(int i=0; i<4; i++){
            if(startX+X[i]>=0 &&startX+X[i]<map[0].length&&startY+Y[i]>=0 &&startY+Y[i]<map[0].length) {
                if (!check[startX+X[i]][startY+Y[i]] && map[startX + X[i]][startY + Y[i]] == 1) {
                    dfs(startX + X[i], startY + Y[i]);
                    house++;
                }
            }
        }
        return house;
    }
}
