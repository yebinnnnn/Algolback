package Silver;
import java.io.*;
import java.util.*;

public class Back9465_dpSticker {
    public static int [][] stick;
    public static int [][] dp; //스티커 최대의 값이 담길 배열

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int cases=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        while(cases-->0){
            int column=Integer.parseInt(bf.readLine());
            stick= new int[2][column+1];
            dp= new int[2][column+1];

            st=new StringTokenizer(bf.readLine());

            for(int i=1; i<=column; i++){
                stick[0][i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(bf.readLine());
            for(int i=1; i<=column; i++){
                stick[1][i]=Integer.parseInt(st.nextToken());
            }
            //두개까지 배열에 입력완료
            sb.append(foundscore(column)).append("\n");
        }
        System.out.println(sb);
    }

    public static int foundscore(int column){
        dp[0][1]=stick[0][1];
        dp[1][1]=stick[1][1];
        for(int j=2; j<=column; j++){
            dp[0][j]=Math.max(dp[1][j-2],dp[1][j-1])+stick[0][j];
            dp[1][j]=Math.max(dp[0][j-2],dp[0][j-1])+stick[1][j];
        }
        return Math.max(dp[0][column],dp[1][column]);
    }
}
