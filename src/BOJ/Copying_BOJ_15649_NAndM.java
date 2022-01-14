package BOJ;

import java.util.Scanner;

public class Copying_BOJ_15649_NAndM {

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
		// ��� ���̰� M�� �������� Ž���������� ��Ҵ� �迭�� ���(�ش� depth���� �� ã�Ҵٸ�)
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) { // ���� �ش� ���(��)�� �湮���� �ʾҴٸ�?
				visit[i] = true; // �ش� ��带 �湮���·� ����
				arr[depth] = i + 1; // �ش� ���̸� index�� �Ͽ� i + 1 �� ����
				dfs(N, M, depth + 1); // ���� �ڽ� ��� �湮�� ���� depth 1 ������Ű�鼭 ���ȣ��
				visit[i] = false; // �ڽĳ�� �湮�� ������ ���ƿ��� �湮��带 �湮���� ���� ���·� ����
			}
		}
	}

}

/*
 * �ϴ� �ּ����� ������ ������ �ٽ� �ѹ� �������ڸ�, �ߺ��Ǵ� ���� ������ ���⿡ �湮�� �ʿ����� ����. ��, �湮 ���¸� �Ǵ��ϱ� ����
 * visit[] �迭�� �ִ� ���̰�, �ش� index�� �湮���� �ʴ� ���(��)�� ���� ���ȣ���� ���ָ� �ȴ�. �̰� ��Ʈ��ŷ�� ���� ���ʶ�
 * �� �� �ִ�.
 */
