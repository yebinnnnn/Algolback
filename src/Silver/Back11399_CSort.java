package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back11399_CSort {//Counting sort 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        int[] waiting= new int [1001];
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0; i<count; i++){
            waiting[Integer.parseInt(st.nextToken())]++;
        } //각 인덱스에 1 씩 저장 되어있는 상태이다.
        //counting sort 의 array 배열. 이를 누적합 배열로 만들면 counting 배열, 인덱스의 순서가 됨.
        int sum=0;
        int prev=0;

        for(int i=0; i<1001; i++){
            while(waiting[i]-- > 0){//그냥 제일 적은 인덱스 경우부터 카운팅 된다. (O(n)으로 자동 정렬됨)
                sum+=(i+prev); //i 가 waiting 시간이 된것.
                prev+=i;
            }
        }
        System.out.println(sum);
    }
}
