package BOJ;

import java.util.Scanner;

public class BOJ_15649_NandM_1 {

	public static int[] arr;
	public static boolean[] visit;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		visit = new boolean[N]; // �� �� ��͸� �ϸ鼭 �̹� �湮�� ���(��)�̶�� ���� ��带 Ž���ϵ��� �ϱ� ����(������ ������� �˻��ϱ� ����) N ũ����
								// boolean �迭�� ���� - 4
		arr = new int[M]; // Ž���������� ���� ���� int �迭 arr - 2
		dfs(N, M, 0);

	}

	public static void dfs(int N, int M, int depth) {
		// ��� ���̰� M(2)�� �������� Ž���������� ��Ҵ� �迭�� ���
		if (depth == M) { // depth�� �ʱⰪ�� 0�̹Ƿ� false
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return; 
		}

		for (int i = 0; i < N; i++) { // N�� 4����..
			// ���� �ش� ���(��)�� �湮���� �ʾҴٸ�?
			if (!visit[i]) {
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
