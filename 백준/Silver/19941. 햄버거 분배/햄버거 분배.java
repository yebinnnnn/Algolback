import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int num= Integer.parseInt(st.nextToken());
        int dist=Integer.parseInt(st.nextToken());
        String burger=bf.readLine();
        char[] burgers=burger.toCharArray(); //배열로 할당
        boolean[] checked=new boolean[burgers.length];

        int count=0;
        for(int i=0;i<burgers.length;i++){
            if(burgers[i]=='H') {
                for(int j=-dist; j<=dist; j++){
                    if(i+j>=0&&i+j<num&&j!=0&&!checked[i+j]&&burgers[i+j]=='P'){
                        checked[i+j]=true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
