package ReviewNotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back2529_Tracking { //수열을 구해서 조건을 확인하면 되나..?
    public static char[] boo;
    public static char[] number;
    public static boolean[] checking;
    static String min=null;
    static String max=null;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boo = new char[N];
        for (int i = 0; i < N; i++) {
            boo[i] =st.nextToken().charAt(0);
        }
        number=new char[N+1];
        checking=new boolean[10];
        Tracking(0);
        System.out.println(max);
        System.out.println(min);
    }
    public static void Tracking(int depth){
        //순열 하나씩 할당됏을때 조건을 확인할지 -> 백트래킹
        if(depth==N+1) {//다 뽑았을때 조건을 확인할지 하나씩 확인할 지 선택
            for (char c : number) {
                //부등호 할당 체크
                for (int j = 0; j < N; j++) {
                    if (boo[j] == '>' && number[j] <= number[j + 1]) {
                        return;
                    }
                    if (boo[j] == '<' && number[j] >= number[j + 1]) {
                        return;
                    }
                }
                String now = new String(number);
                if (min == null || now.compareTo(min) < 0) {
                    min = now;
                }
                if (max == null || now.compareTo(max) > 0) {
                    max = now;
                }
                return;
            }
        }
        for(int i=0;i<=9;i++){
            if(!checking[i]) {
                number[depth] = (char)(i+'0');
                checking[i] = true;
                Tracking(depth + 1);
                checking[i] = false;
            }
        }
    }
}
