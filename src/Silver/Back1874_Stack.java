package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back1874_Stack {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(bf.readLine());
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> spair=new Stack<>();
        StringBuilder sb= new StringBuilder();

        for(int i=n; i>0; i--){
            spair.push(i); //거꾸로 다 스페어 넣어줌.
        }

        int count=0;
        boolean find=false;
        int thisnum=Integer.parseInt(bf.readLine());

        while(count<n){
            if(find) {//찾았던 경우
                thisnum = Integer.parseInt(bf.readLine()); //이번에 가져야 할 수 입력받음
                find=false;
            }
            //stack 아예 비어있을 때
            if(stack.isEmpty()){
                stack.push(spair.pop());
                sb.append("+").append("\n");
            }
            //넣을 숫자가 찾는 숫자보다 작을 경우=그냥 넣을 수 있다.
            if(!spair.isEmpty()&&spair.peek()<thisnum){
                stack.push(spair.pop());
                sb.append("+").append("\n");
            }
            //넣을 숫자가 찾는 숫자 일 경우= 넣 뻇
            else if(!spair.isEmpty()&&spair.peek().equals(thisnum)){
                stack.push(spair.pop());
                sb.append("+").append("\n");
                stack.pop();
                sb.append("-").append("\n");
                count++;
                find=true;
            }
            //top 숫자가 아직 안꺼내진 상태에서 뽑아야하는 숫자보다 큼.
            else if(stack.peek()>thisnum){
                sb.delete(0,sb.length());
                sb.append("NO");
                break;
            }
            //이미 저장되어 있던 수가 일치할 경우
            if(stack.peek().equals(thisnum)){
                stack.pop();
                find=true;
                count++;
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}
