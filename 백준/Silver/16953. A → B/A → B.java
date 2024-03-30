import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        long A = sc.nextInt();
	        long B = sc.nextInt();
	        
	        Queue<Long> q = new LinkedList<>();
	        q.offer(A*2);
	        q.offer(A*10+1);
	 
	        int ret = 0;
	        while(!q.isEmpty()) {
	            ret+=1;
	            int size = q.size();
	 
	            for (int i = 0; i < size; i++) {
	                long temp = q.poll();
	                if(temp > B) continue;
	                if(temp == B) {
	                    System.out.println(ret+1);
	                    return;
	                }
	                q.offer(temp*2);
	                q.offer(temp*10+1);
	            }
	        }
	        System.out.println(-1);
	    }
	}