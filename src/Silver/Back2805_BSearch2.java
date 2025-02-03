package Silver;
import java.io.*;
import java.util.*;

//이분 탐색, 매개변수 탐색<<?
public class Back2805_BSearch2 { //20억까지의 길이 (두번 이상 반복금지)
    public static long[] trees;
    public static long max;
    public static long wantLen;

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(bf.readLine());
        int treenum= Integer.parseInt(st.nextToken());
        wantLen=Integer.parseInt(st.nextToken());
        int height=0; //초기 전기톱 값

        trees= new long[treenum+1];
        max=0;
        st= new StringTokenizer(bf.readLine());
        for(int i=0; i<treenum; i++){ //배열에 트리길이 할당
            trees[i]=Long.parseLong(st.nextToken());
            if(trees[i]>=max){
                max=trees[i]; //가장 길이가 긴 트리 하나 찾고
            }
        }

        long min=0;
        long mid;
        long takelen;

        while(min<max){
            takelen=0;
            mid=(max+min)/2;

            for(int k=0; k<trees.length; k++){
                if(trees[k]>=mid){
                    takelen+=trees[k]-mid;
                }
            }

            if(takelen<wantLen){ //원하는 길이 만큼 나오지 않았다. -> 자를 height 더 낮추기
                //System.out.println("원하는 길이 만큼 안잘렸다.");
                max=mid;
            }
            else{ //원하는 길이 만큼 나왔다. 높이를 더 높일 수 있을까?
                //System.out.println("원하는 길이만큼 잘렸다.");
                min=mid+1; //하한을 확 올려야 시간초과에 안걸린다;;
            }
        }

        System.out.println(max-1);
    }
}
