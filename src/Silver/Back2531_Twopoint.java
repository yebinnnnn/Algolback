package Silver;
import java.io.*;
import java.util.*;

public class Back2531_Twopoint {
    public static void main(String[] args)throws IOException{
        int max=Integer.MIN_VALUE;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int dish= Integer.parseInt(st.nextToken()); //전체 접시 수
        int kind=Integer.parseInt(st.nextToken()); //종류 수
        int take=Integer.parseInt(st.nextToken());//손님이 먹을 접시 수
        int coupon=Integer.parseInt(st.nextToken()); // 쿠폰 적용되는 접시(포함할 지 안할지는 자유)
        int[] dishes=new int[dish+1];
        //접시들 입력
        //원 형태로 접근할 수 있음
        for(int i=0; i<dish; i++){
            dishes[i]=Integer.parseInt(bf.readLine());
        }
        //dist 만큼 포함해야함. 슬라이딩 윈도우
        int[] check= new int[kind+1]; //해당 접시가 있는지 체크용

        for(int i=0; i<dish; i++){ //start 인덱스는 여기서 자동조절
            Arrays.fill(check,0); //한바퀴 돌때 초기화
            int count=0;
            boolean coucheck=false;
            //슬라이딩 윈도우
            int end=i+take;
            for(int j=i; j<end; j++){
                int newj=j;
                if(j>dish-1){
                    newj=j-dish;
                }
                if(check[dishes[newj]]==0){
                    count++;
                    check[dishes[newj]]++;
                    if (dishes[newj]==coupon&&!coucheck){
                        coucheck = true;
                    }
                }
            }
            if(!coucheck){
                count++;
            }
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
}
