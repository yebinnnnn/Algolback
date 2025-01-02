package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1193 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int i=1;
        int sum=0;
        int startpoint=0;
        while(true){
            sum+=i;
            if(number>sum-i && number<=sum){
                startpoint=i;
                break;
            }
            i++;
        }
        int uppoint=0;
        int downpoint=0;
        if(startpoint%2==0){
            uppoint=number-(sum-startpoint);
            downpoint=startpoint-(number-(sum-startpoint+1));
        }
        else{
            uppoint=startpoint-(number-(sum-startpoint+1));
            downpoint=number-(sum-startpoint);
        }
        StringBuilder sb= new StringBuilder();
        sb.append(uppoint).append("/").append(downpoint);
        System.out.println(sb.toString());
    }
}
