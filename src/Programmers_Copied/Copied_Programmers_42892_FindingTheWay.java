package Programmers_Copied;

import java.util.Arrays;
import java.util.Comparator;

public class Copied_Programmers_42892_FindingTheWay {

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		int[][] result = solution(nodeinfo);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

	}

	static int[][] result;
	static int idx;

	public static int[][] solution(int[][] nodeinfo) {

		Node[] nodes = new Node[nodeinfo.length];
		for (int i = 0; i < nodeinfo.length; i++) {
			nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
		}

		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if (n1.y == n2.y)
					return n1.x - n2.x;
				else
					return n2.y - n1.y;
			}
		});

		// making a tree
		Node root = nodes[0];
		for (int i = 1; i < nodes.length; i++) {
			insertNode(root, nodes[i]);
		}

		result = new int[2][nodeinfo.length]; // 1 -> pre, 2 -> post
		idx = 0;
		preorder(root);
		idx = 0; // initialization
		postorder(root);
		return result;
	}

	public static void insertNode(Node parent, Node child) {
		if (parent.x > child.x) {
			if (parent.left == null)
				parent.left = child;
			else
				insertNode(parent.left, child);
		} else {
			if (parent.right == null)
				parent.right = child;
			else
				insertNode(parent.right, child);
		}
	}

	public static void preorder(Node root) {
		if (root != null) {
			result[0][idx++] = root.value;
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			result[1][idx++] = root.value;
		}
	}

	public static class Node {
		int x;
		int y;
		int value;
		Node left;
		Node right;

		public Node(int x, int y, int value, Node left, Node right) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

}
