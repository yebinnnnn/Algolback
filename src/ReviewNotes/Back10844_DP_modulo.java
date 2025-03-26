package ReviewNotes;

import java.io.IOException;
import java.io.*;
import java.util.Arrays;

//이중 배열 DP!!!
public class Back10844_DP_modulo {//DP 쉬운계단수 -> 1씩만 차이나는 계단수
    //결국은 끝자리수가 뭔지 알아야 다음 수 판별
    //이제 점점 두자리 dp가 나오는구나~
    static long[][] dp;
    static long mod=1000000000;
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp=new long[n+1][10];
        int count=0;

        //최초 한자리 수인경우
        for(int i=1;i<10;i++) {
            dp[1][i]=1;
        }

        for(int i=2;i<=n;i++) { //두번째 자리수부터 탐색
            for(int j=0;j<10; j++){ //각 끝자리 탐색
                if(j==0){ //끝자리0이면 1칸 이었던 애 갯수 그대로
                    dp[i][j]=dp[i-1][1]%mod;
                }else if(j==9) {
                    //9인경우는 8의것에서만 발전 가능
                    dp[i][j]=dp[i-1][8]%mod;
                }else { //보통의 경우는 이전 경우의 수 더하기
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
                }
            }
        }
        System.out.println(Arrays.stream(dp[n]).sum()%mod);

    }
}
