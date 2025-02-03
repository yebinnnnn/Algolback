package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back2630_DivideCon { //문제만 보고는 감도 안잡힘
    public static int[][] square; //색종이 좌표
    public static int blue;
    public static int white;

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine()); //전체 색종이 가로세로 길이
        square=new int [n][n];//배열 선언
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                square[i][j]=Integer.parseInt(st.nextToken());
            }
        }//색종이 입력완료
        StringBuilder sb= new StringBuilder();
        white=0;
        blue=0;
        cutter(0,0,n);
        System.out.println(white+"\n"+blue);
    }

    //사이즈가 이제 가로세로 길이, row,col 이 좌표시작점
    public static void cutter(int row, int col, int size){
        if(Color(row,col,size)){ //색이 같은지 확인하는 함수 하나 더 만드는게 낫다.
            if(square[row][col]==0){
                white++;
            }
            else{
                blue++;
            }

        }

        else{ //사분면 쪼개서 또 하나씩 다 돌려봄
            cutter(row, col, size/2);
            cutter(row+size/2, col+size/2, size/2);
            cutter(row, col+size/2, size/2);
            cutter(row+size/2, col, size/2);
        }
    }

    public static boolean Color(int row, int col, int size){
        int color=square[row][col]; //시작원소 기준 같고 다름만 판별
        for(int i=row; i<row+size; i++) {
            for(int j=col; j < col+size; j++) {
                if(square[i][j]!=color) {
                    return false;
                }
            }
        }
        return true;

    }
}
