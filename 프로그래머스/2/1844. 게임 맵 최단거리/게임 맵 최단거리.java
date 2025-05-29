import java.io.*;
import java.util.*;

class Solution2{
    int[] X={-1,1,0,0};
    int[] Y={0,0,-1,1};
    int[][] distance;
    boolean[][] checking;
    public int solution(int[][] maps) {
        int answer = 0;
        int sizen=maps.length;
        int sizem=maps[0].length;
        distance= new int[sizen][sizem];
        distance[0][0]=1;//초기거리 1으로 설정
        checking= new boolean[sizen][sizem];
        answer=bfs(sizen,sizem, maps);
        return answer;
    }
    public int bfs(int n,int m, int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] current=q.poll();
            int nX=current[0];
            int nY=current[1];
            for(int i=0; i<4; i++){
                int dx=nX+X[i];
                int dy=nY+Y[i];
                if(dx>=0&&dy>=0&&dx<n&&dy<m&&!checking[dx][dy]){
                    if(maps[dx][dy]==1){
                        q.add(new int[]{dx,dy});
                        distance[dx][dy]=distance[nX][nY]+1; //새 거리값도 저장
                        checking[dx][dy]=true;
                    }
                }
            }
        }
        return distance[n-1][m-1]==0? -1: distance[n-1][m-1];
    }
}
class Solution {
    public int[] X={-1,1,0,0};
    public int[] Y={0,0,-1,1};
    public int solution (int[][] map){
        boolean[][] checking= new boolean[map.length][map[0].length];
        int[][] depth=new int[map.length][map[0].length];
        int answer=bfs(map, checking, 1, map.length, map[0].length, depth);
        return answer;
    }
    public int bfs(int[][] map, boolean[][] checking , int start, int n, int m, int[][] depth){
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0});
        depth[0][0]=1;
        while(!q.isEmpty()){
            int[] current=q.poll();
            int nx=current[0];
            int ny=current[1];
            for(int i=0; i<4; i++){
                int dx=nx+X[i];
                int dy=ny+Y[i];
                if(dx>=0&&dy>=0&&dx<n&&dy<m&&!checking[dx][dy]){
                    checking[dx][dy]=true;
                    if(map[dx][dy]==1){
                        q.add(new int[]{dx,dy});
                        depth[dx][dy]=depth[nx][ny]+1;
                    }
                }
            }
        }
        return depth[n-1][m-1]==0? -1: depth[n-1][m-1];
        
    }
}