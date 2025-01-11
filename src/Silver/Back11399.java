package Silver;
import java.util.*;
import java.io.*;

public class Back11399 { //그리디,정렬
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(bf.readLine());
        ArrayList<Integer> waiting = new ArrayList<>();
        StringTokenizer st= new StringTokenizer(bf.readLine());

        for(int i=0; i<count; i++){
            waiting.add(Integer.parseInt(st.nextToken()));
        }
        waiting.sort(Comparator.naturalOrder());//이 문제같은 경우는 정렬만 하면 해결이 된다...
        int prev=0; //이전까지 대기시간(누적합)
        int sum=0; //총 대기시간

        for(int i=0; i<waiting.size(); i++){
            sum+=prev+waiting.get(i);
            prev+=waiting.get(i);
        }

        System.out.println(sum);
    }
}
