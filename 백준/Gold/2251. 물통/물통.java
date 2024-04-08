import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Bottle {
		int a;
		int b;
		int c;

		public Bottle(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	static int Acan, Bcan, Ccan;
	//static boolean [][][] visit;
	static boolean[][][] visit = new boolean[201][201][201]; // 방문 체크
	static HashSet<Integer> ans = new HashSet<>(); //c 결과 값 담아줄 배열 중복 있으면 안 되니까 set로 생성
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Acan = sc.nextInt();
		Bcan = sc.nextInt();
		Ccan = sc.nextInt();
		bfs();
		
		// 정렬
		ArrayList<Integer> al = new ArrayList<>(ans); // 정렬하기 위해 형 변환
		Collections.sort(al);

		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + " ");
		}
	}

    static void bfs() {
    	//visit = new boolean[Acan+1][Bcan+1][Ccan+1];
    	Queue<Bottle> q = new LinkedList<>();
    	q.offer(new Bottle(0,0,Ccan)); //초기 설정
    	
    	while(!q.isEmpty()) {
    		Bottle cur = q.poll();
    		if(visit[cur.a][cur.b][cur.c]) {
    			continue;
    		}
    		
    		if(cur.a == 0) { //a가 비었을 떄 c 덯기
    			ans.add(cur.c);
    		}
    		visit[cur.a][cur.b][cur.c] = true;
    		
    		// c -> a
    		if(cur.a + cur.c <= Acan) { // c에 있는 물을 다 넣었을 경우
    		    q.add(new Bottle(cur.a + cur.c, cur.b, 0));
    		}
    		else { // c에 있는 물을 a 에 못 넣었을 경우 A 가 더 클 때
    		    q.add(new Bottle(Acan, cur.b, cur.c - (Acan - cur.a)));
    		}
    		
    		// c -> b
    		if(cur.b + cur.c <= Bcan) { // c에 있는 물을 b에 다 넣었을 경우
    		    q.add(new Bottle(cur.a, cur.b + cur.c, 0));
    		}
    		else { // b로 c에 있는 물을 다 넣지 못했을 경우, B가 더 클 때
    		    q.add(new Bottle(cur.a, Bcan, cur.c - (Bcan - cur.b)));
    		}

    		// a -> b
    		if(cur.a + cur.b <= Bcan) { // a에 있는 물을 b에 다 넣었을 경우
    		    q.add(new Bottle(0, cur.a + cur.b, cur.c));
    		}
    		else { // b로 a에 있는 물을 다 넣지 못했을 경우, B가 더 클 때
    		    q.add(new Bottle(cur.a - (Bcan - cur.b), Bcan, cur.c));
    		}

    		// a -> c
    		if(cur.a + cur.c <= Ccan) { // a에 있는 물을 c에 다 넣었을 경우
    		    q.add(new Bottle(0, cur.b, cur.a + cur.c));
    		}
    		else { // c로 a에 있는 물을 다 넣지 못했을 경우, C가 더 클 때
    		    q.add(new Bottle(cur.a - (Ccan - cur.c), cur.b, Ccan));
    		}

    		// b -> a
    		if(cur.b + cur.a <= Acan) { // b에 있는 물을 a에 다 넣었을 경우
    		    q.add(new Bottle(cur.b + cur.a, 0, cur.c));
    		}
    		else { // a로 b에 있는 물을 다 넣지 못했을 경우, A가 더 클 때
    		    q.add(new Bottle(Acan, cur.b - (Acan - cur.a), cur.c));
    		}

    		// b -> c
    		if(cur.b + cur.c <= Ccan) { // b에 있는 물을 c에 다 넣었을 경우
    		    q.add(new Bottle(cur.a, 0, cur.b + cur.c));
    		}
    		else { // c로 b에 있는 물을 다 넣지 못했을 경우, C가 더 클 때
    		    q.add(new Bottle(cur.a, cur.b - (Ccan - cur.c), Ccan));
    		}
    	}
    }
}