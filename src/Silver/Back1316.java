package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Back1316 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        String[][] words= new String[number][];

        for (int i=0; i<number; i++) {
            String line = bf.readLine();
            words[i] = new String[line.length()];//각 행 문자열 초기화
            for (int j=0;j<line.length();j++){
                words[i][j] = String.valueOf(line.charAt(j));
            }
        }

        ArrayList<String> check= new ArrayList<>();
        int count=1;
        int answer=0;
        for(int i=0; i<number; i++){//bad 의 경우. check에 b,a,d 들어감.
            count=1;
            check.clear();
            check.add(words[i][0]);
            for(int j=0; j<words[i].length; j++){
                if(!check.contains(words[i][j])&& !words[i][j].equals(words[i][j-1])){
                    check.add(words[i][j]);
                    count++;
                }
                else if(check.contains(words[i][j])&& j!=0&& !words[i][j].equals(words[i][j-1])){
                    count++;
                }
            }
            if(Arrays.stream(words[i]).distinct().count()!=count){
                answer++;
            }
//            System.out.println(Arrays.stream(words[i]).distinct().count());
//            System.out.println(count);
        }
        System.out.println(number-answer);
    }
}
