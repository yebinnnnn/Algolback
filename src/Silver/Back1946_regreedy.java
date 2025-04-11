package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1946_regreedy {
    public static void main(String[] args) throws IOException {
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int testcase= Integer.parseInt(bf.readLine());
    StringBuilder sb= new StringBuilder();
    int[] resume;
    int[] interview;
        while(testcase-->0){
            int person=Integer.parseInt(bf.readLine());
            resume= new int[person+1];
            interview= new int[person+1];
            for(int i=1; i<=person; i++){
                st=new StringTokenizer(bf.readLine());
                resume[Integer.parseInt(st.nextToken())]=i;
                interview[Integer.parseInt(st.nextToken())]=i;
            }

            for(int i=1; i<=person; i++){
                if(res)
            }
        }
    }
}
