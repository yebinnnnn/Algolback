package Gold;
import java.io.*;
import java.util.*;

public class Back1931_greedyArrays {//그리디, 정렬. 회의가 겹치지 않으면서 최대한 많은 회의를 할 수 있어야 한다.
    public static int[][] Confer;
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(bf.readLine());//N=주어진 회의 갯수
        StringTokenizer st;
        Confer= new int[N][3];
        for(int i=0; i<N; i++){
            st= new StringTokenizer(bf.readLine());
            Confer[i][0]=Integer.parseInt(st.nextToken());
            Confer[i][1]=Integer.parseInt(st.nextToken());

        }
        Arrays.sort(Confer, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]){//끝나는 시간 기준 정렬 (같으면 시작시간순)
                    return a[0]-b[0];
                }
                else{
                    return a[1]-b[1];
                }
            }
        });
        int end=Confer[0][1];
        int count=1; //회의 수
        for(int i=0; i<N-1; i++){
            if(Confer[i+1][0]>=end){
                end=Confer[i+1][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
