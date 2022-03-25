package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Copied_BOJ_12906_NewTowerOfHanoi {

	static class Node {
		Stack<Character>[] tower;

		Node() {
			this.tower = new Stack[3];

			for (int i = 0; i < 3; ++i) {
				this.tower[i] = new Stack<>();
			}
		}

		public String statusCode() {
			String result = "";

			for (char c : this.tower[0])
				result += c;
			result += '/';
			for (char c : this.tower[1])
				result += c;
			result += '/';
			for (char c : this.tower[2])
				result += c;

			return result;
		}
	}

	static HashSet<String> set; // checking whether to visit
	static Queue<Node> queue;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		set = new HashSet<>();
		queue = new LinkedList<>();

		int a, b, c;
		a = b = c = 0;

		Node start = new Node();
		for (int i = 0; i < 3; ++i) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("0"))
				continue;

			for (char ch : st.nextToken().toCharArray()) {
				if (ch == 'A')
					a++;
				if (ch == 'B')
					b++;
				if (ch == 'C')
					c++;
				start.tower[i].push(ch);
			}
		}

		Node end = new Node();
		for (int i = 0; i < a; ++i)
			end.tower[0].push('A');
		for (int i = 0; i < b; ++i)
			end.tower[1].push('B');
		for (int i = 0; i < c; ++i)
			end.tower[2].push('C');

		answer = end.statusCode();

		// starting BFS
		queue.offer(start);
		set.add(start.statusCode()); // visited
		System.out.println(bfs());
	}

	private static int bfs() {
		int times = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; ++i) {
				Node now = queue.poll();

				if (now.statusCode().equals(answer)) {
					return times;
				}

				for (int from = 0; from < 2; from++) {
					for (int to = 0; to < 3; to++) {
						if (!now.tower[from].isEmpty()) {
							Node next = copy(now);

							next.tower[to].push(next.tower[from].pop());
							String statusCode = next.statusCode();
							if (!set.contains(statusCode)) {
								set.add(statusCode);
								queue.offer(next);
							}
						}
						if (!now.tower[to].isEmpty()) {
							Node next = copy(now);

							next.tower[from].push(next.tower[to].pop());
							String statusCode = next.statusCode();
							if (!set.contains(statusCode)) {
								set.add(statusCode);
								queue.offer(next);
							}
						}

					}
				}
			}
			times++;
		}

		return times;
	}

	private static Node copy(Node origin) {
		Node result = new Node();

		for (int i = 0; i < 3; ++i) {
			for (char ch : origin.tower[i])
				result.tower[i].push(ch);
		}

		return result;
	}

}

// reference: https://velog.io/@hyeon930/BOJ-12906-%EC%83%88%EB%A1%9C%EC%9A%B4-%ED%95%98%EB%85%B8%EC%9D%B4-%ED%83%91-Java	