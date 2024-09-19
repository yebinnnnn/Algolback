import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int N= Integer.parseInt(st.nextToken()); //노래 촛수
        int L= Integer.parseInt(st.nextToken()); //노래 곡수
        int D= Integer.parseInt(st.nextToken()); //전화벨 간격

        ArrayList<Boolean> sec= new ArrayList<Boolean>();//불린타입의 리스트 만들어줌.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < L; j++){//i=N 까지에서 L만큼의 true 넣음. -> 노래 촛수 의미
                sec.add(true);
            }

            //반복이 다 끝나고 false 로 갈아끼워주는 작업.
            if(i != N-1) { // 마지막 곡이 아닐 경우
                for(int j = 0; j < 5; j++) {//음악과 음악 사이는 false 로 넣어줌.
                    sec.add(false);
                }
            }
        }

        int result = 0;
        while(result < sec.size()) {    //벨이 울리는 주기에 따라 해당 sec를 확인하여 음악이 나오지 않는중(false)이면 해당 sec를 출력
            if(!sec.get(result)) { //!sec-> false 일때 마다 해당 sec 출력.
                break;
            }
            result += D; //sec 은 그때마다 전화벨 간격만큼 더해줌. 3초간격이면 0~1초 울리고 3~4초 울리고. 1초만 들을 수 있으니까 이게 맞음.
        }
        System.out.println(result);
        }
    }