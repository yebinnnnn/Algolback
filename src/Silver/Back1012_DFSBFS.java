package Silver;
import java.io.*;
import java.util.*;

public class Back1012_DFSBFS {//배추 애벌래 탐색 응용 문제
    static int [][] arr; //위치 저장용
    static boolean [][] check; //관계 체크용
    static int node; //배추의 갯수
    static int horizontal;
    static int vertical;
    static int count;
    //주어지는 것: 배추의 좌표

    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int testcase= Integer.parseInt(bf.readLine()); //띵~~
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<testcase; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            horizontal= Integer.parseInt(st.nextToken());
            vertical= Integer.parseInt(st.nextToken());
            node= Integer.parseInt(st.nextToken());
            arr=new int[vertical+1][horizontal+1];
            count=0;
            check=new boolean[vertical+1][horizontal+1];
            int a=0;
            int b=0;

            for(int j=0; j<node; j++) {
                st = new StringTokenizer(bf.readLine());
                b = Integer.parseInt(st.nextToken()); //a 가 가로를 나타내는 거임 슈발;;
                a = Integer.parseInt(st.nextToken());
                arr[a][b]=1; //입력의 의도대로 좌표에 입력완료
            }
            a=0;
            b=0;
            while(true){
                System.out.println("check for:"+a+" "+b);
                if(!check[a][b]&&arr[a][b]==1){
                    dfs(a,b);
                    count++;
                }
                if(b+1==horizontal){
                    b=0;
                    if(a+1==vertical){
                        break;
                    }
                    a++;
                }
                else{
                    b++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int a, int b){
        check[a][b]=true;
        System.out.println("dfs 들어온좌표"+a+" "+b);

        if(a+1<=vertical&&!check[a+1][b]&&arr[a+1][b]==1){
            dfs(a+1,b);
        }
        if(a-1>=0&&!check[a-1][b]&&arr[a-1][b]==1){
            dfs(a-1,b);
        }
        if(b+1<=horizontal&&!check[a][b+1]&&arr[a][b+1]==1){
            dfs(a,b+1);
        }
        if(b-1>=0&&!check[a][b-1]&&arr[a][b-1]==1){
            dfs(a,b-1);
        }
    }
}
