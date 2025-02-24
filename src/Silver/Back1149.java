package Silver;

import java.util.*;
import java.io.*;

public class Back1149 { //dp. 스티커 문제랑 비슷하다.
    public static int [][] cost;
    public static int[] indexs;
    public static int[][] dp; //dp 용 배열


    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int house= Integer.parseInt(bf.readLine());
        cost=new int[house+1][3];
        indexs=new int[house+1];
        indexs[0]=4; //초깃값 세팅. (절대 4값 인덱스는 나오지 않음.)
        dp=new int[house+1][3];
        dp[0][0]=0;

        StringTokenizer st;
        for(int i=1; i<=house; i++){
            st= new StringTokenizer(bf.readLine());
            cost[i][0]=Integer.parseInt(st.nextToken()); //비용 받음.
            cost[i][1]=Integer.parseInt(st.nextToken());
            cost[i][2]=Integer.parseInt(st.nextToken());
        }
        System.out.println(colorTake(house));
    }

    public static int colorTake(int num) {//num=몇번째 집인지를 나타냄
        dp[1][0]=cost[1][0];
        dp[1][1]=cost[1][1];
        dp[1][2]=cost[1][2];
        for(int i=2; i<=num; i++){//dp[0]=0.
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+cost[i][0];
            dp[i][1]=Math.min(dp[i-1][2],dp[i-1][0])+cost[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+cost[i][2];
        }
        return Math.min(Math.min(dp[num][0], dp[num][1]), dp[num][2]);
    }
}
