package Silver;

import java.io.*;

public class Back4673 { //셀프넘버만 구하기...
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number;
        int sum;
        int count=0;
        for(int i=1; i<=10000; i++){ //찾을 대상 i
            count=0;
            for(int j=i-1; j>0; j--){ //i 와 비교할 대상 j (i 보다 작은 모든 숫자 중)
                number=j;
                sum = number;
                while(number>0){
                    sum+=number%10;
                    number=number/10;
                }
                if(sum==i){
                    count++;
                }
            }
            if(count==0){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
