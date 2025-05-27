
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(bf.readLine());
        //우선순위 큐. (작은것부터 잡아줌)
        //들어오는 데이터는 자기 위의 숫자보다는 크다.
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0; i<N; i++){//흠...두번반복
            StringTokenizer st= new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        //N번째 큰수를 찾아야한다.
        for(int j=0; j<N*N-N; j++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
