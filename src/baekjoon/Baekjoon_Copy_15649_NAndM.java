package baekjoon;

import java.util.Scanner;

public class Baekjoon_Copy_15649_NAndM {

	public static int[] arr;
	public static boolean[] visit;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);

	}

	public static void dfs(int N, int M, int depth) {
		// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력(해당 depth에서 다 찾았다면)
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) { // 만약 해당 노드(값)을 방문하지 않았다면?
				visit[i] = true; // 해당 노드를 방문상태로 변경
				arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
				dfs(N, M, depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
				visit[i] = false; // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
			}
		}
	}

}

/*
 * 일단 주석으로 설명을 했지만 다시 한번 설명하자면, 중복되는 수는 담을수 없기에 방문할 필요조차 없다. 즉, 방문 상태를 판단하기 위해
 * visit[] 배열이 있는 것이고, 해당 index가 방문하지 않는 노드(값)일 때만 재귀호출을 해주면 된다. 이게 백트래킹의 가장 기초라
 * 할 수 있다.
 */
