package Silver;
import java.util.*;
import java.io.*;

public class Back9461 {
    public static long[] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases= Integer.parseInt(bf.readLine());
        triangle= new long[107];
        triangle[0]=triangle[1]=triangle[2]=triangle[3]=0;
        triangle[4]=triangle[5]=triangle[6] =1;
        triangle[7]=2;
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<cases; i++){
            int number= Integer.parseInt(bf.readLine());
            sb.append(founding(number)).append("\n");
        }
        System.out.println(sb);

    }
    public static long founding(int number){
        for(int k=8; k<number+4; k++){
            triangle[k]=triangle[k-1]+triangle[k-5];
        }
        return triangle[number+3];
    }
}
