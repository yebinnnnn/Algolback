package ReviewNotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//퇴사 2
public class Back15486_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int day=Integer.parseInt(bf.readLine());
        int[][] cost= new int[day+1][2]; //첫날 부터 막날까지 소요시간과 돈
        int[] dp= new int[day+2]; //일단 하나로 해봄
        for(int i=1; i<=day; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            cost[i][0]=Integer.parseInt(st.nextToken());
            cost[i][1]=Integer.parseInt(st.nextToken());
        }
        //할당 끝
        for(int i=1; i<=day; i++){
            //현재까지 최대 것 적용
            dp[i]=Math.max(dp[i-1],dp[i]);
            int end=i+cost[i][0];//end 가 현재 상담 택했을때 끝나는 담날
            if(end<=day+1){//주어진 날보다 작은지만 확인
                dp[end]=Math.max(dp[end],dp[i]+cost[i][1]);
            }
        }
        System.out.println(Math.max(dp[day], dp[day+1]));
    }
}
