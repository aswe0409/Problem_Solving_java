import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int state, dir;
		Pos(int state, int dir){
			this.state = state; // 회전 상태: 0이면 놉 1이면 회전
			this.dir = dir; // 회전할 방향 1 = 시계, -1 = 반시계
		}
	}
	static int [][] wheels; // 톱니 배열
	static Pos[] order;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	wheels = new int[4][8];
  
    	// 톱니 입력
    	for(int i = 0; i < 4; i ++) {
    		String line = br.readLine();
    		for(int j = 0; j < 8; j++) {
    			wheels[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	int k = Integer.parseInt(br.readLine());
    	
    	for(int test = 0; test < k; test++) {
    		order = new Pos[4];
    		for(int i = 0; i < 4; i++) {
    			order[i] = new Pos(0,0);
    		}
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int target = Integer.parseInt(st.nextToken());
    		int dir = Integer.parseInt(st.nextToken());
    		
        	//자기 자신 회전 등록
        	order[target-1].state = 1;
        	order[target-1].dir = dir;
    		
    		// 1. 어떤 톱니 돌릴지, 뱡항 정하기
    		// 방향 확인
			rotateCheck(target -1, dir); 
    		
    		// 2. 돌려!
			rotate();	
    	}
    	int ret = 0;
    	int score = 1;
    	//점수
    	for(int i = 0; i < 4; i++) {
    		if(wheels[i][0] == 1) {
    			ret += score;
    		}
    		score *= 2;
    	}
    	System.out.println(ret);
    }
    
    //회전 시킬 톱니 정하는 함수
    static void rotateCheck(int target, int dir) {
    	int leftWheel = target - 1;
    	int rightWheel = target + 1;
    	int leftRotateDir = dir;
    	int rightRotateDir = dir;
    	
    	//왼쪽에 휠이 있을 때
    	while(leftWheel >= 0) {
    		if(wheels[leftWheel][2] != wheels[leftWheel + 1][6]) {
    			leftRotateDir *= -1;
    			order[leftWheel].state = 1;
    			order[leftWheel].dir = leftRotateDir;
    		}
    		else {
        		break;
        	}
    		leftWheel--;
    	}
    	
    	//오른쪽
    	while(rightWheel < 4) {
    		if(wheels[rightWheel -1][2] != wheels[rightWheel][6]) {
    			rightRotateDir *= -1;
    			order[rightWheel].state = 1;
    			order[rightWheel].dir = rightRotateDir;
    		}
    		else {
    			break;
    		}
    		rightWheel++;
    	} 	
    }
    static void rotate() {
    	for(int i = 0; i < 4; i++) {
    		if(order[i].state == 1) { //1 = rotate
    			//방향 설정
    			if(order[i].dir == 1) { //clockwise
    				int temp = wheels[i][7];
    				for(int j = 7; j > 0; j--) {
    					wheels[i][j] = wheels[i][j-1];
    				}
    				wheels[i][0] = temp;
    			}
    			else {//반시계
        			int temp = wheels[i][0];
        			for(int j = 0; j < 7; j++) {
        				wheels[i][j] = wheels[i][j+1];
        			}
        			wheels[i][7] = temp;
        		}
    		}
    	}
    }
}