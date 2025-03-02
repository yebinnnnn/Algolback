package Gold;

import java.util.*;
import java.io.*;

public class Back5430 {
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deq= new ArrayDeque<>();
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        int cases= Integer.parseInt(bf.readLine());//연산의 수 이만큼 주어짐
        while(cases-->0){
            String str= bf.readLine(); //이번 분기 명령어
            int number=Integer.parseInt(bf.readLine());//이번 수열에 있는 수의 갯수
            st= new StringTokenizer(bf.readLine(),","+"]"+"[");
            boolean reverse= false;//뒤집힌단 의미
            boolean error=false; //에러 탐지용
            deq.clear(); //이전에 썼던 데크 초기화

            for(int i=0; i<number; i++){
                deq.addFirst(Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i)=='R'){//리버스 표시
                    reverse=!reverse;
                }
                else if(str.charAt(i)=='D'){//제거 표시
                    if(deq.isEmpty()){
                        sb.append("error").append("\n");
                        error=true;
                        break;
                    }
                    if(reverse){//뒤집힘
                        deq.removeFirst();
                    }
                    else{
                        deq.removeLast();
                    }
                }
            }
            if(!error) {
                if(!reverse){
                    int thissize=deq.size();
                    sb.append("[");
                    if(deq.isEmpty()){
                        sb.append(",");
                    }
                    for(int j=0; j<thissize; j++){
                        sb.append(deq.removeLast());
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("]").append("\n");
                }
                else{
                    int thissize=deq.size();
                    sb.append("[");
                    if(deq.isEmpty()){
                        sb.append(",");
                    }
                    for(int j=0; j<thissize; j++){
                        sb.append(deq.removeFirst());
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("]").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
