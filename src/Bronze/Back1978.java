package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1978 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int number=Integer.parseInt(bf.readLine());
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int[] array=new int[number];
        int count=0;

        for(int i=0; i<number; i++){
            array[i]=Integer.parseInt(st.nextToken());
            if(array[i]==1){
                count++;
            }
            for(int j=array[i]-1; j>1; j--){
                if(array[i]%j==0){
                    count++;
                    break;
                }
            }
        }
        System.out.println(number-count);

    }
}
