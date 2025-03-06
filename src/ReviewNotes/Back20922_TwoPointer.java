package ReviewNotes;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back20922_TwoPointer { //투포인터나 슬라이딩 윈도우, 카운터 배열
    //카운트 배열 외에 ArrayList 로 해결하는 법
    //이게 투포인터 문제 구나!!!
    public static int [] inarray;
    public static int [] counter;
    public static ArrayList<Integer> search= new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        inarray=new int[N];
        counter=new int[200001];
        //수열 입력
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            inarray[i]=Integer.parseInt(st.nextToken());
        }

        int start=0; //시작 포인터
        int end=0;//끝 포인터
        int max=0;

        while(end<N&&start<N) {

            int endnum=inarray[end];
            counter[endnum]++;

            while(counter[endnum]>K){
                counter[inarray[start]]--; //초기화 없이 빠져나가는 처리
                start++;
            }
            max=Math.max(max,end-start+1);
            end++;
        }
        System.out.println(max);
    }
}
