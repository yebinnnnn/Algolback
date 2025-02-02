package Silver;
import java.util.*;
import java.io.*;

public class Back1927_PiriQueue {
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pqueue= new PriorityQueue<>();
        int num= Integer.parseInt(bf.readLine());
        StringBuilder sb= new StringBuilder();
        while(num-->0){
            int in=Integer.parseInt(bf.readLine());
            if(in==0){
                if(pqueue.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pqueue.poll()).append("\n");
                }
            }
            else {
                pqueue.add(in);
            }
        }
        System.out.println(sb);
    }
}
