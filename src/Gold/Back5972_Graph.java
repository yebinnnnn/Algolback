package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Back5972_Graph {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int home= Integer.parseInt(st.nextToken());
        int road=Integer.parseInt(st.nextToken());
        List<int[]>[] graph=new ArrayList[home+1];
        for(int i=0;i<=home;i++){
            graph[i]=new ArrayList<>();
        }
        //;;;;이게 맞나
        for(int i=0;i<road;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int score=Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,score});
            graph[b].add(new int[]{a,score});
        }

        int[] dist=new int[home+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int now=current[0];
            int sco=current[1];
            if(dist[now]<sco){
                continue;
            }
            for(int[] next: graph[now]){
                int nextN=next[0];
                int nextCo=next[1];
                if(dist[nextN]>sco+nextCo){
                    dist[nextN]=sco+nextCo;
                    pq.offer(new int[]{nextN, dist[nextN]});
                }
            }
        }
        System.out.println(dist[home]);
    }
}
