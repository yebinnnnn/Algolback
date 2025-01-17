package Silver;

import java.util.*;
import java.io.*;

public class Back1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }
        int count=0;
        while(!queue.isEmpty()){
            count++;
            if(count%M==0){
                if(queue.size()==1){
                    sb.append(queue.poll());
                }
                else{
                    sb.append(queue.poll()).append(", ");
                }
                count=0;
            }
            else{
                queue.add(queue.poll());
            }
        }
        System.out.println("<"+sb+">");

    }
}
