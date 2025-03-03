package Silver;

import java.io.*;
import java.util.*;

public class Back1932_DP {
    public static int[][] arrays;
    public static int[][] dp;

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int stairs=Integer.parseInt(bf.readLine());
        arrays=new int[stairs][stairs];
        dp=new int[stairs][stairs];

        //배열 입력
        for(int i=0; i<stairs; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<i+1; j++){
                arrays[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=arrays[0][0];

        for(int i=1; i<stairs; i++){
            for(int j=0; j<i+1; j++){
                if(j==i){
                    dp[i][j]=dp[i-1][j-1]+arrays[i][j];
                }
                else if(j==0){
                    dp[i][j]=dp[i-1][j]+arrays[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arrays[i][j];
                }
            }
        }
        OptionalInt answer=Arrays.stream(dp[stairs-1]).max();
        System.out.println(answer.getAsInt());
    }
}
