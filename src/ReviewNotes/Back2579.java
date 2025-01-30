package ReviewNotes;
import java.io.*;

public class Back2579 {
    static int step;
    public static int [] scores;
    static Integer [] best;

    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int stairs=Integer.parseInt(bf.readLine());
        scores= new int[stairs+1];
        scores[0]=0;
        best=new Integer[stairs+1];
        best[0]=0;

        for(int i=1; i<=stairs; i++){
            scores[i]=Integer.parseInt(bf.readLine());
        }
        step=0;
        System.out.println(foundstairs(stairs));
    }
    public static int foundstairs(int stairs){
        if(stairs==1){
            return scores[1];
        }
        if(stairs==2){
            return scores[1] + scores[2];
        }
        best[1] = scores[1];
        best[2] = scores[1] + scores[2]; //이건 알아
        for (int i=3; i <= stairs; i++) {
            // i번째 계단에 도달하기 위해서는 (i-1)번째 계단에서 한 칸 올라오거나 (i-2)번째 계단에서 두 칸 올라와야 함
            //(i-1)번째 계단에서 올라올 경우 (i-2)번째 계단은 밟지 않아야 하므로 (i-3)번째 계단에서 올라와야 함
            best[i] = Math.max(best[i-2]+scores[i], best[i-3]+scores[i-1]+scores[i]);
        }
        return best[stairs];
    }
}
