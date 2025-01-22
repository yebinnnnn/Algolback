package Bronze;
import java.io.*;
import java.util.*;

public class Back2609 { //최대공약,최소공배 같이 나눠지는 최대의 수 & 같은 배수중 최소
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int max=0;
        int min=0;
        int answermax=0;
        int answermin=0;
        if(n>=m){
            max=n;
            min=m;
        }
        else{
            max=m;
            min=n;
        }

        for(int i=min; i>0; i--){
            if(min%i==0&&max%i==0){
                answermin=i;
                break;
            }
        }
        for(int j=min; j<=n*m; j++){
            if(j%min==0&&j%max==0){
                answermax=j;
                break;
            }
        }
        System.out.println(answermin);
        System.out.println(answermax);
    }
}
