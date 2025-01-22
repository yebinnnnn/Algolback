package Bronze;

import java.io.*;
import java.util.*;

public class Back11050 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int topout=1;
        int downout=1;

        for(int i=first; i>first-second;i--){
            topout*=i;
        }
        for(int j=second; j>0; j--){
            downout*=j;
        }
        if(second==0){
            downout=1;
        }
        System.out.println(topout/downout);

    }
}
