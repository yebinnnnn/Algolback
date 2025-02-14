package Silver;
import java.util.*;
import java.io.*;

public class Back2512_BinarySearch {
    public static int[] budget;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bf.readLine()); //지방개수를 의미하는 정수
        StringTokenizer st= new StringTokenizer(bf.readLine());
        budget= new int [N+1];
        int sum=0;
        int max=0; //가장 높은 배당액
        int min=0;
        int mid=0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sum+=budget[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,budget[i]);
        }
        int remain=Integer.parseInt(bf.readLine());
        if(sum<=remain){
            sb.append(max);
        }
        else{
            while(min<max){
                sum=0;
                mid=(max+min)/2;
                for(int k=0; k<N; k++){
                    sum+=Math.min(budget[k],mid);
                }
                if(sum>remain){
                    max=mid;
                }
                else{
                    min=mid+1;
                }
            }
            sb.append(min-1);
        }
        System.out.println(sb);
    }
}
