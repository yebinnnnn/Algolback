package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1149_DPReview {
    public static int[][] fee;
    public static int[][] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int hn=Integer.parseInt(bf.readLine());//집의 갯수
        fee= new int[hn][3];//가격 저장할 예정
        dp=new int[hn][3];
        for(int i=0;i<hn;i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            for(int j=0;j<3;j++){
                fee[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=fee[0][0];
        dp[0][1]=fee[0][1];
        dp[0][2]=fee[0][2];

        for(int i=1; i<hn; i++){
            dp[i][0]=fee[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=fee[i][1]+Math.min(dp[i-1][2],dp[i-1][0]);
            dp[i][2]=fee[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
        }
        int answer=Math.min(dp[hn-1][0],Math.min(dp[hn-1][1],dp[hn-1][2]));
        System.out.println(answer);
    }
}
