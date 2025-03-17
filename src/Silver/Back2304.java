package Silver;
import java.util.*;
import java.io.*;

public class Back2304 { //해시맵 정렬 들어가야 할 거 같은데 까먹음;;
    public static int[] Hash;
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number=Integer.parseInt(bf.readLine());
        Hash=new int[1001];
        for(int i=0;i<number;i++) {
            st = new StringTokenizer(bf.readLine());
            //해시맵에 돌려가며 하나씩 put.
            int thisgeo=Integer.parseInt(st.nextToken());
            int height=Integer.parseInt(st.nextToken());
            Hash[thisgeo]=height; //각 자리에 높이 저장.
        }

        int max=0;
        int start=0;//max뒤의 시작 변수
        int sum=0; //사각형 면적 더할 변수
        boolean flag=false;
        int indexj=0;

        //가장 높은 기둥 찾기.
        for (int i = 0; i < Hash.length; i++) {
            if (max < Hash[i]) {
                max = Hash[i];
                indexj = i;
            }
        }

        //기동 왼쪽 중에서 탐색
        int leftMax = 0;
        for (int i = 0; i <= indexj; i++) {
            if (Hash[i] > leftMax) {
                leftMax = Hash[i];
            }
            sum += leftMax;
        }

        // 오른쪽부터 최고 기둥까지 계산
        int rightMax = 0;
        for (int i = Hash.length - 1; i > indexj; i--) {
            if (Hash[i] > rightMax) {
                rightMax = Hash[i];
            }
            sum += rightMax;
        }

        System.out.println(sum);
    }
}
