package Gold;

import java.io.IOException;
import java.util.*;
import java.io.*;

//NxN 만 주어지고 서로 공격할 수 없게 두는 경우의 수.
public class Back9663_queenTracking {//이것두 백트래킹이라,,,
    public static int[] queen;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        queen = new int[N];
        Tracking(0); //시작하는 여왕
        System.out.println(count);
    }

    //일단 N 은 최대 15개밖에 안주어지긴한다. -> 설마 비트마스킹 가능..?
    public static void Tracking(int depth) {
        if (depth == queen.length) {
            count++;
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            queen[depth] = i; //퀸 자리 베정
            if (isPossible(depth)) {
                Tracking(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for (int i=0;i<depth; i++) {
            if (queen[i] == queen[depth]) {
                return false;
            }
            //이 조건 쓰는게 힘들었음
            else if(Math.abs(depth-i)==Math.abs(queen[depth]-queen[i])) {
                return false;
            }
        }
        return true;
    }
}
