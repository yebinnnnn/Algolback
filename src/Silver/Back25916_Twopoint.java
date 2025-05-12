package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;

public class Back25916_Twopoint{
    public static void main(String[] args) throws IOException{
        int[] holes;
        int max=0;
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int num= Integer.parseInt(st.nextToken());//구멍 수
        int ham=Integer.parseInt(st.nextToken());//햄스터 부피
        holes=new int[num];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<num;i++){
            holes[i]=Integer.parseInt(st.nextToken());
        }
        //구멍 할당 완료, 투포인터, 누적합?
        int[] prefix=new int[num+1];
        prefix[0]=0;
        for(int i=1; i<=num; i++){
            prefix[i]=prefix[i-1]+holes[i-1];
        }
        int start=0;
        int end=1;
        while(end<=num){
            int sum;
            sum=prefix[end]-prefix[start];
            if(sum<=ham){//아직 햄이 감당가능
                max=Math.max(max,sum);
                end++;
            }else if(start==end){
                end++;
            }
            else{//햄이 감당 불가
                start++;
            }
        }
        System.out.println(max);
    }
}
