package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back11727 {
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp=new long[n+1];
        System.out.println(foundsquare(n));
    }
    public static long foundsquare(int n) {
        dp[0]=0;
        dp[1]=1;
        dp[2]=3;
        for(int i=3; i<=n; i++){
            dp[i]=dp[i-1]%10007+dp[i-2]*2%10007;
        }
        return dp[n]%10007;
    }
}
