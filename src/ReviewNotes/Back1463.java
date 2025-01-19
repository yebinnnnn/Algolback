package ReviewNotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1463 { //DP 점화식, 규칙을 찾을 것
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number= Integer.parseInt(br.readLine());
        dp= new Integer[number+1];
        dp[0]=dp[1]=0;
        System.out.println(findcount(number));
    }
    //DP-> 메모 할 배열을 만들어야 한다.
    public static int findcount(int number){
        if(dp[number] == null){
            if(number%2==0 && number%3==0){
                dp[number]= Math.min(
                        findcount(number-1),Math.min(
                                findcount(number/3),findcount(number/2)))+1;
            }
            else if(number %3==0){
                dp[number]= Math.min(findcount(number/3), findcount(number-1))+1;
            }
            else if (number%2==0){
                dp[number]= Math.min(findcount(number/2), findcount(number-1))+1;
            }
            else{
                dp[number]= findcount(number-1)+1;
            }
        }
        return dp[number];
    }
}
