package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back22857_TwoPoint {
    public static void main(String[] args) throws IOException {
        int max=Integer.MIN_VALUE;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int num= Integer.parseInt(st.nextToken());
        int count= Integer.parseInt(st.nextToken()); //이만큼 삭제할 수 있다.
        int[] numbers=new int[num];
        int[] dp=new int[num]; //결국...dp인가
        st=new StringTokenizer(br.readLine());//수열 받음
        for(int i=0;i<num; i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }//입력완료
        int start=0, end=num-1;
        int notcount=0;
        while(start<end){

        }
        System.out.println(max);
    }
}
