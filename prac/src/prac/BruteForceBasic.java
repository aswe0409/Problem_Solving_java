package prac;

public class BruteForceBasic  {
    static String[] cards = {"A","B","C"};
    static int N=5, R=3;
    static String[] ret;
	static boolean[] select = new boolean[cards.length];
    
    public static void main(String[] args) {
        // 여기서 아래 4개의 실행을 모두 테스트 하시오!!!
    	ret = new String[R];
    	//perm(0);
    	subset(0);
    	//comb1(0,0);
    	//comb2(0, 0);
    }
    
    // 5개중에 3개 뽑아 순서 나열하는 순열 구현
    static void perm(int idx) {
    	// end condition
    	if(idx == 3) {
    		for(String ch : ret) {
    			System.out.print(ch+" ");
    		}
    		System.out.println();
    		return;
    	}
    	//현재 내가 할 일
    	for(int i = 0; i < cards.length; i++) {
    		if(!select[i]) {
    			select[i] = true;
    			ret[idx] = cards[i];
    			perm(idx +1);
    			select[i] = false;
  
    		}
    	}
    }
    
    // 5개의 재료중 그 무엇이든 상관없이 부분 원소로 구현된 모든 부분집합 구현
	static void subset(int idx) { 
		if(idx == cards.length) { 
			for(int i = 0; i < cards.length; i++) {
				if(select[i]) {
					System.out.print(cards[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		select[idx] = true; 
		subset(idx+1); 
		select[idx] = false; 
		subset(idx+1); 
	}
    
    // 5개중에 3개 뽑은 순서 상관없는 조합 구현 : 태희쌤 버전 반복문 사용 
    static void comb1(int cnt ,int start) {
    	if(R == cnt ) {
    		for(String ch : ret) {
    			System.out.print(ch+" ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	for(int i = start; i < cards.length; i++) {
    		ret[cnt] = cards[i];
    		comb1(cnt+1, i+1);
    	}
    }
    
    // 5개중에 3개 뽑은 순서 상관없는 조합 구현 : 양유 버전 반복문 사용금지!!(부분집합 버전) 
	static void comb2(int idx, int cnt) { 
		if(cnt == R) { // 3명 고르면 return
			for(int i = 0; i < cards.length; i++) {
				if(select[i]) {
					System.out.print(cards[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		if(idx >= 5) {
			return;
		}
		select[idx] = true; 
		comb2(idx+1, cnt+1); 
		select[idx] = false; 
		comb2(idx+1, cnt); 
	}
}
