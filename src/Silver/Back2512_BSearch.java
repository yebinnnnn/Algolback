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
        //예산총액
        long all=Long.parseLong(bf.readLine());
        //이분탐색 -> 가장 금액이 적은 것부터 찾기
        //예산안에 들어오면 출력하고 강종
        Arrays.sort(budget);
        if(total<=all){
            System.out.println(budget[N-1]);
            System.exit(0);
        }
        //start와 end 에 금액자체를 담음
        int start=0;
        int end=budget[N-1];
        int nowanswer=-1;
        while(start<=end){
            int nowbudget=0;
            int mid=(start+end)/2;
            //전체 예산을 돌면서 설정한 mid 값보다 적으면 예산에 포함시키고,
            for(int j=0; j<N; j++){
                if(budget[j]<=mid){
                    nowbudget+=budget[j];
                }else{//설정한 mid 값보다 많으면 예산에 mid 값을 대신 넣음.
                    nowbudget+=mid;
                }
            }
            //그렇게 설정했을때 나온 최종 금액이 우리가 정한 예산보다 많다면 end 를 줄여야 함.
            if(nowbudget>all){
                end=mid-1;
            }else{
                nowanswer=Math.max(nowanswer,mid);
                start=mid+1;
            }
        }
        System.out.println(nowanswer);
    }
}
