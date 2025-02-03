package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back2654_BinarySearch {//랜선 자르기. 이분탐색 문제 -> Upper Bound
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(bf.readLine());
        int my=Integer.parseInt(st.nextToken());
        int num= Integer.parseInt(st.nextToken()); //얻고 싶은 랜선의 수
        long[] len= new long[my];
        long max=0; //이분법에서 사용될 최댓값

        for(int i=0; i<my; i++){
            len[i]=Integer.parseInt(bf.readLine());
            if(max<=len[i]){
                max=len[i];
            }
        }
        //이분법 시작. mid 값을 구해야한다
        max++;
        long min=0;
        long mid=0;

        while(min<max){
            mid=(min+max)/2;
            long count=0;

            for(int k=0; k<len.length; k++){
                count+=(len[k]/mid);
            }
            if(count<num){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }

        System.out.println(min-1);
    }
}
