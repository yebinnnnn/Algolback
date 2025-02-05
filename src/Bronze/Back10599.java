package Bronze;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back10599 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] born= new int[2];
        int [] death= new int[2];
        StringBuilder sb= new StringBuilder();
        while(true){
            st= new StringTokenizer(bf.readLine());
            born[0]=Integer.parseInt(st.nextToken());
            born[1]=Integer.parseInt(st.nextToken());
            death[0]=Integer.parseInt(st.nextToken());
            death[1]=Integer.parseInt(st.nextToken());
            if(born[0]==0&&born[1]==0&&death[0]==0&&death[1]==0){
                break;
            }

            int older=Math.max(death[0],death[1])-Math.min(born[0],born[1]);
            int younger=Math.min(death[0],death[1])-Math.max(born[0],born[1]);
            sb.append(younger+" "+older).append("\n");
        }
        System.out.println(sb);
    }
}
