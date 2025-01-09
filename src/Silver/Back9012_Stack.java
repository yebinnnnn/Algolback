package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back9012_Stack { //결국 이중포문이긴함
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int count=Integer.parseInt(bf.readLine());

        for(int i=0;i<count;i++){
            sb.append(IsExcept(bf.readLine())).append('\n');
        }
        System.out.println(sb);
    }

    public static String IsExcept(String inputs){
        Stack<Character> stack = new Stack<>();

        for(int j=0; j<inputs.length(); j++){
            char input= inputs.charAt(j);

            if(input=='('){
                stack.push(input);
            }
            else if(stack.isEmpty()){//닫는 괄호일 경우
                return "NO";
            }
            else{//닫는 괄호일경우
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}
