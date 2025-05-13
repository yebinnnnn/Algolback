package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//사각 경로로만 사과를 딸 수 있음
//2차원 누적합, 올탐색 문제
public class Back20002_prefix {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bf.readLine());
        int[][] map=new int[num+1][num+1];
        int[][] pre=new int[num+1][num+1];
        int max= Integer.MIN_VALUE;
        //밭에 점수 배정하면서 누적합 배정
        for(int i=1; i<=num; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            for(int j=1; j<=num; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                //2차원방식 누적합 저장
                pre[i][j] = pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1] + map[i][j];
            }
        }
        for(int i=1; i<=num; i++){ //0~부터 num까지칸의 사이즈
            for(int j=i; j<=num; j++){ //엔드포인트 세로 좌표
                for(int k=i; k<=num; k++){ //엔드포인트 가로 좌표
                    int thisnum=pre[j][k]-pre[j-i][k]-pre[j][k-i]+pre[j-i][k-i];
                    max=Math.max(max,thisnum);
                }
            }
        }
        System.out.println(max);
    }
}
