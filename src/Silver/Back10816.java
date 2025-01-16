package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Back10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstnum= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map1=new HashMap<>();
        int thisnum =0;

        for(int i=0; i<firstnum; i++){
            thisnum=Integer.parseInt(st.nextToken());
            if(map1.containsKey(thisnum)){
                map1.put(thisnum, map1.get(thisnum)+1);
            }
            else{
                map1.put(thisnum, 1);
            }
        }

        int secondnum= Integer.parseInt(br.readLine());
        int[] map2=new int[secondnum];
        StringTokenizer st2=new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<secondnum; i++){
            map2[i]=(Integer.parseInt(st2.nextToken()));
            map1.putIfAbsent(map2[i], 0); //이 매서드 몰랐음
            sb.append(map1.get(map2[i])).append(" ");
        }
        System.out.println(sb);

    }
}
