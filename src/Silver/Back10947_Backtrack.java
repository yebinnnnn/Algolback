package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back10947_Backtrack {//모든 순열 구하기 재귀 기본문제
    public static boolean[] checking;
    public static int number;
    public static int [] answer;
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        number= Integer.parseInt(bf.readLine());
        checking = new boolean[number+1];
        answer=new int[number];
        tracking(0);
    }

    public static void tracking(int depth){
        if(depth==number){
            for (int j : answer) {
                System.out.print(j+" ");
            }
            System.out.println();
            return;
        }
        if(depth<number){//아직 깊이가 끝까지 도달하지 않음
            for (int i = 1; i <=number; i++){
                if(!checking[i]) {
                    checking[i] = true;
                    answer[depth]=i;
                    tracking(depth+1);
                    checking[i]=false;
                }
            }
        }
    }
}
