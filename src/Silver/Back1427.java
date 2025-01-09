package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Back1427 { //거꾸로 정렬, 붙어있는 토큰 분류
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> number=new ArrayList<>();

        String input =bf.readLine();
        for(char c :input.toCharArray()){ //문자열로 변환
            number.add(c-'0'); // 문자를 숫자로 변환
        }

        number.sort(Comparator.reverseOrder());

        StringBuilder sb= new StringBuilder();
        for(Integer integer : number){
            System.out.print(integer +"");
        }
    }
}
