package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solving_BOJ_14357_RedTapeCommiteeSmall {
	/*
	 * 1. departments 정렬하기
	 * 2. departments에서 양 옆으로 K만큼 빼서 리스트 만들기
	 * 3. 찬성하는 사람 조합으로 뽑기(백트래킹)
	 * 4. 리스트와 찬성/반대 사람 곱해서 더할 리스트 만들기
	 * 5. 다 더하면 그게 답이야!!
	 */

	private static int N, K;
	private static double ans;
	private static List<Double> departments;
	private static List<Double> committee;
	private static List<Integer> committee_index;
	private static List<List<String>> committee_picked;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			departments = new ArrayList<>();
			committee = new ArrayList<>();
			committee_index = new ArrayList<>();
			committee_picked = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				departments.add(Double.parseDouble(st.nextToken()));
			}

			Collections.sort(departments);

			for (int j = 0; j < K / 2; j++) {
				committee.add(departments.get(j));
				committee.add(departments.get(departments.size() - 1 - j));
				committee_index.add(j + 1);
				committee_index.add(departments.size() - 1 - j);
			}
			
			visited = new boolean[departments.size()];
			backtracking(committee_index, visited, 0, committee.size(), committee.size() / 2);
			sb.append("\n");
			sb.append("Case #" + i + ": " + ans + "\n");

		}

		System.out.println(sb.toString());
	}

	private static void backtracking(List<Integer> committee_index, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			List<String> tmp = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
				}
			}
			sb.append("\n");
			return;
		}

		if (depth == n) {
			return;
		}

		visited[depth] = true;
		backtracking(committee_index, visited, depth + 1, n, r - 1);

		visited[depth] = false;
		backtracking(committee_index, visited, depth + 1, n, r);
	}

}
