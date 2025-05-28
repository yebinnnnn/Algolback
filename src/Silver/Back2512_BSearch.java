package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Back2512_BSearch {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bf.readLine());
        int[] budget = new int[N];
        int total=0;
        StringTokenizer st= new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            budget[i]=Integer.parseInt(st.nextToken());
            total+=budget[i];
        }
        //총 값 까지 (백만 이상이상)
        long all=Long.parseLong(bf.readLine());
        //이분탐색 -> 가장 금액이 적은 것부터 찾기
        //예산안에 들어오면 출력하고 강종
        Arrays.sort(budget);
        if(total<=all){
            System.out.println(budget[N-1]);
            System.exit(0);
        }
        int start=0;
        int end=N-1;
        long nowanswer=0;
        while(start<end){
            int nowbudget=0;
            int mid=(start+end)/2;
            for(int j=mid; j>0; j--){
                nowbudget+=budget[j];
            }
            if(nowbudget<all){
                nowanswer=((all-nowbudget)/(N-(mid+1)));
                start=mid+1; //좀 더 높여볼까?
            }else{//상한선 낮춰
                end=mid;
            }
        }
        System.out.println(nowanswer);
    }
}
