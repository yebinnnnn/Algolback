package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Back2529_Tracking { //수열을 구해서 조건을 확인하면 되나..?
    public static char[] boo;
    public static int[] number;
    public static boolean[] checking;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            boo[i] = st.nextToken().charAt(0);
        }
        number=new int[N];
        checking=new boolean[N];
        Tracking(0,0);
    }
    public static void Tracking(int start, int depth){
        //수열 하나씩 할당됏을때 조건을 확인할지 -> 백트래킹
        if(depth==N){//조합을 다 뽑았을때 조건을 확인할지

        }
        if(depth<N){
            for(int i=start;i<N;i++){
                number[depth]=i;
                checking[depth]=true;
                Tracking(start+1,depth+1);
                checking[depth]=false;
            }
        }
    }
}
