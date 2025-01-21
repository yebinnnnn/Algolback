package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Back18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int person=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> hard = new ArrayList<Integer>();
        for(int i=0; i<person; i++){
            hard.add(Integer.parseInt(br.readLine()));
        }
        hard.sort(Comparator.naturalOrder()); //여기서 이중포문 효과 발생
        //PriorityQueue 를 쓰면 좀 더 줄일 수 있따.
        int sum=0;

        if(person==0){
            sb.append(0);
        }
        else{
            int minus=(int)Math.round(person*0.15);
            for(int i=minus; i<person-minus;i++){
                sum+=hard.get(i);
            }
            int persons=(person-2*minus);
            sb.append((int)Math.round(((double)sum /persons)));
        }
        System.out.println(sb);
    }
}
