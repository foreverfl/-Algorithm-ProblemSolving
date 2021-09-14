package baekjoon;

import java.util.Scanner;

public class _15649_NandM_1 {

	public static int[] arr;
	public static boolean[] visit;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		visit = new boolean[N]; // 이 때 재귀를 하면서 이미 방문한 노드(값)이라면 다음 노드를 탐색하도록 하기 위해(유망한 노드인지 검사하기 위해) N 크기의
								// boolean 배열을 생성 - 4
		arr = new int[M]; // 탐색과정에서 값을 담을 int 배열 arr - 2
		dfs(N, M, 0);

	}

	public static void dfs(int N, int M, int depth) {
		// 재귀 깊이가 M(2)과 같아지면 탐색과정에서 담았던 배열을 출력
		if (depth == M) { // depth의 초기값은 0이므로 false
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return; 
		}

		for (int i = 0; i < N; i++) { // N은 4까지..
			// 만약 해당 노드(값)을 방문하지 않았다면?
			if (!visit[i]) {
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
