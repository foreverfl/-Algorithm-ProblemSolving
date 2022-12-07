package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solving_BOJ_06188_ClearColdWater {

	private static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}

	}

	private static class BinaryTree {
		Node head;
		int size;

		public BinaryTree() {
			head = null;
			size = 0;
		}

		public void push(Node now) {
			if (size == 0) {
				Node node = now;
				head = node;
			} else {
				Node node = head;

				Queue<Node> queue = new LinkedList<Node>();
				queue.add(node);

				while (!queue.isEmpty()) {
					Node temp = queue.poll();

					if (temp.left == null) {
						temp.left = now;
						break;
					} else {
						queue.add(temp.left);
					}

					if (temp.right == null) {
						temp.right = now;
						break;
					} else {
						queue.add(temp.right);
					}
				}
			}
			size++;
		}

		private boolean isSame(Node a, Node b) {
			if (a.value == b.value) {
				return true;
			}
			return false;
		}

		public boolean contain(Node node) {
			boolean check = false;

			if (size != 0) {
				Queue<Node> queue = new LinkedList<Node>();
				queue.add(head);

				while (!queue.isEmpty()) {
					Node temp = queue.poll();

					if (isSame(temp, node)) {
						check = true;
						break;
					}

					if (temp.left != null) {
						queue.add(temp.left);
					}

					if (temp.right != null) {
						queue.add(temp.right);
					}
				}
			}
			return check;
		}

		public void printBFS(Node node) {

			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);

			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				System.out.println(temp.value);

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
	}

	private static List<int[]> list = new ArrayList<>();
	private static int N, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			list.add(new int[] { now, left, right });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		BinaryTree binaryTree = new BinaryTree();
		for (int i = 0; i < N; i++) {
			Node node = new Node(i);
			binaryTree.push(node);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 3; j++) {
				Node node = new Node(j);
				if (!binaryTree.contain(node)) {
					binaryTree.push(node);
				}
			}

		}

	}

}
