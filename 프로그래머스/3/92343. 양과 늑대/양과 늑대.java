class Solution {
    public int solution(int[] info, int[][] edges) {
        boolean [] checking= new boolean[info.length]; //방문 배열 체크용
        checking[0]=true;
        int answer=dfs(edges, info, 1, 0,checking);
        return answer;
    }
    public int dfs(int[][] edges, int[] info, int sheep,int wolf, boolean[] checking){
        //일단 같아지는지 확인
        if(sheep==wolf){
            return sheep;
        }
        int maxSheep=sheep;
        //다음꺼 체크했을때 양인 경우와 늑대인 경우 분리
        for(int[] edge : edges){
            int parent=edge[0];
            int child=edge[1];
            if(checking[parent]&&!checking[child]){
                //양일때
                checking[child]=true;
                if(info[child]==0){
                    maxSheep=Math.max(maxSheep, dfs(edges, info, sheep+1, wolf,checking));
                    }
                else{//다음 노드가 늑대일때
                     maxSheep=Math.max(maxSheep, dfs(edges, info, sheep, wolf+1, checking)); 
                    }
                checking[child]=false;
            }
        }
        return maxSheep;
    }
}