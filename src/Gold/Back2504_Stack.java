package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;


public class Back2504_Stack {
    static Stack<Character> stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String practices= bf.readLine();
        char[] practice=practices.toCharArray(); //char 배열로 바꿔줌.
        for(char c : practice){
            stack.push(c);
        } //모든 괄호 먼저 스택에 집어넣기

        int count=0;
        while(!stack.isEmpty()){
            char popped=stack.pop();
            if(popped=='(' || popped=='['){
                count++;
            }
        }
    }
}
