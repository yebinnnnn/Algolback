package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Back11650 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int[][] array = new int [number][2];
        for(int i=0; i<number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0]=Integer.parseInt(st.nextToken());
            array[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                else{
                    return o1[0]-o2[0];
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number; i++) {
            sb.append(array[i][0]).append(" ");
            sb.append(array[i][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
