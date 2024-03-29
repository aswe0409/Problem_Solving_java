import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class jewel implements Comparable<jewel>{
		int weight, value, idx;
		jewel(int weight, int value, int idx){
			this.weight = weight;
			this.value = value;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "jewel [weight=" + weight + ", value=" + value + "]";
		}

		@Override
		public int compareTo(jewel o) {
			if(this.value == o.value) {
				return this.weight - o.weight;
			}
			return o.value - this.value ;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		jewel [] arr = new jewel[n];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),i);
		}
//		for(int i =0; i < n; i++) {
//			System.out.println(arr[i].toString());
//		}
		
		int [] bag = new int[k];
		for(int i =0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		// 보석을 무게에 따라 오름차순으로 정렬
        Arrays.sort(arr, (o1, o2) -> o1.weight - o2.weight);
        
//		for(int i =0; i < n; i++) {
//			System.out.println(arr[i].toString());
//		}
		Arrays.sort(bag);
//		for(int i = 0;i < k;i++) {
//			System.out.println(bag[i]);
//		}
		
		////////// input 다 받음
		long ret = 0;
		boolean [] select = new boolean[n];
        PriorityQueue<jewel> possible = new PriorityQueue<>();
        int j = 0; // arr 배열의 인덱스
        for(int i = 0; i < k; i++) {
            while(j < n && arr[j].weight <= bag[i]) {
                if (!select[arr[j].idx]) { // 이미 사용되지 않은 보석만 추가
                    possible.add(arr[j]);
                }
                j++;
            }
            while (!possible.isEmpty()) {
                jewel temp = possible.poll();
                if (!select[temp.idx]) { // 선택된 보석이 이미 사용되지 않았다면
                    select[temp.idx] = true;
                    ret += temp.value;
                    break; 
                }
            }
        }

        System.out.println(ret);
    }
}