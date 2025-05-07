//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
	static class Player implements Comparable<Player>{
		int level;
		String name;
		Player(int level, String name){
			this.level = level;
			this.name = name;
		}
		
		@Override
		public int compareTo(Player o1) {
		    return this.name.compareTo(o1.name);
		}
	}
	
	static class Room {
	    int possible;
	    ArrayList<Player> players;

	    Room(int possible) {
	        this.possible = possible;
	        this.players = new ArrayList<>();
	    }
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방 정원
        
        ArrayList<Room> arr = new ArrayList<>();
        
        for(int i = 0; i < p; i++) {
        	st = new StringTokenizer(br.readLine());
        	int pLevel = Integer.parseInt(st.nextToken());
        	String pName = st.nextToken();
        	
        	
        	//1. 방 없으면 방 생성
        	if(arr.size() == 0) {
        		Room room = new Room(pLevel);
        		room.players.add(new Player(pLevel, pName));
        		arr.add(room);
        	}
        	// 2. 입장 가능 한 방 있을 때
        	else {
        	    boolean joined = false;
        	    
        	    for (Room room : arr) {
        	        // 조건: 레벨이 ±10 이내이고, 방이 정원이 안 찼을 때
        	        if (Math.abs(room.possible - pLevel) <= 10 && room.players.size() < m) {
        	            room.players.add(new Player(pLevel, pName));
        	            joined = true;
        	            break;
        	        }
        	    }
        	    
        	    // 조건 맞는 방이 없으면 새 방 생성
        	    if (!joined) {
        	        Room room = new Room(pLevel);
        	        room.players.add(new Player(pLevel, pName));
        	        arr.add(room);
        	    }
        	}
        }
        StringBuilder sb = new StringBuilder();
        
        for(Room room : arr) {
        	Collections.sort(room.players);

        	if(room.players.size() == m) {
        		sb.append("Started!").append("\n");
        		
        		for(Player pl : room.players) {
        			sb.append(pl.level).append(" ").append(pl.name).append("\n");
        		}
        	}
        	else {
        		sb.append("Waiting!").append("\n");
        		for(Player pl : room.players) {
        			sb.append(pl.level).append(" ").append(pl.name).append("\n");
        		}
        	}
        }
        System.out.println(sb.toString());
    }
}
