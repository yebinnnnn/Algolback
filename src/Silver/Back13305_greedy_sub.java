package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back13305_greedy_sub {//이게 dp가 아니라곩..?
    static long[] roadScore;
    static long[] cityScore;
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int city=Integer.parseInt(bf.readLine());
        roadScore=new long[city-1];
        cityScore=new long[city]; //점수 저장
        st=new StringTokenizer(bf.readLine());
        for(int i=0; i<city-1; i++){
            roadScore[i]=Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0; i<city; i++){
            cityScore[i]=Long.parseLong(st.nextToken());
        }
        //입력 완료.

        long Fee=cityScore[0]*roadScore[0]; //최초로 필요한 기름값.
        for(int i=1; i<roadScore.length; i++){
            if(cityScore[i]*roadScore[i]>cityScore[i-1]*roadScore[i]){
                Fee+=cityScore[i-1]*roadScore[i];
                cityScore[i]=cityScore[i-1];
            }
            else{
                Fee+=cityScore[i]*roadScore[i];
            }
        }
        System.out.println(Fee);
    }
}
