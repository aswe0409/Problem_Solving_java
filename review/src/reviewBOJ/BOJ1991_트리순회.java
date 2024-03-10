package reviewBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1991_트리순회 {
    
    static class Node {
        char me;
        int left, right;

        public Node(char a) {
            me = a;
            this.left = -1;
            this.right = -1;
        }

		@Override
		public String toString() {
			return "Node [me=" + me + ", left=" + left + ", right=" + right + "]";
		}
    }

    static Node[] tree;
    static int N;
    static StringBuilder pre, mid, post;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pre = new StringBuilder();
        mid = new StringBuilder();
        post = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        tree = new Node[N];

        for(int n = 0; n < N; n++) {
            String node = br.readLine();
            int parent = node.charAt(0) - 'A';
            int left = node.charAt(2) - 'A';
            int right = node.charAt(4) - 'A';

            tree[parent] = new Node((char)(parent + 'A'));

            if(left != '.' - 'A') tree[parent].left = left;
            if(right != '.' - 'A') tree[parent].right = right;
        }

        
//        for(int i = 0 ; i < N; i++) {
//        	System.out.println(tree[i].toString());
//        }
        
        dfs(0);

        System.out.println(pre);
        System.out.println(mid);
        System.out.println(post);

    }   

    static void dfs(int idx) {
        Node node = tree[idx];
        pre.append(node.me + "");

        if(node.left != -1) dfs(node.left);
//        System.out.println(node.me);
        mid.append(node.me + "");

        if(node.right != -1) dfs(node.right);
        post.append(node.me + "");
    }
}