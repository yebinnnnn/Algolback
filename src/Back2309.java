import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Back2309{
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> tall = new ArrayList<Integer>();
        int sum=0;

        for(int i=0; i<9; i++){
            tall.add(Integer.valueOf(bf.readLine()));
            sum+= tall.get(i);
        }

        boolean found= false;
        int remain=sum-100;
        for(int i=0; i<9; i++) {
            for (int j = i + 1; j < 9; j++) { // j를 i+1부터 시작해서 중복 제거 방지
                if (tall.get(i) + tall.get(j) == remain) {
                    tall.remove(j); // 먼저 두 번째 요소를 제거 (인덱스 변동 방지)
                    tall.remove(i); // 첫 번째 요소 제거
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        Collections.sort(tall); //콜렉션 클래스로 정렬... 실제로 쓸 수 있나?
        for (int height : tall) {
            System.out.println(height);
        }
    }
}
