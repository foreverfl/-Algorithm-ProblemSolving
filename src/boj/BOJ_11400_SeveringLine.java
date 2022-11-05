package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11400_SeveringLine {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int count = 1;
	static int[] order;
	static ArrayList<Node> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			arraylist.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			arraylist.get(A).add(B);
			arraylist.get(B).add(A);
		}

		order = new int[V + 1];
		ans = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			if (order[i] == 0) {
				dfs(i, 0, arraylist);
			}
		}

		// ������ ����� x�� �������� �������� �����ϵ�,
		// x ���� ���ٸ� y ���� �������� �������� �����Ѵ�.
		Collections.sort(ans, (a1, a2) -> (a1.x == a2.x) ? a1.y - a2.y : a1.x - a2.x);

		StringBuilder sb = new StringBuilder();
		sb.append(ans.size() + "\n");

		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i).x + " " + ans.get(i).y + "\n");
		}

		System.out.println(sb.toString());

	}

	public static int dfs(int vertax, int parent, ArrayList<ArrayList<Integer>> arraylist) {
		order[vertax] = count++;
		int ret = order[vertax];

		// �ڽ� �˻�
		for (int now : arraylist.get(vertax)) {
			// ���� �� ���� �����Ѵ�.
			if (now == parent) {
				continue;
			}

			if (order[now] == 0) { // �ڽ� ������ �湮���� �ʾ��� ���
				// �ڽ� ���� �� �湮 ������ ���� ���� ��.
				// �̶�, Ư�� �ڽ� ������ ���� ���� ������ Ÿ�� Ÿ�� �ö󰡼� 1�� ��������
				// �� ���� �ִٴ� ���� �����ؾ� ��.
				int low = dfs(now, vertax, arraylist);

				// ���� ���� �湮 ������ vertax�� �湮 �������� ũ�ų� ���� ���
				// �ش� edge�� ��������.
				// �ٸ� �������� �� ���� ���� ���� �ϱ� ���Ͽ�
				// now�� vertax�� �� ���� ���� ���������� ������.
				if (low > order[vertax]) {
					if (now > vertax) {
						ans.add(new Node(vertax, now));
					} else {
						ans.add(new Node(now, vertax));
					}
				}
				ret = Math.min(ret, low);
			} else { // �ڽ� ������ �湮�Ǿ��� ���
				ret = Math.min(ret, order[now]);
			}
		}

		return ret;
	}
}
