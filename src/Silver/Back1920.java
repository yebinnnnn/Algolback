package Silver;
import java.io.*;
import java.util.*;

public class Back1920 { //자바-HashSet
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int count= Integer.parseInt(bf.readLine());
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int[] array1=new int[count];
        HashSet<Integer> answerSet= new HashSet<>();
        int i=0;
        while(st.hasMoreTokens()){
            answerSet.add(Integer.parseInt(st.nextToken()));
            i++;
        } //비교군이 될 배열

        int secount= Integer.parseInt(bf.readLine());
        int[] comarray=new int[secount];
        int[] answer= new int[secount];

        i=0;
        StringTokenizer st2=new StringTokenizer(bf.readLine());
        while(st2.hasMoreTokens()){
            comarray[i]= Integer.parseInt(st2.nextToken());
            if(answerSet.contains(comarray[i])){
                answer[i]=1;
            }
            else{
                answer[i]=0;
            }
            i++;
        }

        for(int j=0; j<secount; j++){
            System.out.println(answer[j]);
        }
    }
}
