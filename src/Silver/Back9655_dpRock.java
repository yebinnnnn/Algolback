package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Back9655_dpRock {
    public static boolean[] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int number= Integer.parseInt(bf.readLine());
        dp=new boolean[number+3];

        dp[1]=true; //현재 턴인 사람이 이긴다.
        //dp[i]=dp[i-1], dp[i-3]둘 중 하나의 값이 true 면 false,(현재 사람이 짐(상근 짐)) false 면 true.(현재 사람이 이김 상근 이김)
        dp[2]=false;
        dp[3]=true;

        for(int i=4; i<=number; i++){
            dp[i]=!(dp[i-1]&&dp[i-3]); //최선을 다함 -> 최대한 false 인 값 유도
        }
        if(dp[number]){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}
