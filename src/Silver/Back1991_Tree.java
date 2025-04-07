package Silver;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Back1991_Tree {
    public static HashMap<String, String[]> tree=new HashMap<>();//String[] HashMap 한번 사용해보자
    public static void main(String[] args)throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int nodes=Integer.parseInt(bf.readLine()); //노드의 갯수
        StringTokenizer st;

        for(int i=0; i<nodes; i++){ //트리를 분배한다.
            st= new StringTokenizer(bf.readLine());
            String parent=st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.put(parent, new String[]{left, right});
        }
        PreOrder("A");
        System.out.println();
        InOrder("A");
        System.out.println();
        PostOrder("A");
    }

    public static void PreOrder(String node){ //나->왼->오
        if (node.equals(".")) return;
        System.out.print(node);
        PreOrder(tree.get(node)[0]);
        PreOrder(tree.get(node)[1]);
    }
    public static void InOrder(String node){// 왼 -> 나-> 오
        if(node.equals(".")) return;
        InOrder(tree.get(node)[0]);
        System.out.print(node);
        InOrder(tree.get(node)[1]);
    }
    public static void PostOrder(String node){//왼 -> 오 -> 나
        if(node.equals(".")) return;
        PostOrder(tree.get(node)[0]);
        PostOrder(tree.get(node)[1]);
        System.out.print(node);
    }
}
