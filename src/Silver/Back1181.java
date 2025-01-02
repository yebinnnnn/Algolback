package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Back1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int number= 0;
        number=Integer.parseInt(bf.readLine());
        String[] words= new String[number];

        for(int i=0; i<number; i++){
            words[i]=bf.readLine();
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o1.length()-o2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append("\n");

        for (int i = 1; i<number; i++){
            if(!words[i].equals(words[i-1])){
                sb.append(words[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
