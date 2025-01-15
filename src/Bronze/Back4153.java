package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int sum=0;

        while(true){
            sum=0;
            int[] triangle=new int[3];
            StringTokenizer st=new StringTokenizer(bf.readLine());
            for(int i=0;i<3; i++){
                triangle[i]=Integer.parseInt(st.nextToken());
                sum+=triangle[i];
            }
            if(sum==0){
                break;
            }
           triangle= Arrays.stream(triangle).sorted().toArray();
            if(Math.pow(triangle[2],2)==Math.pow(triangle[1],2)+Math.pow(triangle[0],2)){
                sb.append("right").append("\n");
            }
            else{
                sb.append("wrong").append("\n");
            }
        }

        System.out.print(sb);
    }
}
