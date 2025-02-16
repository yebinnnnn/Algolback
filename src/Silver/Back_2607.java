package Silver;
import java.util.*;
import java.io.*;

public class Back_2607 {
    public static void main(String[] args) throws IOException {
        String first = "";
        char[] letts;
        HashMap<Character, Integer> word= new HashMap<>();

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        letts=new char[10];
        int count=0;
        int check;
        int length;

        for(int i=0; i<n; i++){
            check=0;
            length=0;

            letts=bf.readLine().toCharArray();
            if(i==0){ //최초 입력되는 단어일 경우
                first=String.valueOf(letts);
                for (char c : letts){
                    if(word.containsKey(c)){
                        word.put(c, word.get(c)+1);
                    }
                    else{
                        word.put(c,1);
                    }
                }
            }
            else{
                HashMap<Character, Integer> temp = new HashMap<>(word);
                for(char lett : letts){
                    if(temp.containsKey(lett)){
                        if(temp.get(lett)!=0){
                            temp.put(lett,temp.get(lett)-1);
                            check++;
                        }
                    }
                }
                //System.out.println("이번단어의 check:"+check+"이번단어의 길이:"+letts.length);
                if(check==first.length() && letts.length<=first.length()+1&&letts.length>=first.length()-1){
                    count++;
                }
                else if(check==first.length()-1 && letts.length>=first.length()-1&&letts.length<=first.length()){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
