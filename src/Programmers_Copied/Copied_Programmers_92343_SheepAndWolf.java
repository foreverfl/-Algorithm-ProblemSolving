package Programmers_Copied;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Copied_Programmers_92343_SheepAndWolf {

	public static void main(String[] args) {
		int[] info_1 = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int[][] edges_1 = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
				{ 4, 6 }, { 8, 9 } };

		System.out.println(solution(info_1, edges_1));

		int[] info_2 = { 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0 };
		int[][] edges_2 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 7 }, { 4, 8 }, { 6, 9 },
				{ 9, 10 } };

		System.out.println(solution(info_2, edges_2));

	}

	public static int res;
	public static Map<Integer, List<Integer>> nodes;

	public static int solution(int[] info, int[][] edges) {
		nodes = new HashMap<>();
		for (int[] edge : edges) {
			if (!nodes.containsKey(edge[0]))
				nodes.put(edge[0], new ArrayList<>());
			nodes.get(edge[0]).add(edge[1]);
		}

		List<Integer> list = new ArrayList<>();
		list.add(0);

		dfs(0, 0, 0, list, info);
		return res;
	}

	public static void dfs(int idx, int s, int w, List<Integer> list, int[] info) {
		if (info[idx] == 0)
			s += 1;
		else
			w += 1;

		if (s <= w)
			return;

		res = Math.max(res, s);

		List<Integer> nxt = new ArrayList<>();
		nxt.addAll(list);
		if (nodes.containsKey(idx))
			nxt.addAll(nodes.get(idx));
		nxt.remove(Integer.valueOf(idx));

		for (int n : nxt) {
			dfs(n, s, w, nxt, info);
		}

		return;
	}

}

// reference: https://velog.io/@ujone/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%96%91%EA%B3%BC-%EB%8A%91%EB%8C%80-JAVA