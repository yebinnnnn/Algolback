package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back11659_prefixSum { //이중포문 안되네..ㅋ 누적합 기법으로 구해야 함
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(bf.readLine());
        int number= Integer.parseInt(st.nextToken());//숫자의 개수
        int cases= Integer.parseInt(st.nextToken());//구할 누적합 케이스 개수
        int[] numbers=new int[number+1];//숫자 넣을 배열
        int[] prefix =new int[number+1]; //구간 합 배열

        st=new StringTokenizer(bf.readLine()); //배열 할당하기
        numbers[0]=0;
        prefix[0]=0;
        for(int i=1;i<=number;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
            prefix[i]=numbers[i]+prefix[i-1];
        }

        //누적합 구하기
        StringBuilder sb= new StringBuilder();
        while(cases-->0){
            int sum=0;
            st= new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            if(end==start){
                sum=numbers[start];
            }
            else {
                sum = prefix[end]-prefix[start-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
