package ReviewNotes;
import java.io.*;
import java.util.*;

public class Back2178_graphMaze {//미로 찾기. BFS 로 써야 맞겠는데,,,
    public static int[][] maze;
    public static int[][] check;
    public static int sero, garo;

    public static void main(String[] main)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        sero= Integer.parseInt(st.nextToken());
        garo= Integer.parseInt(st.nextToken());

        maze= new int[sero][garo];
        check= new int[sero][garo];
        char[] temp= new char[garo];

        for(int i=0; i<sero; i++){
            temp=bf.readLine().toCharArray(); //배열 이니셜라이저
            for(int j=0; j<garo; j++){
                maze[i][j]=Integer.parseInt(String.valueOf(temp[j]));
                check[i][j] = -1;
            }
        }
        System.out.println(bfs(0,0));
    }

    public static int bfs(int startX, int startY){
        int[] X= {+1,0,-1,0}; //X도 플러스, Y 도 플러스 돼야 정답에 가까워짐
        int[] Y= {0,+1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX,startY});
        check[startX][startY] = 1;  // 시작점 거리 1

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            // 도착점에 도달하면 거리 반환
            if (x == sero - 1 && y == garo - 1) {
                return check[x][y];
            }

            //한경우 씩 체크
            {
                int nx = x + X[0];
                int ny = y + Y[0];


                if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
                    if (maze[nx][ny] == 1 && check[nx][ny] == -1) {
                        check[nx][ny] = check[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            {
                int nx = x + X[1];
                int ny = y + Y[1];

                // 범위 체크 & 이동 가능 여부 확인
                if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
                    if (maze[nx][ny] == 1 && check[nx][ny] == -1) {
                        check[nx][ny] = check[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            {
                int nx = x + X[2];
                int ny = y + Y[2];

                if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
                    if (maze[nx][ny] == 1 && check[nx][ny] == -1) {
                        check[nx][ny] = check[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            {
                int nx = x + X[3];
                int ny = y + Y[3];

                if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
                    if (maze[nx][ny] == 1 && check[nx][ny]==-1) {
                        check[nx][ny] = check[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1; // 탈출 불가능한 경우
    }
}
