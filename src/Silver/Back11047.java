package Silver;
import java.util.*;
import java.io.*;

public class Back11047 { //그 다음 값은 그 전 값의 배수이다.
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int coin= Integer.parseInt(st.nextToken());
        int money= Integer.parseInt(st.nextToken());//우리가 만들어야 하는 가치

        int[] pocket= new int[coin];
        //int[] count = new int[1000001];
        for(int i=0; i<coin; i++){
            pocket[i]=Integer.parseInt(bf.readLine());
        }

        int count=0;
        for(int i=coin-1; i>=0; i--){
            if(money>=pocket[i]){
                count+=money/pocket[i];
                money%=pocket[i];
            }
        }

        System.out.println(count);

    }
}
