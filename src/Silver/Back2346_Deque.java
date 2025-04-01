package Silver;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Back2346_Deque {
    static Deque<Integer> number =new ArrayDeque<>();
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();
        int[] hash=new int[n+1];

        for(int i=1; i<=n; i++){
            hash[i]=Integer.parseInt(st.nextToken());//쪽지가 차례대로 데크에 들어감
            number.addLast(n+1-i); // 데크에 번호 풍선 넣어줌.
        }

        int thisnum=number.removeLast(); //1 없앰
        sb.append(thisnum).append(" ");
        int move=0;

        for(int i=0; i<n-1; i++){
            if(i==0){
                move=hash[1]; //해시에서 이동 수 할당
            }
            //무브가 양수일때 (꼬리에 1이 있음. 빼서 head 에 넣고 순환하기.
            if(move>0){
                for(int j=0; j<move-1; j++){
                    number.addFirst(number.pollLast());
                }
                thisnum=number.removeLast();
                sb.append(thisnum).append(" ");
                move=hash[thisnum];

            }
            else if(move<0){
                for(int j=0; j<Math.abs(move)-1; j++){
                    number.addLast(number.pollFirst());
                }
                thisnum=number.removeFirst();
                sb.append(thisnum).append(" ");
                move=hash[thisnum];
            }
        }
        System.out.println(sb);
    }
}
