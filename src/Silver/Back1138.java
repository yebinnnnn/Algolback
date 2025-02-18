package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back1138 { //N이 10까지 밖에 안된다. 이중포문은 쓸 수 있을 거 같다. 아주 살짝 그리디. 빡구현에 가까움.
    public static int [] array;
    public static ArrayList<Integer> rows;
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bf.readLine());
        array= new int[num+1];
        rows= new ArrayList<>();

        StringTokenizer st= new StringTokenizer(bf.readLine());
        for(int i=1; i<=num; i++){
            array[i]=Integer.parseInt(st.nextToken());
            rows.add(i-1,0);
        }
        //맨처음 1 의 숫자는 그 인덱스에 1이 위치함을 알 수 있다.
        //2는 1을 제외하고 카운트 했을때 그 위치에 존재한다.
        //3도 마찬가지
        //4도 마찬가지다.(마지막 키가 되면 항상 0이다.)
        int someone=0; //나보다 키가 작은 누군가가 있다.

        for(int i=1; i<=num; i++){
            someone=0;
            for(int j=0; j<=num; j++){
                if(rows.get(j)!=0){
                    someone++; //누군가 그 자리에 채워져 있으면 someone 이 플러스 된다.
                }
                if(j-someone==array[i]){
                    break;
                }
            }
            while(rows.get(array[i]+someone)!=0){
                someone++;
            }
            rows.set(array[i]+someone, i);
            //System.out.println("입력 인원:"+i+"입력 인덱스:"+ (array[i]+someone)+"내 앞의 사람 수"+someone);
        }

        for(int people: rows){
            System.out.print(people+" ");
        }
    }
}
