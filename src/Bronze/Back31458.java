package Bronze;
import java.io.*;
import java.util.*;

public class Back31458 {
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(bf.readLine());
        Stack<Character> caculate= new Stack<>();
        StringBuilder sb= new StringBuilder();

        while(T-->0){
            int boolcount=0;
            boolean facount=false;
            boolean numbool=false;
            int thisnumber=0;
            String form=bf.readLine();

            for(int i=0; i<form.length(); i++){
                caculate.push(form.charAt(i));
            }

            while(!caculate.isEmpty()){
                if(!numbool &&caculate.peek()=='!'){
                    facount=true;
                    caculate.pop();
                }
                else if(caculate.peek()=='0'||caculate.peek()=='1'){
                    thisnumber=Integer.parseInt(String.valueOf(caculate.pop()));
                    numbool=true;
                }
                else if(numbool&&caculate.peek()=='!'){
                    caculate.pop();
                    boolcount++;
                }
            }
            if(facount){
                if(boolcount%2==0){
                    sb.append('1').append("\n");;
                }
                else{
                    sb.append('0').append("\n");;
                }
            }
            else{
                if(boolcount%2==0){
                    sb.append(thisnumber).append("\n");
                }
                else{
                    if(thisnumber==0){
                        sb.append('1').append("\n");;
                    }
                    else{
                        sb.append('0').append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
