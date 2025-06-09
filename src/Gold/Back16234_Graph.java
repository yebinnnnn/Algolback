package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back16234_Graph {
    public static int N;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken()); //up 이상 down 이하
        int down = Integer.parseInt(st.nextToken());

        map= new int[N][N];
        //서로 체크했는지도 체크할 필요 있음
        boolean[][] visited= new boolean[N][N];
        //인구수 저장
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        //며칠 가는지 카운트
        while(true){
            boolean go=false;
            visited=new boolean[N][N]; //아오 이것때메 visited 초기화 안해줘서 자꾸 하루나옴
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){//방문 안한 블럭이면
                        List<int[]> union=bfs(i,j,up,down,visited); //그 블럭의 연합 확인
                        //연합이 두개이상 있어야 작업 가능
                        if(union.size()>1){
                            go=true; //오늘도 이동하는구나~
                            int total=0;
                            //인구 계산 과정
                            for(int[] pos:union){//union에 저장했던 int[] 값들 꺼냄.
                                total+=map[pos[0]][pos[1]];
                            }
                            int average=total/union.size();
                            for(int[] pos:union){
                                map[pos[0]][pos[1]]=average;
                            }
                        }
                    }
                }
            }
            if(!go){ //어떤 연합도 생기지 않음
                break;
            }
            //go 했었으면 하루 지날 수 있으니까 카운트 해줌
            count++;
        }
        System.out.println(count);
    }//bfs. 모든 맵 확인하면서 연합을 만들어야 되고, 인구 수 차이 끝날때까지 돌려야 함.
    public static List<int[]> bfs(int i, int j, int up, int down, boolean[][] visited) {
        int[] X= {0,0,-1,1};
        int[] Y={1,-1,0,0};
        int person=map[i][j];
        Queue<int[]> q= new ArrayDeque<>();
        List<int[]> union= new ArrayList<>();
        q.offer(new int[]{i,j});
        union.add(new int[]{i,j}); //연합에도 넣을 수 있음.
        visited[i][j]=true;

        while(!q.isEmpty()){
            int[] current=q.poll();
            int x=current[0];
            int y=current[1];
            for(int k=0;k<4;k++){
                int nx=x+X[k];
                int ny=y+Y[k];
                if(nx>=0 && ny>=0 && nx<N && ny<N &&!visited[nx][ny]){ //유효성 조사
                    int minus=Math.abs(map[x][y]-map[nx][ny]);
                    if(minus>=up && minus<=down){ //조건에 맞는 좌표인가?
                        visited[nx][ny]=true;
                        union.add(new int[]{nx,ny});
                        q.offer(new int[]{nx,ny});//새 좌표 넣기
                    }
                }
            }
        }
        return union;
    }
}
