package Silver;
import java.util.*;
import java.io.*;

public class Back11047 { //그 다음 값은 그 전 값의 배수이다.
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int coin= Integer.parseInt(st.nextToken());
        int money= Integer.parseInt(st.nextToken());//우리가 만들어야 하는 가치
        //배수 조건이 있으면 쉬울거 같은데...?
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

//        for(int i=coin-1; i>=0; i--){
//            if(money/pocket[i]!=0&&money-(money/pocket[i])*pocket[i]>=0){ //빼도 0이상 이라면
//                count[pocket[i]]=money/pocket[i];
//                money-=((money/pocket[i])*pocket[i]);
//            }
//            if(money==0){
//                break;
//            }
//        }
//        //괜히 꼬아서 함... 걍 count array 없이 즉석으로 더해도 된다.
//        int result=0;
//        for (int j : count) {
//            result += j;
//        }
//        System.out.println(result);
    }
}
