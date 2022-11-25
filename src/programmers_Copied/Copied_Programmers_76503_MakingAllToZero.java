package programmers_Copied;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Copied_Programmers_76503_MakingAllToZero {

	public static void main(String[] args) {
		System.out.println(
				solution(new int[] { -5, 0, 2, 1, 2 }, new int[][] { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } }));
		System.out.println(solution(new int[] { 0, 1, 0 }, new int[][] { { 0, 1 }, { 1, 2 } }));
	}

	private static ArrayList<Integer>[] list; // 간선 정보로 list생성
	private static boolean[] visited;
	private static int[] indegree; // 진입 간선 → 리프 노트를 찾는다.
	private static long[] long_a; // 연산 수행 위한 long배열
	private static long result;

	public static long solution(int[] a, int[][] edges) {
		long_a = new long[a.length];
		list = new ArrayList[a.length];
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			long_a[i] = a[i];
			list[i] = new ArrayList<>();
		}
		if (sum != 0)
			return -1;

		indegree = new int[a.length];
		for (int i = 0; i < edges.length; i++) {
			list[edges[i][0]].add(edges[i][1]);
			list[edges[i][1]].add(edges[i][0]);
			indegree[edges[i][0]]++;
			indegree[edges[i][1]]++;
		}

		visited = new boolean[a.length];
		topology(); // 위상정렬 알고리즘 활용하여 리프노드에서 루트까지 가중치 이동횟수 구함
		return result;
	}

	private static void topology() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 1)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			visited[current] = true;

			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				if (!visited[next]) {
					indegree[next]--;
					long_a[next] += long_a[current];// +1, -1해주었다고 생각하여 합친 값을 저장
					result += Math.abs(long_a[current]); // 현재 노드에서 이동한 값 만큼 result에 더해줌
					long_a[current] = 0; // 현재 노드의 모든 가중치 값을 부모로 이동.
					if (indegree[next] == 1)
						queue.offer(next);
				}
			}
		}
	}

}
