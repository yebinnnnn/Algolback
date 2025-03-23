package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back14425_String {
    public static HashMap<String,Integer> hs=new HashMap<>();

    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int correct = Integer.parseInt(st.nextToken());//사전
        int compare= Integer.parseInt(st.nextToken());//비교군
        for (int i=0; i<correct; i++){
            hs.put(bf.readLine(),i);
        }
        int count=0;
        for(int i=0; i<compare; i++){
            if(hs.containsKey(bf.readLine())){
                count++;
            }
        }
        System.out.println(count);
    }
}
