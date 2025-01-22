package Bronze;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

public class Back30802 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int allPerson=Integer.parseInt(bf.readLine());

        StringTokenizer st=new StringTokenizer(bf.readLine());
        ArrayList<Integer> tShirts=new ArrayList<>();
        for(int i=0; i<6; i++){
            tShirts.add(i,Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st1=new StringTokenizer(bf.readLine());
        int shirtsSet=Integer.parseInt(st1.nextToken());
        int penSet=Integer.parseInt(st1.nextToken());
        int needSt=0;
        int sum=0;
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<6; i++){
            needSt=tShirts.get(i);
            if(needSt>shirtsSet){
                if(needSt%shirtsSet==0){
                    tShirts.remove(i);
                    tShirts.add(i,needSt/shirtsSet);
                }
                else{
                    tShirts.remove(i);
                    tShirts.add(i,(needSt/shirtsSet)+1);
                }
            }
            else if(needSt==0){
                tShirts.remove(i);
                tShirts.add(i,0);
            }
            else{
                tShirts.remove(i);
                tShirts.add(i,1);
            }
            sum+=tShirts.get(i);
        }
        sb.append(sum).append("\n");

        int needPen=allPerson/penSet;
        int morePen=allPerson-(needPen*penSet);
        sb.append(needPen).append(" ");
        sb.append(morePen);
        System.out.println(sb);
    }
}
