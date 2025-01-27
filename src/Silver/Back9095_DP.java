package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back9095_DP { //1,2,3으로 나타낼 수 있는 모든 경우의 수 /재귀로 풀어서 DP로 다시 풀어볼게여,,,
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        int number;
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<T; i++){
            number= Integer.parseInt(br.readLine());
            int answer=foundcount(number);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static int foundcount(int number){
        if(number<=0){
            return 0;
        }
        else if(number==1){
            return 1;
        }
        else if(number==2){
            return 2;
        }
        else if(number==3){
            return 4;
        }
        return foundcount(number-1)+foundcount(number-2)+foundcount(number-3);
    }
}
