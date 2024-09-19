package Bronze;

import java.beans.beancontext.BeanContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bf.readLine()); //입력시에 주의할것 이게 첫쨰줄 의미

        StringTokenizer st= new StringTokenizer(bf.readLine());//이게 둘째줄을 받아오는 것 의미.
        //위의 int num= 을 여기에 쓸 경우 윗줄이 숫자 하나 입력을 받아오고 int num 이 둘쨰줄 구문 전체를 받아오게 됨.
        ArrayList<Float> scores= new ArrayList<>();

        float max=0;
        float sum=0;
        float result=0;
        for (int i=0; i<num; i++) {
            float score=(Float.parseFloat(st.nextToken()));
            scores.add(score);
            if(score>max) max=score; //제일 기본적인 건데 왜 헷갈렸지;;
        }

        for(int i=0; i<num; i++){
            result+=(scores.get(i)/max)*100;
        }
        System.out.println((Float)(result/num));

        //scores.add(Integer.parseInt(st.nextToken())); 일일히 하는거보다 위가 맞음.
        //scores.add(Integer.parseInt(st.nextToken()));
        //scores.add(Integer.parseInt(st.nextToken()));



    }
}
