package Silver;
import java.util.*;
import java.io.*;

public class Back2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int stairs=Integer.parseInt(bf.readLine());
        int[] scores= new int[stairs+1];
        scores[0]=0;

        int[] best=new int[stairs+1];
        best[0]=0;

        int step=0;
        for(int i=1; i<=stairs; i++){
            scores[i]=Integer.parseInt(bf.readLine());
        }

        for(int k=1; k<=5; k++){
            if(k+2==stairs&&step==1){
                best[k]=scores[k+2]+best[k-1];
            }
            else if(k+1==stairs){
                best[k]=scores[k+1]+best[k-1];
            }
            else if(scores[k+1]>=scores[k+2]&&step<=2){
                best[k]=scores[k+1]+best[k]+best[k-1];
                step++;
            }
            else if(scores[k+2]>=scores[k+1]){
                best[k]=scores[k+2]+best[k]+best[k-1];
                step=1;
            }
        }
        System.out.println(best[stairs]);
    }
}
