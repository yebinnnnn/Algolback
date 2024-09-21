package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2839 { //메모리가 크게 나와서 아쉬운 해결
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int kilogram= Integer.parseInt(bf.readLine());
        int remain=kilogram; //단순하게 5부터 나누면 안된다. 5,3 둘이 섞으면 -1이 안되고 최저로 나올 수 있는 경우의 수가 있기때문
        int bag;
        bag=(remain/5);
        remain=remain%5;
        while(remain!=0){
            if(remain>kilogram){
                System.out.println(-1);
                System.exit(0);
            }
            if(remain%3!=0){
                remain+=5;
                bag--;
            }
            else{
                bag+=remain/3;
                break;
            }
        }
        System.out.println(bag);
    }
}
