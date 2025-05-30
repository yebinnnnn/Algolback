import java.util.*;
import java.io.*;
class Solution2 {
    int answer;
    public int solution(int n, int[][] wires) {
        answer=n;
        //해시맵으로 선언
        HashMap<Integer, List<Integer>> graph= new HashMap<>();
        for(int i=1; i<=n; i++){//각 키 값마다 ArrayList를 초기 선언해준다.
            graph.put(i,new ArrayList<>());
        }//그런다음 맵에 따라 연결작업을 해준다. get wire[]0에 add wire[]1 해주고 반대도 해줘야함.
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        //넘겨줘야 할 값: hashmap, 탐색시작점, 전체 와이어 수
        boolean[] visited=new boolean[n+1];
        //방문체크용 배열도 파야한다. 그다음에 dfs 로 넘겨준다.
        dfs(graph,visited,1,n);
        return answer;
        
    }
    //이 dfs 함수에서 answer값도 다룰거다.(그래서 answer 는 광역변수선언 되어있어야함)
    public int dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int cur, int all){
        int count=1;
        visited[cur]=true;
        //해당노드에서 자식노드가 몇개인지 알아야하고, 이를 통해 차이수를 구해야한다-> 전체 n-2*count 라고 할 수 있음.
        //자식이 없으면 나 스스로이므로 count=1이다.
        //재귀를 해보자...
        //cur가 현재의 노드값
        for(int next: map.get(cur)){
            if(!visited[next]){
                count+=dfs(map,visited,next,all);
            }
        }
        //answer 여기서 따로 배정해줘야 함
        answer=Math.min(answer,Math.abs(all-2*count));
        return count;
    }
}

class Solution3{
    boolean[] checking;
    int answer=Integer.MAX_VALUE;
    public int solution(int n, int[][] wires){
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<>();
        checking= new boolean[n+1];
        for(int i=1; i<=n; i++){
            map.put(i, new ArrayList<>());
        }
        //트리로 해시맵에 배정
        for(int i=0; i<wires.length; i++){
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }
        int answers=dfs(map,1,n);
        return answer;
    }
    public int dfs(HashMap<Integer,ArrayList<Integer>> map, int start, int n){
        checking[start]=true;
        int count=1;
        for(int i=0; i<map.get(start).size(); i++){
            //자식들 줄줄이 사탕으로 다 구하기
            if(!checking[map.get(start).get(i)]){
                count+=dfs(map,map.get(start).get(i),n);
            }
        }
        answer=Math.min(answer,Math.abs(n-2*count));
        return count;
    }
}

class Solution{
    int answer=Integer.MAX_VALUE;
    public int solution(int n, int[][] wires){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] checking = new boolean[n+1];
        for(int i=1; i<=n; i++){
            //초기 맵 할당해줌
            map.put(i,new ArrayList<>());
        }
        for(int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        int count=dfs(map,n,checking,1);
        return answer;
    }
    public int dfs(HashMap<Integer,List<Integer>> map, int n,boolean[] checking, int start){
        checking[start]=true;
        int count=1;
        for(int i=0; i<map.get(start).size(); i++){
            if(!checking[map.get(start).get(i)]){
                count+=dfs(map,n, checking, map.get(start).get(i));
            }
        }
        answer= Math.min(answer, Math.abs(n-2*count));
        return count;
    }
}