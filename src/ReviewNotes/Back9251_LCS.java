package ReviewNotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Back9251_LCS {//최장공통부분수열(LCS) 문제. 좌표 저장 문제
    public static int [][] maps;
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String words1 = bf.readLine();
        String words2 = bf.readLine();
        maps = new int[words1.length() + 1][words2.length() + 1];

        int max=0;
        if (words1.isEmpty() || words2.isEmpty()) {
            System.out.println(0);
            return;
        }
        //LCS 배열 저장
        for (int i = 1; i <= words1.length(); i++) {
            for (int j = 1; j <= words2.length(); j++) {
                //words2 를 words1 하나씩 대입하면서 비교해주기
                if (words1.charAt(i-1) == words2.charAt(j-1)) {
                    maps[i][j] = maps[i - 1][j - 1] + 1;
                } else {
                    maps[i][j] = Math.max(maps[i - 1][j], maps[i][j - 1]);
                }
                max=Math.max(max, maps[i][j]);
            }
        }
        System.out.println(max);
    }
}
