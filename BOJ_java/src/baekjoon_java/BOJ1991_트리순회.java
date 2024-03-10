package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1991_트리순회 {
	static class Node{
		int root, left, right;
		Node(int root, int left, int right){
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
	static ArrayList<Node> arr;
	static StringBuilder sb = new StringBuilder();
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			arr.add(new Node(0,0,0));
		}
		
		for(int i = 0; i < n; i++) {
		    String line = br.readLine().trim();
		    StringTokenizer st = new StringTokenizer(line, " "); // 공백을 구분자로 사용
		    int root = st.nextToken().charAt(0) - 'A'; // 첫 번째 문자 - 'A'
		    int left = st.nextToken().charAt(0) - 'A'; // 두 번째 문자 - 'A'
		    int right = st.nextToken().charAt(0) - 'A'; // 세 번째 문자 - 'A'

		    arr.set(root, new Node(root, left, right));
		}
		preorder(0); //전위 순회
		System.out.println(sb);
		sb.setLength(0);
		inorder(0); // 중위 순회
		System.out.println(sb);
		sb.setLength(0);
		postorder(0); // 후위 순회
		System.out.println(sb);
	}
	
	private static void preorder(int idx) { //전위 순회 부모, 좌, 우

		Node temp = arr.get(idx);
		sb.append((char)(temp.root + 'A'));
		
		if(temp.left != -19) {
			preorder(temp.left);
		}
		if(temp.right != -19) {
			preorder(temp.right);
		}
		return;
	}
	
	private static void inorder(int idx) { //증위 좌 부모 우
		Node temp = arr.get(idx);
		
		if(temp.left != -19) {
			inorder(temp.left);
		}
		
		sb.append((char)(temp.root + 'A'));
		
		if(temp.right != -19) {
			inorder(temp.right);
		}
		return;
	}
	
	private static void postorder(int idx) { //후위 좌 우 부모
		Node temp = arr.get(idx);
		
		if(temp.left != -19) {
			postorder(temp.left);
		}
		if(temp.right != -19) {
			postorder(temp.right);
		}
		sb.append((char)(temp.root + 'A'));
		return;
	}
}
