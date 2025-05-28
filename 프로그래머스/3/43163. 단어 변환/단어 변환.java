import java.util.*;
import java.io.*;

class Solution {
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
