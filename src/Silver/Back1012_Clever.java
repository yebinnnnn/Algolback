package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1012_Clever { //좌표 넣는 부분이 노가다였어서 그 부분 고치기
    static int [][] arr; //위치 저장용
    static boolean [][] check; //관계 체크용
    static int node; //배추의 갯수
    static int horizontal;
    static int vertical;
    static int count;
    //주어지는 것: 배추의 좌표

    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int testcase= Integer.parseInt(bf.readLine()); //띵~~
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;

        for(int i=0; i<testcase; i++){
            st= new StringTokenizer(bf.readLine());
            horizontal= Integer.parseInt(st.nextToken());
            vertical= Integer.parseInt(st.nextToken());
            node= Integer.parseInt(st.nextToken());
            arr=new int[horizontal+1][vertical+1];
            count=0;
            check=new boolean[horizontal+1][vertical+1];

            int a=0;
            int b=0;

            for(int j=0; j<node; j++) {
                st = new StringTokenizer(bf.readLine());
                a = Integer.parseInt(st.nextToken()); //a 가 가로를 나타내는 거임 슈발;;
                b = Integer.parseInt(st.nextToken());
                arr[a][b]=1; //입력의 의도대로 좌표에 입력완료
            }

            for(a=0; a<horizontal; a++) {
                for(b=0; b<vertical; b++) {
                    if(!check[a][b]&&arr[a][b]==1){
                        dfs(a,b);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int a, int b){
        check[a][b]=true;
        //좌표 고치는 부분
        int[] X={0,0,-1,+1};
        int[] Y={-1,+1,0,0};

        for(int i=0; i<4; i++){
            int x= a+X[i];
            int y= b+Y[i];
            //여기도 조건체크가 좀 ...ㅋㅋㅋㅋ
            if(x<0 || x>=horizontal || y<0 || y>=vertical){
                continue; //패스하고 위에 걸로 다시(조건한번에 걸어줌)
            }
            if(arr[x][y]==1&!check[x][y]){
                dfs(x,y);
            }
        }
    }
}
