package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        while(true) {
            char[] myword;
            Stack<Boolean> stack = new Stack<>();
            myword = new char[100];
            myword = bf.readLine().toCharArray();

            if (myword[0] == '.') {
                break;
            }
            int i;
            boolean out=false;
            for (i = 0; i < myword.length; i++) {
                if (myword[i] == '(') {
                    stack.push(true);
                } else if (myword[i] == '[') {
                    stack.push(false);
                } else if (myword[i] == ')') {
                    if (stack.isEmpty()) {
                        sb.append("no").append("\n");
                        out=true;
                        break;
                    }
                    else if(!stack.peek()){
                        sb.append("no").append("\n");
                        out=true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                } else if (myword[i] == ']') {
                    if (stack.isEmpty()) {
                        sb.append("no").append("\n");
                        out=true;
                        break;
                    }
                    else if(stack.peek()){
                        sb.append("no").append("\n");
                        out=true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if(i==myword.length){
                if (!stack.isEmpty()) {
                    sb.append("no").append("\n");
                } else {
                    sb.append("yes").append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
