package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14864_Lining {

	static int[] arr;
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			arr[X]++;
			arr[Y]--;
		}

		if (check()) {
			for (int i = 1; i <= N; i++) {
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.print(-1);
		}

	}

	public static boolean check() {
		for (int i = 1; i <= N; i++) {
			visited[arr[i]] = true;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

}

// reference: https://justicehui.github.io/koi/2019/03/17/BOJ14864/