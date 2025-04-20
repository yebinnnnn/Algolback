package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back6603_tracking { //백트래킹으로 풀 수 있단 말이지,,,
    static int[] thisnum;
    static int[] answer;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input=bf.readLine();

        while(!input.equals("0")){
            st=new StringTokenizer(input);
            int size=Integer.parseInt(st.nextToken());
            thisnum=new int[size];
            answer=new int[6]; //6개 숫자만 뽑는거임
            for(int i=0;i<size;i++){//이번 숫자들 배열에 할당.
                thisnum[i]=Integer.parseInt(st.nextToken()); //이 안에서 모든 조합 구하기.
            }
            getset(0,0);
            input=bf.readLine();
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    //dfs 랑 비슷한듯 한데...
    public static void getset(int start, int depth){//"깊이"를 만들기
        if(depth==6){
            for(int i=0;i<6;i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<thisnum.length;i++){
            answer[depth]=thisnum[i];
            getset(i+1, depth+1);
        }
    }
}
