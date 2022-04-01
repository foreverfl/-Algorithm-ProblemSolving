package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_15961_ConveyorBeltSushi {

	static int N, d, k, c;
	static int[] arr, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visited = new int[d + 1];

		System.out.println(slide());

	}

	private static int slide() {
		int total = 0, coupon; // The 'coupon' means the maximum number with the coupon.

		// start
		for (int i = 0; i < k; i++) {
			if (visited[arr[i]] == 0) {
				total++;
			}
			visited[arr[i]]++;
		}

		coupon = total;
		for (int i = 1; i < N; i++) {

			// using coupon
			if (coupon <= total) {
				if (visited[c] == 0) {
					coupon = total + 1;
				} else {
					coupon = total;
				}
			}

			// moving
			visited[arr[i - 1]]--;
			if (visited[arr[i - 1]] == 0) {
				total--;
			}

			// The '%n' is needed to implement rotation.
			if (visited[arr[(i + k - 1) % N]] == 0) {
				total++;
			}
			visited[arr[(i + k - 1) % N]]++;
		}
		return coupon;
	}

}

// reference: https://velog.io/@hahahaa8642/%EB%B0%B1%EC%A4%80-15961%EB%B2%88-%ED%9A%8C%EC%A0%84-%EC%B4%88%EB%B0%A5-JAVA-%ED%92%80%EC%9D%B4
