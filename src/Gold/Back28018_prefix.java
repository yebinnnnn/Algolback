package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

//시간초과 날거같긴한데 일단 해봄
public class Back28018_prefix {
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int person=Integer.parseInt(bf.readLine());
        int[] prefix= new int[1000002];//타임테이블 느낌으로
        int[] toprefix=new int[1000002];

        while(person-->0){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            int in=Integer.parseInt(st.nextToken());
            int out=Integer.parseInt(st.nextToken());
            //이렇게 하나하나 과정을 줄이는게 누적합이자녀
            //증감을 저장한다
            if(in==0){
                toprefix[0]=1;
            }
            prefix[out+1]+=-1;
            prefix[in]+=1;
        }
        for(int i=1;i<1000001;i++){
            toprefix[i]=prefix[i]+=prefix[i-1];
        }
        StringBuilder sb= new StringBuilder();
        int time=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        while (time-- > 0) {
            int thistime=Integer.parseInt(st.nextToken());
            sb.append(toprefix[thistime]).append("\n");
        }
        System.out.println(sb);
    }
}
