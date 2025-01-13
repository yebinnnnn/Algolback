package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back10773 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int number=Integer.parseInt(bf.readLine());
        Stack<Integer> stack=new Stack<Integer>();
        int put=0;
        for(int i=0; i<number; i++){
            put=Integer.parseInt(bf.readLine());
            if(put==0){
                stack.pop();
            }
            else{
                stack.push(put);
            }
        }
        int sum=0;
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        sb.append(sum);
        System.out.println(sb);
    }
}
