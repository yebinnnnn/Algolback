
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class Main{ //약간 강의실 회의실 비슷한거 같기도 하고
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int num = Integer.parseInt(st.nextToken()); //지름길의 수
        int len = Integer.parseInt(st.nextToken()); //고속도로 총 길이
        int[][] arr= new int[num][3]; //세 배열에 저장
        for (int i = 0; i < num; i++) {//지름길 저장
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()); //지름길 시작지점
            int end = Integer.parseInt(st.nextToken()); //지름길 끝나는 지점
            int slen = Integer.parseInt(st.nextToken()); //지름길 길이
            arr[i][0] = start;
            arr[i][1] = end;
            arr[i][2] = slen; //각 각 저장
        }
        //그냥 도로끝까지 모든 순간 저장
        int [] dp= new int[len+1];
        for(int i=0; i<=len; i++){
            dp[i]=i; //순수 거리 저장
        }

        for(int i=1; i<=len; i++){
            dp[i]=Math.min(dp[i], dp[i-1]+1);
            for(int j=0; j<num; j++){
                if(arr[j][1]==i){//만약에 시작점에 지름길이 존재한다면
                    dp[i]=Math.min(dp[i], dp[arr[j][0]]+arr[j][2]);
                    //지름길이 나은지 순수 거리계산이 나은지 비교
                }
            }
        }
        System.out.println(dp[len]);
    }
}