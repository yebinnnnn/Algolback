package Silver;
import java.io.*;
import java.util.*;

//이분 탐색, 매개변수 탐색<<?
public class Back2805 { //20억까지의 길이 (두번 이상 반복금지)
    public static int[] trees;
    public static int max;
    public static int takeLen;

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(bf.readLine());
        int treenum= Integer.parseInt(st.nextToken());
        takeLen=Integer.parseInt(st.nextToken());
        int height=0; //초기 전기톱 값

        trees= new int[treenum+1];
        max=0;
        st= new StringTokenizer(bf.readLine());
        for(int i=0; i<treenum; i++){ //배열에 트리길이 할당
            trees[i]=Integer.parseInt(st.nextToken());
            if(trees[i]>=max){
                max=trees[i]; //가장 길이가 긴 트리 하나 찾고
            }
        }
        //trees[i]-height 다 더하면 takeLen 과 비교가능.-> 이를 반영해서 height 에도 변화를 줘야한다.
        //그러면 결국 이중 반복이 되는데 이렇게 할 경우 시간초과.
        int size=trees.length/2;
        halfSearch(0, size); //num은 그냥 인덱스 시작
    }

    public static void halfSearch(int num, int size){
        for(int i=0; i<size; i++){

        }
    }
}
