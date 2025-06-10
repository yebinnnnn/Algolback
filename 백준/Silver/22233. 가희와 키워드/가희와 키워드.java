
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int memo=Integer.parseInt(st.nextToken());
        int write=Integer.parseInt(st.nextToken());

        HashSet<String> list= new HashSet<>(); //키워드들
        for(int i=0;i<memo;i++){
            list.add(bf.readLine());
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<write;i++){
            //한줄 들어올때 마다 split 으로 받음
            String[] keyword=bf.readLine().split(",");
            for(int j=0;j<keyword.length;j++){
                list.remove(keyword[j]); //없으면 자동으로 넘어감. (contains 검사 불필요)
            }
            sb.append(list.size()).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
