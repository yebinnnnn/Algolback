package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Back1946_Greedy { //들어오는 순위는 동석차가 없다. Greedy
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase= Integer.parseInt(bf.readLine());
        StringBuilder sb= new StringBuilder();
        while(testcase-->0){
            int person=Integer.parseInt(bf.readLine());
            int[] grade= new int[person+1];// 1등부터 카운트
            for(int i=1; i<=person; i++){ //인덱스는 서류 심사 등수를 나타낸다.
                st=new StringTokenizer(bf.readLine());
                grade[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
                //각 등수에 면접 결과 등수도 배정.
            }
            //이중포문은 못쓴다.
            //둘 다 타인보다 떨어지면 배제해야한다. 1등은 모두 생존, 인원수만 구하면됨
            //서류가 1등이면 무조건 합격이다.
            //서류가 2등이면 1등의 면접등수와 비교해야 한다.
            //서류가 3등이면 1,2등의 면접등수와 비교해야 한다. 둘 중 한명보다 면접결과가 앞서기만하면된다.
            int persons=0;
            for(int i=1; i<=person; i++){
                int count=0;

                for(int j=i; j>0; j--){
                    if(grade[i]<=grade[j]){
                        count++;
                    }
                    else if( i==1 || grade[i]==1){
                        count++;
                    }
                }
                //System.out.println(i+"의 count:"+count);
                if(count==i){
                    persons++;
                }
            }
            sb.append(persons).append('\n');
        }
        System.out.println(sb);
    }
}
