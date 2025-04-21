package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back15649_Tracking {//이거의 조합버전이 로또 문제!
    //static 공간을 이렇게 많이 써도 되나 우려가됩니다...
    static boolean [] checking;
    static int[] answer;
    static int n;
    static int cases;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken()); //1에서N 까지
        cases=Integer.parseInt(st.nextToken());//cases만큼만 뽑을것
        checking=new boolean[n+1];
        answer=new int[cases+1];
        Tracking(0);
        System.out.println(sb);
    }
    public static void Tracking(int depth){
        if(depth==cases){
            for(int i=0; i<cases; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(depth<n){
            for(int i=1;i<=n;i++){
                if(!checking[i]){
                    checking[i]=true;
                    answer[depth]=i;
                    Tracking(depth+1);
                    checking[i]=false;
                }
            }
        }
    }
}
