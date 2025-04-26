package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back2805Re {
    public static int[] trees;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int treenum= Integer.parseInt(st.nextToken());
        trees=new int[treenum];
        long length= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        long mid=0, max=0;
        long min=0;
        for(int i=0;i<treenum; i++){
            trees[i]= Integer.parseInt(st.nextToken());
            max=Math.max(max,trees[i]);
        }
        //이분캄색. mid, min, max 를 정해서 범위를 좁혀가며 탐색해야 한다.
        //"적어도" length 의 나무를 가져가면서 최대한 나무를 덜 자르려고 하는것.
        //나무 높이의 합은 항상 length 보다 크거나 같다.
        long takelength=0;

        while(min<max){
            takelength=0;// 가져가는 나무 값 초기화
            mid=(min+max)/2; //일단 max와 min 의 중간값부터 서치 하는것.
            for(long len : trees){
                if(len>= mid){
                    takelength+=(len-mid);
                }//자른값보다 큰 나무인 경우에만 자르는 나무값에 더해줌
            }
            //이제 자른 값으로 판별
            if(takelength>=length){//얻은 길이가 충분한데?
                min=mid+1; //절단기를 더 높여도 되겠다.
            }else{//아직 부족해. (절단기를 더 낮추자.)
                max=mid;
            }
        }
        //절단기 높이의 최댓값 출력
        System.out.println(max-1);
    }
}
