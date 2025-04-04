package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

//너무 하드코딩 지옥이 됐는데요
//((())()) 이 경우만 풀면 다 품
public class Back2504_Stack {
    static Stack<Character> stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String practices = bf.readLine();

        int answer = 0;
        int value = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < practices.length(); i++) {
            char c = practices.charAt(i);
            if (c == '(') {
                stack.push(c);
                value = 2 * value;

            } else if (c == '[') {
                stack.push(c);
                value = 3 * value;

            }//여기까진 쉽당께
            else if (c == ')') { //왼쪽이 더 할당된 경우
                if (stack.isEmpty() || stack.peek() != '(') {
                    sb.append("0");
                    break;
                } else if (practices.charAt(i - 1) == '(') {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    sb.append("0");
                    break;
                } else if (practices.charAt(i - 1) == '[') {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if (stack.isEmpty()) {
            sb.append("0");
        } else {
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

        //스택 잘못 쌓은 예시
//        char[] practice=practices.toCharArray(); //char 배열로 바꿔줌.
//        for(char c : practice){
//            stack.push(c);
//        } //모든 괄호 먼저 스택에 집어넣기
//
//        int doublecount=0;
//        int thirdcount=0;
//        int allsum=0;
//        int readysum=1;
//        StringBuilder sb= new StringBuilder();
//
//        while(!stack.isEmpty()){
//            char popped=stack.pop();
//            if(popped==')'){
//                doublecount++;
//            }
//            else if(popped==']') {
//                thirdcount++;
//            }
//            else if(popped=='('){
//                doublecount--;
//                if(doublecount<0){
//                    sb.append("0");
//                    break;
//                }
//                //축적된게 없는 상태
//                if(thirdcount==0&&doublecount<=1) {
//                    if(doublecount==0){
//                        allsum+=readysum*2;
//                        readysum=1;
//                    }
//                    else{
//                        readysum+=2;
//                    }
//                }
//                else{//축적된게 있는상태 (()[])같은 경우가 else 문에 걸리는중... 원래 의도는 ([])
//                    readysum *= 2;
//                }
//            }
//            else if(popped=='['){
//                thirdcount--;
//                if(doublecount<0){
//                    sb.append("0");
//                    break;
//                }
//                if(doublecount==0&&thirdcount<=1) {
//                    if(thirdcount==0){
//                        allsum+=readysum*3;
//                        readysum=1;
//                    }
//                    else{
//                        readysum+=3;
//                    }
//                }
//                else {
//                    readysum *= 3;
//                }
//            }
//            if(stack.isEmpty()) { //마지막에 숫자 안맞을때의 조건
//                if (doublecount > 0 || thirdcount > 0) {
//                    sb.append("0");
//                    break;
//                } else {
//                    sb.append(allsum);
//                    break;
//                }
//            }
//        }
}
