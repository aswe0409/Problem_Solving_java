import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int visit[] ; // 돈 입력 해 둘거라 int 배열 선언
	static Room[] roomArr;
	static ArrayList<Integer> roomList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            roomArr = new Room[n];

            for(int i=0; i<n; i++) {
                String[] s = br.readLine().split(" ");
                char room = s[0].charAt(0);
                int cost = Integer.parseInt(s[1]);
                visit = new int[n];
                Arrays.fill(visit, -1);

                roomList = new ArrayList<>();
                for(int j=2; j<s.length-1; j++) {
                    roomList.add(Integer.parseInt(s[j])-1);
                }

                roomArr[i] = new Room(i, room, roomList, cost);
            }
            bfs();
        }
	}// main
	
	static void bfs() {
		//시작
		if(roomArr[0].rType == 'T') return; //맨 처음 방이 트롤이면 못 지나감
		Queue<User> q = new LinkedList<>();
		if(roomArr[0].rType == 'L') { //레플리콘 이면
			q.add(new User(0,roomArr[0].cost));
			visit[0] = roomArr[0].cost;
		}
		else { //빈 방이면
			q.add(new User(0,0));
			visit[0] = 0;
		}
		
		while(!q.isEmpty()) {
			User temp = q.poll();
			
			if(temp.idx == n-1) { // 목표 방에 도착 했다면
				System.out.println("Yes");
				return;
			}
			
			
			for(int nextRoom : roomArr[temp.idx].doorList) {
				if(roomArr[nextRoom].rType == 'T') {// 다음 방이 트롤이면
					if(roomArr[nextRoom].cost <= temp.money) { //사용 자의 돈이 더 많고
						if(visit[nextRoom] < temp.money - roomArr[nextRoom].cost) { //이미 왔던 애보다 코스트가 더 크다면?
							q.add(new User(nextRoom, temp.money - roomArr[nextRoom].cost));
							visit[nextRoom] = temp.money - roomArr[nextRoom].cost;
						}
					}
				} // if 트롤
				
				//다음 방이 레플ㄹ리콘
				else if(roomArr[nextRoom].rType == 'L') {
					// 들어온 애가 더 큰데 처음 방문 or 방 가격이 더 크면
					if(visit[nextRoom] < temp.money) {
						int cost = Math.max(roomArr[nextRoom].cost, temp.money);
						visit[nextRoom] = cost;
						q.add(new User(nextRoom, cost));
					}
				}
				//빈 방
				else {
					if(temp.money > visit[nextRoom]) {
						q.add(new User(nextRoom, temp.money));
						visit[nextRoom] = temp.money;
					}
				}
			}
		}
		System.out.println("No");
	}
	static class Room{
		int rNum; // 방 번호
		char rType; // 방 종류 e:빈방, l: 레플리콘  t: 트롤
		ArrayList<Integer> doorList; // 해당 방에서 갈 수 있는 곳 들
		int cost; //해당 방 가격
		
		Room(int rNum, char rType, ArrayList<Integer> doorList, int cost){
			this.rNum = rNum;
			this.rType = rType;
			this.doorList = doorList;
			this.cost = cost;
		}
	}
	
	static class User{
		int idx, money; // 현재 있는 인덱스 , 현재 갖고 있는 돈
		User(int idx, int money){
			this.idx = idx;
			this.money = money;
		}
	}
}