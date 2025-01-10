package Silver;

import java.io.BufferedReader;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back10828 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int count= Integer.parseInt(bf.readLine());
        Stack<Integer> mystack = new Stack<Integer>();
        StringBuilder sb= new StringBuilder();

        //push commend 만 잘 처리하면 쉬운 문제
        for(int i=0; i<count; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            String commend=st.nextToken();

            if(commend.equals("push")){
                int putnum= Integer.parseInt(st.nextToken());
                mystack.push(putnum);
            }
            else if(commend.equals("pop")) {
                if(mystack.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(mystack.pop()).append("\n");
                }
            }
            else if(commend.equals("size")) {
                sb.append(mystack.size()).append("\n");
            }
            else if(commend.equals("empty")){
                if(mystack.isEmpty()){
                    sb.append("1").append("\n");
                }
                else{
                    sb.append("0").append("\n");
                }
            }
            else if(commend.equals("top")) {
                if(mystack.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(mystack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
