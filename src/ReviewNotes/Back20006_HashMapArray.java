package ReviewNotes;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Back20006_HashMapArray {
    public static ArrayList<HashMap<String, Integer>> rooms;

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(bf.readLine());
        int totalnum= Integer.parseInt(st.nextToken());//총 플레이어의 수
        int capacity= Integer.parseInt(st.nextToken()); //방의 정원.

        rooms= new ArrayList<>();

        //방을 만들땐 최초 입장 플레이어의 레벨 정보 입력.
        while(totalnum-->0){ //내 레벨과 안맞는 방만 있을때 || 레벨에 맞는 방이 다 차있을때
            st=new StringTokenizer(bf.readLine());//지금 들어오는 사람의 정보.
            int level= Integer.parseInt(st.nextToken());
            boolean check=false;
            String nickname=st.nextToken();

            if(rooms.isEmpty()){ //방이 없다.
                createRoom(level,nickname); //방만드는 함수
            }
            else{
                for(HashMap<String, Integer> room : rooms){
                    //레벨이 안맞거나, 방이 꽉찼거나 하나라도 해당하면
                    if(room.get("1")>level+10||room.get("1")<level-10||room.size()>=(capacity+1)){
                        check=true;
                    }
                    else{ //레밸 조건도 맞고, 빈방도 아닌곳 발견!
                        intoTheRoom(level, nickname, room);
                        check=false;
                        break;
                    }
                }
                if(check){ //다 돌았는데 레벨 안맞고 방 꽉찬곳만 봤어요.
                    createRoom(level, nickname);
                }
            }
        }

        for(HashMap<String, Integer> room : rooms) {
            List<String> keySet = new ArrayList<>(room.keySet());
            Collections.sort(keySet);
            if(room.size()>=capacity+1){
                System.out.println("Started!");
            }
            else{
                System.out.println("Waiting!");
            }
            for(String key : keySet){
                if(Objects.equals(key,"1")){
                    continue;
                }
                System.out.println(room.get(key)+" "+key);
            }
        }
    }


    public static void createRoom(int level, String nickname){
        rooms.add(new HashMap<>());
        rooms.get(rooms.size()-1).put("1", level);
        rooms.get(rooms.size()-1).put(nickname, level);
    }

    public static void intoTheRoom(int level, String nickname, HashMap<String, Integer> room){//기존에 있는 방에 침투
        room.put(nickname, level);
    }
}
