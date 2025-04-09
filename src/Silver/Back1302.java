package Silver;

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1302 { //카드랑 같은 문젠데 자료형만 바뀐...
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map=new HashMap<>();
        int sellbook=Integer.parseInt(bf.readLine());
        for(int i=0; i<sellbook; i++){
            String bookname=bf.readLine();
            if(map.containsKey(bookname)){
                map.put(bookname, map.get(bookname)+1);
            }else{
                map.put(bookname, 1);
            }
        }// map 에 저장
        int max=0;
        String maxbookname="";
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String thisname=entry.getKey();
            int count=entry.getValue();
            if(count>max){
               maxbookname=thisname;
               max=count;
            }else if(count==max){
                if(thisname.compareTo(maxbookname)<0){
                    maxbookname=thisname;
                }
            }
        }
        System.out.println(maxbookname);
    }
}
