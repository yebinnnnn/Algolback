package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back1835_Card {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(bf.readLine());
        Deque<Integer> deq= new ArrayDeque<>();
        for(int i=N; i>0; i--){ //가장 큰 수부터 카운트
            deq.addFirst(i);
            for(int j=0; j<i; j++ ){
                deq.addFirst(deq.pollLast());
            }
        }

        while(!deq.isEmpty()){
            System.out.print(deq.poll()+" ");
        }
    }
}
