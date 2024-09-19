package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bf.readLine());
        int check_num=0;
        int count;
        int check_count;

        for(int i=num; i>0; i--){
            int new_num=i;
            check_count=0;
            count=0;
            while(new_num>0){
                count++;
                check_num=new_num%10;
                new_num=new_num/10;
                if(check_num==4||check_num==7){
                    check_count++;
                }
                else break;
            }
            if(count==check_count){
                System.out.println(i);
                break;
            }
        }
    }
}
