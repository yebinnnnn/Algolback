package ReviewNotes;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back16953_greedyBFS {//그리디...와 진짜 모르겠다
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        long A= Long.parseLong(st.nextToken());
        long B=Long.parseLong(st.nextToken());
        //A는 2*A 가 되거나 A*10+1이 되거나 둘중 하나다. 이를 또 *2 할 수 있다.
        int answer=bfs(A,B);
        System.out.println(answer);
    }

    public static int bfs(long A,long B) {
        Queue<Long> q= new LinkedList<>();
        q.add(A);
        int count=1;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0; i<size; i++) {
                long current =q.poll();

                if (current == B) {
                    return count;
                }
                long next1 = current * 2;
                long next2 = current * 10 + 1;

                if (next1 <= B) q.add(next1);
                if (next2 <= B) q.add(next2);
            }
            count++;
        }
        return -1;
    }
}
