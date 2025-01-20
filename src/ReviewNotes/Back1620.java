package ReviewNotes;
import java.util.*;
import java.io.*;

public class Back1620 { //실패이유-> 해시맵은 두개자체를 만들긴 했는데 그게 문제가 아니라
    //for 문 안에서 pocket 에 새롭게 i 가지고 또 string.ValueOf 으로 변환해서 넣는게 시간초과임!!!
    //for Map.Entry Interface 를 사용할것
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        HashMap<String,String> pocket= new HashMap<>();
        HashMap<String,String> pocketnum= new HashMap<>();

        for(int i=1; i<=N; i++){
            pocketnum.put(String.valueOf(i),bf.readLine());
        }
        for(Map.Entry<String, String> entry: pocketnum.entrySet()){
            pocket.put(entry.getValue(),entry.getKey());
        }

        StringBuilder sb= new StringBuilder();
        for(int i=1; i<=M; i++){
            String found=bf.readLine();
            if(pocketnum.containsKey(found)){//들어온게 정수일때
                sb.append(pocketnum.get(found)).append("\n");
            }
            else{ //들어온게 이름일때
                sb.append(pocket.get(found)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
