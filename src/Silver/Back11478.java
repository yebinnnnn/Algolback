package Silver;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back11478 {//문자열 자르기. 부분 부분 자르는게 아니라 붙어있게 잘라야함. 단어 길이는 1000이하.
    static HashSet<String> set=new HashSet<>();
    //셋은 중복 저장하지 않음
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String words=bf.readLine();
        int size=words.length();
        int tempsize=size;
        //문자열 메소드
        while(tempsize-->0){
            for(int i=0; i<=size-tempsize; i++){
                set.add(words.substring(i,i+tempsize)); //startIndex, endIndex
            }
        }
        System.out.println(set.size());
    }
}
