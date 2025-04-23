package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Back2529_Tracking { //수열을 구해서 조건을 확인하면 되나..?
    public static char[] boo;
    public static char[] number;
    public static boolean[] checking;
    public static int N;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            boo[i] = st.nextToken().charAt(0);
        }
        number=new char[N];
        checking=new boolean[N];
        Tracking(0,0);
    }
    public static void Tracking(int start, int depth){
        //순열 하나씩 할당됏을때 조건을 확인할지 -> 백트래킹
        if(depth==N){//조합을 다 뽑았을때 조건을 확인할지 하나씩 확인할 지 선택
            for(char c: number){
                for(int j=0; j<N; j++){
                    //부등호 할당을 어떻게 하지?
                    if(!number[j]>=number[j+1]){
                        return;
                    }
                    else{
                        for(char c1 : number){
                            sb.append(c1);
                        }
                    }
                }
            }
        }
        if(depth<N){
            for(int i=0;i<N;i++){
                number[depth]=String.valueOf(i).charAt(0);
                checking[depth]=true;
                Tracking(start+1,depth+1);
                checking[depth]=false;
            }
        }
    }
}
