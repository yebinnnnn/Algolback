package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//사각 경로로만 사과를 딸 수 있음
public class Back20002_prefix {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bf.readLine());
        int[][] map=new int[num][num];
        int[][] pre=new int[num][num];
        //밭에 점수 배정
        for(int i=0; i<num; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            for(int j=0; j<num; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

    }
}
