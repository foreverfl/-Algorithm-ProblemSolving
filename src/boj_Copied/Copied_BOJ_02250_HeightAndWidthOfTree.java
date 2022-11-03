package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_02250_HeightAndWidthOfTree {

	static class Node {
		int parent;
		int num;
		int left;
		int right;

		Node(int num, int left, int right) {
			this.parent = -1;
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}

	static int point = 1; // coordinate of the 'x'
	static List<Node> tree = new ArrayList<>();
	static int[] levelMin;
	static int[] levelMax;
	static int maxLevel = 0; // maximum depth of tree

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		// init
		levelMin = new int[N + 1];
		levelMax = new int[N + 1];
		int rootIndex = 0;
		for (int i = 0; i <= N; i++) {
			tree.add(new Node(i, -1, -1));
			levelMin[i] = N;
			levelMax[i] = 0;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			tree.get(num).left = left;
			tree.get(num).right = right;
			if (left != -1)
				tree.get(left).parent = num;
			if (right != -1)
				tree.get(right).parent = num;
		}

		for (int i = 1; i <= N; i++) {
			if (tree.get(i).parent == -1) {
				rootIndex = i;
				break;
			}
		}

		inOrder(rootIndex, 1);

		int answerLevel = 1;
		int answerWidth = levelMax[1] - levelMin[1] + 1;
		for (int i = 2; i <= maxLevel; i++) {
			int width = levelMax[i] - levelMin[i] + 1;
			if (answerWidth < width) {
				answerLevel = i;
				answerWidth = width;
			}
		}
		System.out.println(answerLevel + " " + answerWidth);
	}

	// Inorder Traversal
	public static void inOrder(int rootIndex, int level) {
		Node root = tree.get(rootIndex);

		if (maxLevel < level)
			maxLevel = level;

		if (root.left != -1) {
			inOrder(root.left, level + 1);
		}
		// If a current node is leftmost, update.
		levelMin[level] = Math.min(levelMin[level], point);
		// Update has to occur because the coordinate 'x' is always higher.
		levelMax[level] = point;
		point++;

		if (root.right != -1) {
			inOrder(root.right, level + 1);
		}
	}

}

// reference: https://wooooooak.github.io/algorithm/2018/12/05/%EB%B0%B1%EC%A4%802250%EB%AC%B8%EC%A0%9C/
