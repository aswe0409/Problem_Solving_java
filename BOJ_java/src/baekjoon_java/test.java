package baekjoon_java;

public class test {
	public static void main(String[] args) {
		int n = 5;
		int ret = 1;
		for(int i = n; i > 0; i--) {
			System.out.print(i+" ");
			ret = ret * i;
		}
		System.out.println(ret);
	}
}
