package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02805_EKO {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] tree = new int[N];

		int min = 0; // mid + 1 → The answer is the 'mid'.
		int max = 0;

		// input and max value
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (max < tree[i]) {
				max = tree[i];
			}
		}

		while (min < max) {

			int mid = (min + max) / 2;
			long sum = 0;
			for (int treeHeight : tree) {
				if (treeHeight - mid > 0) {
					sum += (treeHeight - mid);
				}
			}

			if (sum < M) {
				max = mid;
			}

			else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);

	}
}

// reference: https://st-lab.tistory.com/270