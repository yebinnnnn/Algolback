package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11659_prefixReview {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int num= Integer.parseInt(st.nextToken());
        int[] nums=new int[num];
        int[] prefix=new int[num+1];
        int cases=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        nums[0]=Integer.parseInt(st.nextToken());
        prefix[0]=0;
        for(int i=1; i<num; i++){
            nums[i]=Integer.parseInt(st.nextToken());
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        prefix[num]=prefix[num-1]+nums[num-1];
        StringBuilder sb= new StringBuilder();
        while(cases-->0){
            st=new StringTokenizer(br.readLine());
            //시작과 끝점 받기
            int first=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            sb.append(prefix[end]-prefix[first-1]).append("\n");
        }
        System.out.println(sb);
    }
}
