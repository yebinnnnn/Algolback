package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//계단을 두번연속 밟을 순 없음
public class Back2579_DPreview {
    public static int[] dp;
    public static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int stair=Integer.parseInt(bf.readLine());
        stairs=new int[stair+1]; //계단 수 만큼
        for(int i=1;i<=stair;i++){
            stairs[i]=Integer.parseInt(bf.readLine());
        }//계단 점수들 저장
        dp=new int[stair+1]; //dp 배열 저장
        dp[0]=0;
        dpstairs(stair);
        System.out.println(dp[stair]);
    }
    public static void dpstairs(int stair){
        dp[1]=stairs[0]+stairs[1];
        if(stair>1){//대충...ㅋ
            dp[2]=stairs[2]+dp[1];
        }
        for(int i=3;i<=stair;i++){
            //dp의 값 -> 현재 해당 인덱스의 계단에 올라와있을때
            dp[i]=stairs[i]+Math.max(stairs[i-1]+dp[i-3],dp[i-2]);
        }
    }
}
