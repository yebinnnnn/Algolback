package Bronze;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back2798 { //BruteForce- 3장의 카드를 골라 더하는 경우의 수. 카드의 수는 3~100장.
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int cardCount=Integer.parseInt(st.nextToken());
        int number=Integer.parseInt(st.nextToken());

        StringTokenizer st2=new StringTokenizer(bf.readLine());
        int[] mycard= new int[cardCount];

        for(int i=0; i<cardCount; i++){
            mycard[i]=Integer.parseInt(st2.nextToken());
        }

        int answer = getAnswer(number, cardCount, mycard);
        System.out.println(answer);
    }

    private static int getAnswer(int number, int cardCount, int[] mycard) {
        int firstcard=0;
        int secondcard=0;
        int thirdcard=0;
        int sum=0;
        int closer=number;
        int answer=0;

        for(int i=0; i<cardCount-2; i++){
            firstcard= mycard[i];
            for(int j=i+1; j<cardCount-1; j++){
                secondcard = mycard[j];
                for(int k=j+1; k<cardCount; k++){
                    thirdcard= mycard[k];
                    sum= firstcard+secondcard+thirdcard;
                    if(sum<=number&& number-sum<=closer){
                        answer=sum;
                        closer= Math.abs(number-sum);
                    }
                }
            }
        }
        return answer;
    }
}
