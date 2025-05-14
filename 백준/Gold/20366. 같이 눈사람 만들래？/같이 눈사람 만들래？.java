import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        int[] snow=new int[n];
        int min=Integer.MAX_VALUE;
        StringTokenizer st= new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++){
            snow[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snow);
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n;j++){
                int thissum=snow[i]+snow[j];
                //이번 반복의 기준
                //이번 반복의 두 포인터
                int end=n-1;
                int start=0;
                while(start<end){
                    //인덱스 겹칠때
                    if(start==i || end==j) {
                        start++;
                        continue;
                    }
                    if(end==i ||start==j){
                        end--;
                        continue;
                    }
                    int temp=snow[start]+snow[end];
                    min=Math.min(min, Math.abs(thissum-temp));
                    // 또 조건걸어서 투 포인터 탐색
                    if(thissum<temp){
                        end--;
                    }
                    else{
                        start++;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
