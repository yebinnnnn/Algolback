package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class Back18870_Compression {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bf.readLine());
        int[] point=new int[num];
        HashSet<Integer> set=new HashSet<>();
        StringTokenizer st= new StringTokenizer(bf.readLine());
        for(int i=0;i<num;i++){
            point[i]=Integer.parseInt(st.nextToken());
            set.add(point[i]);
        }
        StringBuffer sb=new StringBuffer();
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),i);
        }
        for(int i=0;i<num;i++){
            sb.append(map.get(point[i])).append(" ");
        }
        System.out.println(sb);
    }
}
