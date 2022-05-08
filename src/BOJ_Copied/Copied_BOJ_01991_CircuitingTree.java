package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_01991_CircuitingTree {

	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;

		}
	}

	static List<Node>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int data = st.nextToken().charAt(0) - 'A' + 1;
			int left = st.nextToken().charAt(0) - 'A' + 1;
			int right = st.nextToken().charAt(0) - 'A' + 1;
			list[data].add(new Node(left, right));
		}

		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		System.out.println(sb.toString());

	}

	// root > left > right
	static void preorder(int start) {
		for (Node node : list[start]) {
			int l = node.left;
			int r = node.right;

			sb.append((char) (start + 'A' - 1));
			if (l != -18) // The -18 means the '.'.
				preorder(l);
			if (r != -18)
				preorder(r);
		}
	}

	// left > root > right
	static void inorder(int start) {
		for (Node node : list[start]) {
			int l = node.left;
			int r = node.right;

			if (l != -18)
				inorder(l);
			sb.append((char) (start + 'A' - 1));
			if (r != -18)
				inorder(r);
		}
	}

	// left > right > root
	static void postorder(int start) {
		for (Node node : list[start]) {
			int l = node.left;
			int r = node.right;

			if (l != -18)
				postorder(l);
			if (r != -18)
				postorder(r);
			sb.append((char) (start + 'A' - 1));
		}
	}
}

// reference: https://loosie.tistory.com/344