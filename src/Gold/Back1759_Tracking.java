package Gold;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Back1759_Tracking { //순열 글자 버전인가?
    public static String[] dict;
    public static boolean [] checking;
    public static int allnum;
    public static int makenum;
    public static String[] answer;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        makenum=Integer.parseInt(st.nextToken());
        allnum=Integer.parseInt(st.nextToken());
        dict= new String [allnum];
        answer= new String [makenum];
        checking= new boolean [allnum];
        //한단어씩 받기
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<allnum;i++){
            dict[i]=st.nextToken();
        }
        Arrays.sort(dict);
        Tracking(0,0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    //정렬을 해두고 그 뒤만 갖고오기.
    //전형적인 백트래킹 형탠데 자모음 조건을 한번 체크해줘야하고,
    //sort +start 를 쓰면 누더기 코드로 안쓰고 풀 수 있다는점 (원래 for문안에 조건 두개쓰려했음)
    public static void Tracking(int depth, int start ){
        if(depth==makenum){
            if(isHave(answer)) {
                for (String s : answer) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start; i<allnum;i++){
            if(!checking[i]){
                checking[i]=true;
                answer[depth] = dict[i];
                Tracking(depth+1,i+1);
                checking[i]=false;
            }
        }
    }
    //모음,자음 조건까지 있음...
    public static boolean isHave(String[] answer){
        int mo= 0, ja= 0;
        for(String s : answer) {
            char c=s.charAt(0);
            if (c=='a'|| c=='e' || c=='i' || c=='o' || c=='u') {
                mo++;
            }
            else{
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }
}
