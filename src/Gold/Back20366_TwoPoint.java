package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Back20366_TwoPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        int[] snow=new int[n];
        int min=Integer.MAX_VALUE;
        StringTokenizer st= new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++){
            snow[i]=Integer.parseInt(st.nextToken());
        }
        //눈덩이 입력 완. 두포인터를 뽑아야 하나? 정렬부터 해야하나?
        Arrays.sort(snow);//오름차순으로 정렬
        List<Integer> pair=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(snow[i]>snow[j]){
                    pair.add(snow[i]);
                }
            }
        }//모든 페어쌍 리스트에 추가한 다음에 오름차순 정렬
        pair.sort(Comparator.naturalOrder());
        int start=0; int end=pair.size()-1;
        while(start<=end){//여기서 포인터 탐색하면서 min 갱신 후 인덱스가 겹치는지 검사해야함

        }

        System.out.println(min);
    }
}
