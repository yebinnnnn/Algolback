package Silver;
import java.util.*;
import java.io.*;

public class Back14501 {//케이스도 적고 2초라서 풀 탐색하는것도 가능해보이고, dp쓰는것도 가능해보임
    public static void main(String[] args)throws IOException{
        int[][] sch;
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int day=Integer.parseInt(bf.readLine());
        sch=new int[day+1][2];
        for(int i=0; i<day; i++){
            //스케쥴 배정
            st=new StringTokenizer(bf.readLine());
            sch[i][0]=Integer.parseInt(st.nextToken());
            sch[i][1]=Integer.parseInt(st.nextToken());
        }

        //암만 봐도 dp 같은데
        int max=0;
        for(int i=0; i<day; i++){
            int fee=sch[i][0];
            int count=0;
            for(int j=i; j<day; j++){
                if(j+count<day){
                    if(sch[j][0]+j>=sch[j+count][0] && sch[j][0]+j<day){
                        fee+=sch[j+1][1];
                        j=j+count;
                        count=0;
                    }else{
                        count++;
                    }
                }
            }
            max=Math.max(fee,max);
        }
        System.out.println(max);
    }
}
