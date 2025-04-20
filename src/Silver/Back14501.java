package Silver;
import java.util.*;
import java.io.*;

public class Back14501 {//케이스도 적고 2초라서 풀 탐색하는것도 가능해보이고, dp쓰는것도 가능해보임
    public static int[][] sch;
    public static int day;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        day = Integer.parseInt(bf.readLine());
        sch = new int[day + 1][2];
        for (int i = 0; i < day; i++) {
            //스케쥴 배정. 첫번째가 소요시간, 두번째가 금액
            st = new StringTokenizer(bf.readLine());
            sch[i][0] = Integer.parseInt(st.nextToken());
            sch[i][1] = Integer.parseInt(st.nextToken());
        }

        //암만 봐도 dp 같은데
        finding(0,0);
        System.out.println(max); //1day 가 아니라 0day 부터 시작임
    }

    public static void finding(int n, int sum) {
        if (n>day) { //날짜가 넘어가면 카운트 안됨.
            return;
        }
        if(n==day){
            max=Math.max(max,sum);
            return; //여기서 끝
        }
        if (n+sch[n][0] <= day){ //현재 날짜가 ㄱㅊ으면 날짜랑 돈 합산해서 넘겨주기
            finding(n+sch[n][0],sum+sch[n][1]); //먼저 탐색 중. 위의 두 조건 중 하나에 걸려서 max 저장 후 끝
        }
        finding(n+1, sum);//내려와서 다음날 경우 탐색
    }
}
