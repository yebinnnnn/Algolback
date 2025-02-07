package Silver;
import java.io.*;
import java.util.*;

//문자열을 연속하게 할 최소의 교환횟수
public class Back21921_slidingWindow {//슬라이딩 윈도우 . 브루트 포스 알고리즘
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // N=블로그 일 수
        int X= Integer.parseInt(st.nextToken()); //X 일 동안
        int [] people = new int[N]; //전체 방문자 저장수
        int [] range= new int[X]; //저장할 윈도우 수
        int sum=0;
        int max=0;
        int same=1;
        StringBuilder sb= new StringBuilder();
        st=new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++){
            people[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<X; i++){
            range[i]=people[i];
            sum+=range[i];
        }
        max=sum;
        for(int i=0; i<N-X; i++){ //N-X=3, X=2
            sum-=people[i];
            sum+=people[i+X];
            if(sum>max){
                max=sum;
                same=1;
            }
            else if(sum==max){
                same++;
            }
        }
        if(max==0){
            sb.append("SAD").append("\n");
        }
        else{
            sb.append(max).append("\n");
            sb.append(same);
        }
        System.out.println(sb);
    }
}
