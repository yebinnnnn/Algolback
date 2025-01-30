package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back9375_Map_Combi {//해시맵 + 조합
    static HashMap<String, Boolean> visited=new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases= Integer.parseInt(bf.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        while(cases-- >0){
            int n= Integer.parseInt(bf.readLine());
            HashMap<String, Integer> cloth= new HashMap<>();

            while(n-- >0){
                st= new StringTokenizer(bf.readLine());
                st.nextToken();
                String kinds= st.nextToken();

                if(cloth.containsKey(kinds)){
                    cloth.put(kinds,cloth.get(kinds)+1);
                }
                else{
                    cloth.put(kinds,1);
                }
            }
            int result=1;
            for(int val: cloth.values()){
                result*=(val+1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}
