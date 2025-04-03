package Silver;
import java.util.*;
import java.io.*;

public class Back11279_MaxHeap { //쟈료구조 중에 힙을 써본적이 없다...
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); //우선 순위 큐 리버스
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int number=Integer.parseInt(bf.readLine());
        StringBuilder sb= new StringBuilder();

        while(number-->0){
            int point=Integer.parseInt(bf.readLine());
            if(point==0){
                if(maxHeap.isEmpty()){
                    sb.append(0).append('\n');
                }
                else{
                    sb.append(maxHeap.poll()).append('\n');
                }
            }
            else{
                maxHeap.add(point);
            }
        }
        System.out.println(sb);
    }
}
