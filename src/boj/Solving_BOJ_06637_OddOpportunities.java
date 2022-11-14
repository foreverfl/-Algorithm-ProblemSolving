package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solving_BOJ_06637_OddOpportunities {
	/*
	 * 1. 백트래킹으로 모든 조합 선택(1개 선택시 ~ n개 선택시)
	 * 2. 해당 조합이 조건을 만족하는지 판단하기
	 * 3. 만족하다면 그 조합을 출력하고 그렇지 않다면 impossible을 출력한다.
	 */
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			String testCase = br.readLine();

			if (testCase.equals("0 0"))
				break;

			st = new StringTokenizer(testCase);
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			String[] contacts = new String[E];
			boolean[] visited = new boolean[E];
			for (int i = 0; i < E; i++) {
				contacts[i] = br.readLine();
			}

			String ideal = br.readLine();

			for (int i = 1; i <= E; i++) {
				backTracking(contacts, visited, 0, E, i, V, ideal);
			}
		}

		System.out.println(sb.toString());
	}

	private static void backTracking(String[] arr, boolean[] visited, int depth, int n, int r, int V, String ideal) {
		if (r == 0) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					list.add(arr[i]);
				}
			}

			if (isPossible(list, V, ideal)) {
				sb.append(list.size()).append('\n');
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i)).append('\n');
				}
			} else {
				sb.append("impossible").append('\n');
			}

			return;
		}

		if (depth == n) {
			return;
		}

		visited[depth] = true;
		backTracking(arr, visited, depth + 1, n, r - 1, V, ideal);

		visited[depth] = false;
		backTracking(arr, visited, depth + 1, n, r, V, ideal);
	}

	private static boolean isPossible(List<String> list, int V, String ideal) {
		int[] contacts = new int[V + 1];
		boolean[] checked = new boolean[V + 1];

		for (int i = 0; i < list.size(); i++) {
			StringTokenizer st = new StringTokenizer(list.get(i));
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			contacts[A]++;
			contacts[B]++;
		}

		for (int i = 0; i < ideal.length(); i++) {
			if (ideal.charAt(i) == 'o' && contacts[i] / 2 == 1) {
				checked[i] = true;
			} else if (ideal.charAt(i) == 'e' && contacts[i] / 2 == 0) {
				checked[i] = true;
			} else {
				checked[i] = false;
			}
		}

		for (int i = 0; i < checked.length; i++) {
			if (checked[i] == false) {
				return false;
			}
		}

		return true;
	}

	private static void print(String[] arr, boolean[] visited, int n) {
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				System.out.print(arr[i] + " / ");
			}
		}
		System.out.println();
	}

}
