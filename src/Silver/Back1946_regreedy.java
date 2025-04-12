package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Back1946_regreedy {
    public static void main(String[] args) throws IOException {
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    int testcase= Integer.parseInt(bf.readLine());
    StringBuilder sb= new StringBuilder();
        while(testcase-->0){
            int person=Integer.parseInt(bf.readLine());
            int[][] apply=new int[person][2];
            for(int i=0; i<person; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                apply[i][0] = Integer.parseInt(st.nextToken()); // 서류
                apply[i][1] = Integer.parseInt(st.nextToken()); // 면접
            }
            Arrays.sort(apply, Comparator.comparingInt(a->a[0]));
            int count=1;
            int interview=apply[0][1];

            for(int i=1; i<person; i++) {
                if(apply[i][1]<interview) {
                    count++;
                    interview=apply[i][1];
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
