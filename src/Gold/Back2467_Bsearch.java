package Gold;

import java.io.IOException;
import java.io.*;
import java.util.*;
public class Back2467_Bsearch {
    //주어진 수를 보아하니 절대 이중탐색은 못돌리는 구조...
    public static int[] solution;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        solution=new int[n];
        //오름차순으로 주어진다.
        StringTokenizer st=new StringTokenizer(bf.readLine());;
        for(int i=0; i<n; i++){
            solution[i]=Integer.parseInt(st.nextToken());
        }
        //배열을 가르키는 두 포인터를 만든다.
        int startpoint=0, start=0;
        int endpoint=n-1, end=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(startpoint<endpoint){
            sum=solution[startpoint]+solution[endpoint];
            if(min>Math.abs(sum)){
                min=Math.abs(sum);
                end=endpoint;
                start=startpoint;
            }
            if(sum>0){
                endpoint--;
            }
            else if(sum<0){
                startpoint++;
            }
            else{
                break;
            }
        }
        System.out.println(solution[start]+" "+solution[end]);
    }
}
