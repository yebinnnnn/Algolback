package Silver;

import java.io.*;
import java.util.*;

public class Back1065 { //각 자리수 분리 시스템 (매우 흔함)
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String input=bf.readLine();

        int number=Integer.parseInt(input);
        int count=0;

        for(int i=1; i<=number; i++){
            int digits=(int)Math.log10(i)+1;
            int thisnum=i;
            int[] array= new int [digits];

            for(int j=0; j<digits; j++){
                array[j]=thisnum%10;
                thisnum=thisnum/10;
                //0,1까지는 프리패스. j가 2일때 부터 고려해야하고 3인 경우는 1000밖에 없다.
                if(j>1 && j==digits-1){
                    if(array[j]-array[j-1]!=array[j-1]-array[j-2]){
                        break;
                    }
                    else{
                        count++;
                        break;
                    }
                }
                else if(j==digits-1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
