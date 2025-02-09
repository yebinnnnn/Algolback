package Bronze;
import java.util.*;
import java.io.*;

public class Back2231 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int sum=0;
        int thisnum=0;
        StringBuilder sb= new StringBuilder();

        for(int i=1;i<=N;i++){
            thisnum=sum=i;
            while(thisnum>0){
                sum+=thisnum%10;
                thisnum=thisnum/10;
            }
            if(sum==N){
                sb.append(i);
                break;
            }
            else if(i==N-1||N==1){
                sb.append(0);
                break;
            }
        }
        System.out.println(sb);
    }
}
