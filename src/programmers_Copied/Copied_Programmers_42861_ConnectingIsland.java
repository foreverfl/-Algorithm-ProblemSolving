package programmers_Copied;

import java.util.Arrays;

public class Copied_Programmers_42861_ConnectingIsland {

	public static void main(String[] args) {
		System.out
				.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
		System.out.println(solution(5,
				new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 3 }, { 2, 3, 8 }, { 3, 4, 1 } }));
	}

	private static int[] parent;

	public static int solution(int n, int[][] costs) {
		// 크루스칼 알고리즘을 사용하기 위해 가중치 기준 오름차순 정렬
		Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

		// Union find를 사용하기 위해 parent 배열 선언
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i; // 처음에는 자기 자신으로 부모를 초기화
		}

		int total = 0;
		for (int[] edge : costs) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];

			int fromParent = findParent(from);
			int toParent = findParent(to);
			
			// 부모노드가 같으면(두 노드가 같은 그래프에 속하면)
			// 해당 간선을 선택하지 않는다.
			if (fromParent == toParent)
				continue;

			total += cost;
			parent[toParent] = fromParent; // 간선을 연결해 두 노드가 같은 그래프에 속하게 되었으므로 부모 노드를 갱신
//			System.out.println(Arrays.toString(parent));
		}
		return total;
	}

	// 부모노드가 자기자신과 같은 노드를 찾을 때 까지 재귀호출
	private static int findParent(int node) {
		if (parent[node] == node)
			return node;
		
		return parent[node] = findParent(parent[node]);
	}

}
