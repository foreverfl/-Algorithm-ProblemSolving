package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02613_NumberBead {

	static int N, M, upperBound, lowerBound;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			upperBound += arr[i];
			lowerBound = Math.max(lowerBound, arr[i]);
		}

		// binary search
		int mid = 0;
		while (lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;
			int cnt = isPossible(mid);
			if (cnt > M) {
				lowerBound = mid + 1;
			} else {
				upperBound = mid - 1;
			}
		}

		sb.append(lowerBound).append('\n');

		int cnt = 0, sum = 0, i;
		for (i = 1; i <= N; i++) {
			sum += arr[i];
			if (sum > lowerBound) {
				M--;
				cnt = (cnt == 0 ? 1 : cnt);
				sb.append(cnt + " ");
				sum = arr[i];
				cnt = 0;
			}
			cnt++;

			// securing space for each of one bead
			if (M == N - i + 1) {
				break;
			}
		}
		
		for (; i <= N; i++) {
			sb.append(cnt + " ");
			cnt = 1;
		}

		System.out.println(sb.toString());
	}

	private static int isPossible(int mid) {
		int start = 0, cnt = 1;
		for (int i = 1; i <= N; i++) {
			start += arr[i];
			if (start > mid) {
				start = arr[i];
				cnt++;
			}
		}

		return cnt;
	}

}

// reference: https://for-development.tistory.com/109
