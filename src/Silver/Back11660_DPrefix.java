package Silver;
import java.util.*;
import java.io.*;

public class Back11660_DPrefix {
    public static int[][] map;
    public static int[][] prefix;
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int n=Integer.parseInt(st.nextToken());
        int cases= Integer.parseInt(st.nextToken());
        map= new int[n][n];
        prefix=new int[n][n];

        for(int i=0; i<n; i++){ //누적합 저장과 배열 저장
            st=new StringTokenizer(bf.readLine());
            prefix[i][0]=0;
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(j>=1){ //인덱스 안넘어가게 저장
                    prefix[i][j]=prefix[i][j-1]+map[i][j];
                }else{
                    prefix[i][j]=map[i][j];
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        int sum=0;
        while(cases-->0){ //case 만큼 돌리기
            sum=0;
            int x1, x2, y1, y2; //범위 저장
            st=new StringTokenizer(bf.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());

            for(int i=x1-1;i<x2; i++){
                if(y1-2>=0){
                    sum+=(prefix[i][y2-1]-prefix[i][y1-2]);
                    //System.out.println("현재합:"+i+sum);
                }
                else{
                    sum+=prefix[i][y2-1];
                    //System.out.println("현재합:"+i+sum);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
