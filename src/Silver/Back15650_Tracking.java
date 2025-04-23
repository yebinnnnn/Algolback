package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Back15650_Tracking {//순열과 조합에서 조합에 해당. (내가 더 못함)
    static int [] answer;
    static int number;
    static int cases;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        number= Integer.parseInt(st.nextToken());
        cases= Integer.parseInt(st.nextToken());
        answer=new int[number+1];
        Tracking(0,0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    //중복된 조합이 나오면 안된다. 코드 자체는 순열보다 단순...해야하는데
    public static void Tracking(int start,int depth){
        if(depth==cases){
            for(int i=0;i<cases;i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<number; i++){
            answer[depth]=i+1;
            Tracking(i+1,depth+1);
        }
    }
}
