package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back1541_stringGreedy { //그리디 -> 탐욕 알고리즘. 순간순간 좋은걸 고르자 (탐색/브루트포스랑 어떻게 비교하지)
    public static void main(String[] args)throws IOException {
        String input;
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();
        ArrayList<String> list= new ArrayList<>();
        StringTokenizer st= new StringTokenizer(input,"-",true);//두 개 이상 구분자 사용 가능 먼저 뺄셈
        int i=0;
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
            i++;
        }
        int count=list.size();
        int sum=0;
        int total=0;
        String Take;
        for(int j=0; j<count; j++){
            sum=0;
            st=new StringTokenizer(list.get(j),"+");
            while(st.hasMoreTokens()){
                Take=st.nextToken();
                if(!Take.equals("-")){
                    sum+=Integer.parseInt(Take);
                }
            }
            if(j==0){
                total+=sum;
            }
            else {
                total -= sum;
            }
        }
        System.out.println(total);
        //반대로 생각함...최소로 만드는 식의 값을 구하려면
        //마이너스 기준으로 분리했을때 더하기 부터 전부해줘야 한다 -> 이걸 어케 앎?
    }
}
