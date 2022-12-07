package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node2 = new Node(7);
		Node node3 = new Node(4);
		Node node4 = new Node(2);

		bt.push(node);
		bt.push(node1);
		bt.push(node2);
		bt.push(node3);
		bt.push(node4);

		System.out.println("BFS로 탐색합니다");
		bt.printBFS(node);

		System.out.println("\nDFS로 탐색합니다");
		bt.printDFS(node);
	}

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

		public void push(Node nd) {
			if (size == 0) {
				Node node = nd;
				head = node;
			} else {
				Node node = head;

				Queue<Node> q = new LinkedList<Node>();
				q.add(node);

				while (!q.isEmpty()) {
					Node temp = q.poll();

					if (temp.left == null) {
						temp.left = nd;
						break;
					} else {
						q.add(temp.left);
					}

					if (temp.right == null) {
						temp.right = nd;
						break;
					} else {
						q.add(temp.right);
					}
				}
			}
			size++;
		}

		public int pop(Node node) {
			if (contain(node)) {
				Node lastNode = removeLastNode();

				if (head != null) {
					if (isSame(head, node)) {
						head.value = lastNode.value;
					} else {
						Queue<Node> q = new LinkedList<Node>();
						q.add(head);

						while (!q.isEmpty()) {
							Node temp = q.poll();

							if (temp.left != null) {
								if (isSame(temp.left, node)) {
									temp.left.value = lastNode.value;
									break;
								} else {
									q.add(temp.left);
								}
							}

							if (temp.right != null) {
								if (isSame(temp.right, node)) {
									temp.right.value = lastNode.value;
									break;
								}
							}
						}
					}
				}
				size--;
				return 1;
			}
			return 0;
		}

		public boolean contain(Node node) {
			boolean check = false;

			if (size != 0) {
				Queue<Node> q = new LinkedList<Node>();
				q.add(head);

				while (!q.isEmpty()) {
					Node temp = q.poll();

					if (isSame(temp, node)) {
						check = true;
						break;
					}

					if (temp.left != null) {
						q.add(temp.left);
					}

					if (temp.right != null) {
						q.add(temp.right);
					}
				}
			}
			return check;
		}

		private Node removeLastNode() {
			Node last = head;

			if (size == 1) {
				head = null;
			} else {
				Queue<Node> q = new LinkedList<Node>();
				q.add(last);

				while (!q.isEmpty()) {
					Node temp = q.poll();
					last = temp;

					if (temp.left != null) {
						q.add(temp.left);
					}

					if (temp.right != null) {
						q.add(temp.right);
					}
				}

				q.add(head);

				while (!q.isEmpty()) {
					Node temp = q.poll();

					if (temp.left != null) {
						if (isSame(temp.left, last)) {
							temp.left = null;
							break;
						} else {
							q.add(temp.left);
						}
					}

					if (temp.right != null) {
						if (isSame(temp.right, last)) {
							temp.right = null;
							break;
						} else {
							q.add(temp.right);
						}
					}
				}
			}
			return last;
		}

		private boolean isSame(Node a, Node b) {
			if (a.value == b.value && a.left == b.left && a.right == b.right) {
				return true;
			}
			return false;
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

		public void printDFS(Node node) {

			if (node.left == null && node.right == null) {
				System.out.println(node.value);
			} else {
				if (node.left != null) {
					printDFS(node.left);
				}
				System.out.println(node.value);
				if (node.right != null) {
					printDFS(node.right);
				}
			}
		}
	}

}
