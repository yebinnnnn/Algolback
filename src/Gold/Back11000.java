package Gold;

import java.io.IOException;
import java.util.*;
import java.io.*;


public class Back11000 { //greedy 알고리즘,.인데 정렬쇼같은건 나뿐? 회의실 배정이랑 비슷한 문제.
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(bf.readLine());
        int[][] classes=new int[num][2]; //두개씩 시작, 끝 시간이 주어짐 .
        StringTokenizer st;
        for(int i=0; i<num; i++){
            st=new StringTokenizer(bf.readLine());
            classes[i][0]=Integer.parseInt(st.nextToken());
            classes[i][1]=Integer.parseInt(st.nextToken());
        }
        //회의실이랑 다르게 시작시간 기준 정렬
        Arrays.sort(classes, Comparator.comparingInt(a->a[0]));

        PriorityQueue<Integer> pri=new PriorityQueue<>();
        pri.offer(classes[0][1]); //끝나는 시간널고
        int count=1;
        for(int i=1; i<num; i++){
            if(classes[i][0]>=pri.peek()){
                pri.poll();
            }
            pri.offer(classes[i][1]);
        }
        System.out.println(pri.size());
    }
}
