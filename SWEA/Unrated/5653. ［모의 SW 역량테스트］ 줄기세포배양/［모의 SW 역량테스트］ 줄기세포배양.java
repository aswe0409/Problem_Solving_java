import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Cell implements Comparable<Cell>{
		int row, col,state,cnt,time;
		public Cell(int row, int col, int state, int cnt, int time) {
			this.row = row;
			this.col = col;
			this.state = state;
			this.cnt = cnt;
			this.time = time;
		}
		@Override
		public int compareTo(Cell o) {
			return o.cnt - this.cnt;
		}
	}
	static int [] di = {1,-1,0,0};
	static int [] dj = {0,0,-1,1};
	static int [][] arr;
	static int n,m,k,ans;
	static boolean[][] visit;
	static PriorityQueue<Cell> pq;
	static List<Cell> li;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int test = 1; test <= TC; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            ans = 0;
            
            arr = new int[2*k+n][2*k+m];
            visit = new boolean[2*k+n][2*k+m];
            pq = new PriorityQueue<>();
            li = new ArrayList<>();
            
            for(int i = 0; i < n;i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < m; j++) {
            		int temp = Integer.parseInt(st.nextToken());
            		arr[k+i][k+j] = temp;
            		if(temp !=0) {
            			li.add(new Cell(k+i,k+j,0,temp,temp+temp));
            			visit[k+i][k+j] = true;
            		}
            	}
            }
            bfs();
            for(int i = 0; i < li.size(); i++) {
            	if(li.get(i).state == 0 || li.get(i).state ==1) {
            		ans +=1;
            	}
            }
            System.out.println("#" + test + " " + ans);
        }
	}
	static void bfs() {
		for(int i = 1; i <=k; i++) {
			//큐에 활성 상태인 세포 넣익
			for(int j = 0; j < li.size(); j++) {
				if(li.get(j).state == 1) {
					pq.offer(li.get(j));
				}
			}
			
			for(int j = 0; j < li.size(); j++) {
				li.get(j).time--;
				//죽여
				if(li.get(j).time == 0 && li.get(j).state ==1) {
					li.get(j).state = 2;
				}
				//비활 상태고 깰 시간이면 살려
				else if(li.get(j).state == 0 && li.get(j).time==li.get(j).cnt) {
					li.get(j).state = 1;
				}
			}
			//번식
			int size = pq.size();
			for(int j = 0; j < size; j++) {
				Cell cur = pq.poll();
				for(int d = 0; d < 4; d++) {
					int newi = cur.row+di[d];
					int newj = cur.col+dj[d];
					if(!visit[newi][newj]) {
						visit[newi][newj] = true;
						li.add(new Cell(newi,newj,0,cur.cnt,cur.cnt+cur.cnt));
					}
				}
			}
			
			
		}
	}
}