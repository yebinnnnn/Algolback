package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back1018 { //두배열 비교, 8X8 배열 완전탐색
    public static boolean[][] arr;
    public static int min=64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int garo= Integer.parseInt(st.nextToken());
        int sero= Integer.parseInt(st.nextToken());

        arr = new boolean[garo][sero];

        for(int i=0;i<garo;i++){
            String str=br.readLine();
            for(int j=0;j<sero;j++){
                if(str.charAt(j)=='W'){
                    arr[i][j]=true;
                }
                else{
                    arr[i][j]=false;
                }
            }
        }
        int row=garo-7;
        int col=sero-7;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                find(i,j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y){
        int endx=x+8;
        int endy=y+8;
        int count=0;

        boolean TF=arr[x][y];

        for(int i=x; i<endx; i++){
            for(int j=y; j<endy; j++){
                if(arr[i][j]!=TF){
                    count++;
                }
                TF=(!TF);
            }
            TF=(!TF);
        }
        count=Math.min(count, 64-count); //반대랑 고른뒤에
        min=Math.min(min, count); //현재 min 과 비교해서 min 고르기
    }
}
