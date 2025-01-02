package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int [] number = new int[count];
        for(int i =0; i<count; i++){
            number[i]=Integer.parseInt(bf.readLine());
        }
        Arrays.sort(number);
        for (Integer integer : number) {
            System.out.println(integer);
        }
    }
}
