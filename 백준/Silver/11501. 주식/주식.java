import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int cases=Integer.parseInt(bf.readLine());
        StringBuilder sb= new StringBuilder();
        while(cases-->0){
            int num=Integer.parseInt(bf.readLine());
            long[] ju= new long[num];
            long total=0;
            long max=0;
            StringTokenizer st= new StringTokenizer(bf.readLine());
            for(int i=0;i<num;i++){
                //주식 값들 저장
                ju[i]=Long.parseLong(st.nextToken());
            }
            //뒤에서부터 최댓값 저장
            max=Math.max(max,ju[num-1]);
            for(int i=num-2; i>=0; i--){
                //뒤로 돌아가면서 현재까지의 최댓값 저장
                if(max>ju[i]){
                    total+=max-ju[i];
                }else{
                    max=ju[i];
                }
            }
            sb.append(total).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
