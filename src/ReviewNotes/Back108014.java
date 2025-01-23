package ReviewNotes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Back108014 { //11650 과 비슷한 문제 (정렬 기준은 좀 다르다)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        String[][] users= new String[count][2];
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<count; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            users[i][0]=st.nextToken();
            users[i][1]=st.nextToken();
        }
        //정렬 이거 말고 쫌 할 수 있는 방법은 없나,,,, 없는 듯
        Arrays.sort(users, new Comparator<String[]>(){
            @Override
            public int compare(String[]o1, String[]o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(int i=0; i<count; i++){
            sb.append(users[i][0]).append(" ").append(users[i][1]).append("\n");
        }
        System.out.println(sb);

    }
}
