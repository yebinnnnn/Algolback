package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back11652_Card {
    public static HashMap<Long, Long> map=new HashMap<>();
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine()); //카드의 갯수
        while(n-->0){
            Long thisnum=Long.parseLong(bf.readLine());
            if(map.containsKey(thisnum)){
                map.put(thisnum, map.get(thisnum)+1);
            }
            else{
                map.put(thisnum, 1L);
            }
        }

        long max=0;
        long answer=Long.MAX_VALUE;
        for(Map.Entry<Long,Long> enrty:map.entrySet()){
            long key=enrty.getKey();
            long value=enrty.getValue();

            if(value>max){
                max=value;
                answer=key;
            }else if(value==max){
                answer=Math.min(answer,key);
            }
        }
        System.out.println(answer);
    }
}
