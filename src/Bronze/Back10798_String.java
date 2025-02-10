package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Back10798_String {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String[] letter=new String[15];
        char[][] letters= new char[5][15];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                letters[i][j] = ' ';
            }
        }

        int max=0;
        for(int i=0;i<5;i++){
            letter[i]=bf.readLine();
            for (int j = 0; j < letter[i].length(); j++) {
                letters[i][j] =letter[i].charAt(j);
            }
            max = Math.max(max, letter[i].length());
        }

        for(int i=0; i<max; i++){
            for(int j=0; j<5; j++){
                if(letters[j][i]!=' '){
                    System.out.print(letters[j][i]);
                }
            }
        }
    }
}
