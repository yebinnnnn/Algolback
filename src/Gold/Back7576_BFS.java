package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

//다 익은걸 어케 확인하지...
public class Back7576_BFS {
    public static int[][] tomato;
    public static int N,M;
    static Queue<int[]> q=new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        tomato=new int[M][N];
        for(int i=0; i<M; i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                tomato[i][j]=Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1){
                    //익은 토마토면 bfs 시작.
                    q.add(new int[]{i,j});
                }
            }
        }
        bfs();

        int result=0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(tomato[i][j]==0){
                    System.out.println("-1");
                    return;
                }
                result=Math.max(result,tomato[i][j]);
            }
        }
        System.out.println(result-1);
    }
    public static void bfs(){
        int[] Xgo={-1,1,0,0};
        int[] Ygo={0,0,-1,1};
        while(!q.isEmpty()){
            int[] current=q.poll();
            int X=current[1];
            int Y=current[0];
            for(int i=0; i<4; i++){
                int nx=X+Xgo[i];
                int ny=Y+Ygo[i];
                if(ny>=0&&ny<M&&nx>=0&&nx<N){
                    //0아니면 1일때만 이동이 가능
                    if(tomato[ny][nx]==0){
                        tomato[ny][nx]=tomato[Y][X]+1;
                        q.add(new int[]{ny,nx});
                    }
                }
            }
        }
    }
}
