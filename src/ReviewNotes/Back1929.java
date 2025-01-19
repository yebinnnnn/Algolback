package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back1929 { //역시 이중반복문을 쓰면 시간초과 되는 문제 ~ 에라토스테네스의 체
    public static boolean[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int start= Integer.parseInt(st.nextToken());
        int end= Integer.parseInt(st.nextToken());
        array= new boolean[end+1];
        isnumber();
        for(int i=start; i<=end; i++){ //기본배열들은 false상태.
            if(!array[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
    public static void isnumber(){
        array[0]=array[1]=true;
        for(int i=0; i<=Math.sqrt(array.length); i++){ //제곱을 초과하지 않는 값의 배수까지만 고려
            if(array[i]) continue; //true 일때 컨티뉴
            for(int j=i*i; j<array.length; j+=i){ //j값은 i 를 더하면서 증가. 특정 n 의 제곱의 배수들 다 false 로 부여해주는것.
                array[j]=true;
            }
        }
    }
}
