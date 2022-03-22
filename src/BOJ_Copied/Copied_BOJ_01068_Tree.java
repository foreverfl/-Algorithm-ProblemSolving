package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01068_Tree {

	static int n, delete;
	static int[] arr;
	static int count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == -1)
				root = i;
		}

		delete = Integer.parseInt(br.readLine());

		deleteNode(delete);

		count = 0;
		visited = new boolean[n];
		countLeaf(root);

		System.out.println(count);
	}

	public static void deleteNode(int input) {
		arr[input] = -2; // The '-2' means the deleted node.
		for (int i = 0; i < n; i++) {
			if (arr[i] == input) {
				deleteNode(i);
			}
		}
	}

	public static void countLeaf(int input) {
		boolean isLeaf = true;
		visited[input] = true;
		if (arr[input] != -2) {
			for (int i = 0; i < n; i++) {
				if (arr[i] == input && visited[i] == false) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if (isLeaf)
				count++;
		}
	}
}

// reference: https://moonsbeen.tistory.com/229