package ReviewNotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back12865_DPKnapsack {//물품의 수는 100, 무게는 십만, 가치는 천
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int num = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());//버틸 수 있는 무게
        int[][] bag = new int[num+1][2];
        dp = new int[num + 1][weight + 1];
        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(bf.readLine());
            //0이 weight
            bag[i][0] = Integer.parseInt(st.nextToken());
            //1이 value
            bag[i][1] = Integer.parseInt(st.nextToken());
        }
        //주어진 가방들
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= weight; j++) {
                int thisweight = bag[i][0];
                int thisvalue = bag[i][1];
                if (thisweight <= j) {
                    //지금 가치에 현재 책정 무게에서 담을 예정인 무게 뺀 dp의 값
                    dp[i][j] = Math.max(dp[i - 1][j], thisvalue + dp[i - 1][j - thisweight]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[num][weight]);
    }
}
