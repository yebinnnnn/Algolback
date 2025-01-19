package ReviewNotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Back1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int D = Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        HashSet<String> DD= new HashSet<>();
        String[] BoBo = new String[B];

        for(int i=0; i<(D); i++){
            DD.add(bf.readLine());
        }

        StringBuilder sb= new StringBuilder();
        int count=0;

        for(int i=0; i<(B); i++){
            BoBo[i]=(bf.readLine());
        }

        Arrays.sort(BoBo);

        for(int i=0; i<(B); i++){
            if(DD.contains(String.valueOf(BoBo[i]))){
                sb.append(BoBo[i]).append("\n");
                count++;
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
