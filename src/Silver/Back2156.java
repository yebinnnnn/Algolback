package Silver;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Back2156 {//스멀 스멀 올라오는 DP의 냄새
    public static int [] wine;
    public static int [] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int jan=Integer.parseInt(bf.readLine());
        //와인잔 입력
        dp=new int[jan+2];
        wine= new int[jan+2];
        for(int i=0; i<jan; i++){
            wine[i]=Integer.parseInt(bf.readLine());
        }
        dp[0]=wine[0];
        dp[1]=wine[1]+wine[0];
        dp[2]=Math.max(dp[1],Math.max(dp[0]+wine[2],wine[1]+wine[2]));
        if(jan>=3) {
            for (int i = 3; i < jan; i++) {
                //이 잔을 선택한 경우와 아닌 경우
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
            }
        }
        System.out.println(dp[jan-1]);

    }
}
