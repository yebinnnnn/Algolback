package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Back1003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int number=Integer.parseInt(br.readLine());
            int count0=0;
            int count1=0;
            int[] fibozero = new int[number+2];
            int[] fiboone = new int[number+2];
            fibozero[0]=1;
            fiboone[0]=0;
            fibozero[1]=0;
            fiboone[1]=1;
            for(int k=2; k<=number; k++){
                fibozero[k]=fibozero[k-1]+fibozero[k-2];
                fiboone[k]=fiboone[k-1]+fiboone[k-2];
            }
            sb.append(fibozero[number]).append(" ").append(fiboone[number]).append("\n");
        }
        System.out.println(sb);
    }
}
