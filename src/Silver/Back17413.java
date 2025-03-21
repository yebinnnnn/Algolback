package Silver;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Back17413 {
    public static Stack<Character> stack=new Stack<>();
    public static Queue<Character> queue=new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String words=bf.readLine();
        StringBuilder sb= new StringBuilder();
        boolean init=false;

        for(int i=0; i<words.length(); i++){
            if(words.charAt(i)=='<'){
                init=true; //들어왔어요 처리
                queue.add(words.charAt(i)); //append 해주기
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }else if(words.charAt(i)=='>'){
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                }
                sb.append(words.charAt(i)); //괄호도 append 해주기
                init=false;
                //탈출 처리
            }
            //들어와 있을떄 = 똑바로 큐에 넣어줘야 함.
            else if(init){
                queue.add(words.charAt(i));
            }
            //괄호 안에 있는게 아닌 상태
            else{
                //괄호 밖에서 스페이스바를 만났을때(한번 털고 끊어줘야 함)
                //또는 괄호 시작일때
                if(words.charAt(i)==' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(words.charAt(i));
                }
                else{
                    stack.push(words.charAt(i));
                }
            }
        }
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
