package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back9012 { //이중 for 문 말고 더 잘 쓸 수 있는 방법은??
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int count=Integer.parseInt(bf.readLine());
        int pair1=0;
        int pair2=0;

        for(int i=0; i<count; i++){
            pair1=0;
            pair2=0;

            String list=bf.readLine();
            char[] pack =list.toCharArray();

            for(int j =0; j<pack.length; j++){
                if(pack[j]=='('){
                    pair1++;
                }
                if(pack[j]==')'){
                    pair2++;
                }
                if(pair1<pair2){
                    sb.append("NO"+"\n");
                    break;
                }
                if(j==pack.length-1){
                    if(pack[j]=='('){
                        sb.append("NO"+"\n");
                        break;
                    }
                    if(pair1!=pair2){
                        sb.append("NO"+"\n");
                        break;
                    }
                    else{
                        sb.append("YES"+"\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
