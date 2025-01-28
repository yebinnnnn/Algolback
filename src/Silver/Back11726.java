package Silver;
import java.io.*;
import java.util.*;

public class Back11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tile=new int[1001];
        tile[1]=1;
        tile[2]=2;
        for(int i=3; i<=n; i++){
            tile[i]=(tile[i-1]%10007+tile[i-2]%10007);
        }
        System.out.println(tile[n]%10007);
    }
}
