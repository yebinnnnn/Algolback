package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;


public class Back17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        HashMap<String, String> key= new HashMap<>();
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<N; i++){
            st=new StringTokenizer(bf.readLine());
            key.put(st.nextToken(), st.nextToken());
        }
        for(int j=0; j<M; j++){
            sb.append(key.get(bf.readLine())).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
