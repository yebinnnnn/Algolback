package Gold;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Back16496 {
    public static void main(String[] args) throws IOException {
        String [] number;
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        number=new String[num];

        for(int i=0; i<num; i++){
            number[i]=st.nextToken();
        }
        //String 도 이 비교가 되네
        //앞뒤 연결 숫자중 어떤게 더 큰가 비교
        Arrays.sort(number,new Comparator<String>()
        {
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });

        //0 예외처리를 해줘야함,,,
        if(number[0].equals("0")) {
            System.out.println("0");
            return;
        }

        StringBuilder sb= new StringBuilder();
        for(String s:number){
            sb.append(s);
        }
        System.out.println(sb);
    }
}
