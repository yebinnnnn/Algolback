
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(bf.readLine());
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int first=Integer.MAX_VALUE;

        Stack<Integer> stack= new Stack<>();
        Stack<Integer> indexes= new Stack<>();
        //탑들 배치
        StringBuilder sb= new StringBuilder();
        stack.push(first); //가장 큰 막대 스택에 집어넣음
        indexes.push(0);
        int index=0;
        for(int i=0;i<N;i++){
            //이번에 들어올 건물 값=build, 인덱스는 i.
            int build=Integer.parseInt(st.nextToken());
            //이 이전의 최대 건물과 비교했을때 여전히 개가 최고임
            while(!stack.isEmpty()){
                //stack 상단에 있는 빌딩이 현재것보다 클때!
                if (build < stack.peek()) {
                    sb.append(indexes.peek()).append(" ");
                    break;
                } else {//현재 빌딩값이 더 클때.
                    stack.pop();
                    indexes.pop();
                }
            }
            stack.push(build);
            indexes.push(i+1);
        }
        System.out.println(sb);
    }
}
