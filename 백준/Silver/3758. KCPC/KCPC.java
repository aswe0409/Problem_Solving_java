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
	static class Team implements Comparable<Team>{
		int id, totalScore, submitCnt, lastTime;
		Team(int id, int totalScore, int submitCnt, int lastTime){
			this.id = id;
            this.totalScore = totalScore;
            this.submitCnt = submitCnt;
            this.lastTime = lastTime;
		}
		@Override
        public int compareTo(Team o) {
            if (this.totalScore != o.totalScore)
                return o.totalScore - this.totalScore; // 점수 높은 순
            if (this.submitCnt != o.submitCnt)
                return this.submitCnt - o.submitCnt; // 제출 횟수 적은 순
            return this.lastTime - o.lastTime; // 마지막 제출 시간 빠른 순
        }
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int test = 0; test < T; test++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); // 팀 개수
            int K = Integer.parseInt(st.nextToken()); // 문제 개수
            int myId = Integer.parseInt(st.nextToken()); //우리팀 팀 아이디
            int M = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수
            
            int[][] score = new int[N + 1][K + 1];
            int[] submitCnt = new int[N + 1];
            int[] lastTime = new int[N + 1];      

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int sc = Integer.parseInt(st.nextToken());

                score[id][problem] = Math.max(score[id][problem], sc);
                submitCnt[id]++;
                lastTime[id] = i;
            }

            List<Team> list = new ArrayList<>();

            for (int id = 1; id <= N; id++) {
                int total = 0;
                for (int p = 1; p <= K; p++) {
                    total += score[id][p];
                }
                list.add(new Team(id, total, submitCnt[id], lastTime[id]));
            }

            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).id == myId) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
        
    }
}
