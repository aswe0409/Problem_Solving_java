import java.util.*;
import java.io.*;

public class Main {
    static class Map{
        int row, col, value, blank;
        Map(int row, int col, int value, int blank){
            this.row = row;
            this.col = col;
            this.value = value;
            this.blank = blank;
        }
    }
    static Map[][] map;
    static int[][] student;
    static int n;
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new Map[n][n];
        student = new int[n * n][5];
        
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 빈칸 개수 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int blank = 0;
                for (int d = 0; d < 4; d++) {
                    int newi = i + di[d];
                    int newj = j + dj[d];
                    if (newi >= 0 && newi < n && newj >= 0 && newj < n) {
                        blank++;
                    }
                }
                map[i][j] = new Map(i, j, 0, blank);
            }
        }
        
        for (int i = 0; i < n * n; i++) {
            batch(i);
        }
        
        System.out.println(satisfied());
    }
    
    static void batch(int start) {
        int studentNum = student[start][0];
        List<int[]> candidates = new ArrayList<>();
        int maxFriends = -1, maxBlank = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].value != 0) continue; // 이미 배정된 자리 제외
                
                int friends = 0, blank = map[i][j].blank;
                
                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                        for (int k = 1; k < 5; k++) {
                            if (map[ni][nj].value == student[start][k]) {
                                friends++;
                                break;
                            }
                        }
                    }
                }
                
                if (friends > maxFriends || (friends == maxFriends && blank > maxBlank)) {
                    candidates.clear();
                    maxFriends = friends;
                    maxBlank = blank;
                }
                if (friends == maxFriends && blank == maxBlank) {
                    candidates.add(new int[]{i, j});
                }
            }
        }
        
        candidates.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // 행 기준 -> 열 기준
            return a[0] - b[0];
        });
        
        int row = candidates.get(0)[0], col = candidates.get(0)[1];
        map[row][col].value = studentNum;
        
        for (int d = 0; d < 4; d++) {
            int ni = row + di[d];
            int nj = col + dj[d];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && map[ni][nj].value == 0) {
                map[ni][nj].blank--;
            }
        }
    }
    
    static int satisfied() {
    	int score = 0;
    	
    	//좋아하는 친구 몇명 있는지 구하기
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			int studentNum = map[i][j].value;
                int friendsCount = 0;
                int studentIndex = -1;
                
                // student 배열에서 studentNum이 몇 번째인지 찾기
                for (int s = 0; s < n * n; s++) {
                    if (student[s][0] == studentNum) {
                        studentIndex = s;
                        break;
                    }
                }

                if (studentIndex == -1) continue; // 해당 학생이 없을 경우 예외 처리

                for (int d = 0; d < 4; d++) {
                    int newi = i + di[d];
                    int newj = j + dj[d];

                    if (newi >= 0 && newi < n && newj >= 0 && newj < n) {
                        for (int k = 1; k < 5; k++) {
                            if (map[newi][newj].value == student[studentIndex][k]) {
                                friendsCount++;
                                break;
                            }
                        }
                    }
                }

                if (friendsCount > 0) {
                    score += Math.pow(10, friendsCount - 1);
                }
            }
        }
        return score;
    }
}