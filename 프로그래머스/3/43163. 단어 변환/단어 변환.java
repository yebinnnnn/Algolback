import java.util.*;
import java.io.*;

class Solution2 {
    public class Node{
    String st;
    int depth;
    Node(String st, int depth){
        this.depth=depth;
        this.st=st;
        }
    }
    public boolean[] checking;
    public int solution(String begin, String target, String[] words) {
        //일종의 최단거리 Bfs 로 푸는건듯
        Queue<Node> q= new ArrayDeque<>();
        checking=new boolean[words.length];
        
        Node first=new Node(begin,0);
        q.add(first);
        while(!q.isEmpty()){
            Node current=q.poll();
            if(current.st.equals(target)){
                return current.depth;
            }
            for(int i=0; i<words.length; i++){
                //여기 조건에 체킹되지 않았고 단어 차이가 하나만 나야함
                if(!checking[i]&&differ(current.st,words[i])){
                    checking[i]=true;
                    //System.out.println(current.st+","+words[i]);
                    q.add(new Node(words[i],current.depth+1));
                    continue;
                }
            }
        }
        return 0;
    }
    public boolean differ(String now, String init){
        int diff = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != init.charAt(i)) diff++;
        }
        return diff == 1;
    }
}

class Solution{ //bfs+ differ 라는 검사 함수 따로 구현할 것
    public class Node{
        String st;
        int depth;
        public Node(String st, int depth){
            this.st=st;
            this.depth=depth;
        }
    }
    public int solution(String begin, String target, String[] words){
        boolean[] checking=new boolean[words.length];
        Queue<Node> q= new ArrayDeque<>();
        Node nodes=new Node(begin,0);
        q.add(nodes);
        //탐색시작
        while(!q.isEmpty()){
            //현재 도착해있는 단어
            Node node=q.poll();
            if(node.st.equals(target)){
                return node.depth;
            }
            for(int i=0; i<words.length; i++){
                if(!checking[i]&&differ(node.st, words[i])){
                    checking[i]=true;
                    q.add(new Node(words[i], node.depth+1));
                    continue;
                }
            }
        }
        return 0;
    }
    public boolean differ(String s, String come){
        int diff=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=come.charAt(i)){
                diff++;
            }
        }
        if(diff==1){
            return true;
        }else{
            return false;
        }
    }
}
