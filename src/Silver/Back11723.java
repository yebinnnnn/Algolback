package Silver;
import java.io.*;
import java.util.*;

public class Back11723 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M= Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashSet<Integer> set= new HashSet<>();
        StringBuilder sb= new StringBuilder();
        int thisnum=0;
        String order;

        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            order=st.nextToken();
            if(order.equals("add")){
                set.add(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("remove")){
                set.remove(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("check")){
                thisnum= Integer.parseInt(st.nextToken());
                if(set.contains(thisnum)){
                    sb.append("1").append("\n");
                }
                else{
                    sb.append("0").append("\n");
                }
            }
            else if(order.equals("toggle")){
                thisnum=Integer.parseInt(st.nextToken());
                if(set.contains(thisnum)){
                    set.remove(thisnum);
                }
                else{
                    set.add(thisnum);
                }
            }
            else if(order.equals("all")){
                set.clear();
                for(int k=1; k<=20; k++){
                    set.add(k);
                }
            }
            else if(order.equals("empty")){
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
