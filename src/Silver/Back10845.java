package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<Integer>();

        StringBuilder sb= new StringBuilder();

        int num=Integer.parseInt(bf.readLine());
        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                queue.offer(Integer.valueOf(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
            else if(command.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(queue.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(command.equals("front")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(queue.peek()).append("\n");
                }
            }
            else if(command.equals("back")){
                Object[] array = queue.toArray();
                if (array.length>0){
                    Object last = array[array.length-1];
                    sb.append(last).append("\n");
                }
                else{
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
