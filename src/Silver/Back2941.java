package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back2941 { //띄어쓰기로 구분되지 않는건 StringToknizer 보다 CharAt 을 써야한다.
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        ArrayList<String> alphabets= new ArrayList<>();
        int i=0;
        int count=0;

        for(i =0; i<input.length(); i++){
            char word=input.charAt(i);
            if(word=='c' ||word=='s' ||word=='z'){
                if( i+1<input.length()&&(input.charAt(i+1)=='='||input.charAt(i+1)=='-')){
                    count++;
                    i++;
                    continue;
                }
            }
            if(word=='l'||word=='n'){
                if(i+1<input.length()&&input.charAt(i+1)=='j'){
                    count++;
                    i++;
                    continue;
                }
            }
            if(word=='d'){
                if(i+2<input.length()&&input.charAt(i+1)=='z'&&input.charAt(i+2)=='='){
                    count++;
                    i+=2;
                    continue; //continue 빼먹지 말기. 빼먹으면 뒤에 조건들도 걸려들어 다시 계산하게 됨.
                    //continue 를  넣어야 반복문 처음부터 다시 실행하게 된다. 안그러면 count++도 더해짐.
                }
                else if(i+1<input.length()&&input.charAt(i+1)=='-'){
                    count++;
                    i++;
                    continue;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
