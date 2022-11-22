package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_23829_GeneralArtsExplorationWeek {

	private static int N, Q;
	private static int[] trees;
	private static long[] prefixSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		trees = new int[N + 1];
		prefixSum = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		for (int i = 1; i <= N; i++) {
			if (i == 1)
				prefixSum[i] = trees[i];
			else
				prefixSum[i] = prefixSum[i - 1] + trees[i];
		}

		for (int i = 0; i < Q; i++) {
			long dist = Integer.parseInt(br.readLine());
			int mid = lowerBound(dist);

			long leftSum;
			long rightSum;

			if (trees[mid] <= dist) { // 현재 나무가 작거나 같은 경우, 현재 나무를 왼쪽 나무로 포함시킨다.
				leftSum = (mid * dist) - prefixSum[mid];
				rightSum = (prefixSum[N] - prefixSum[mid]) - ((long) (N - mid) * dist);
			} else { // 현재 나무가 큰 경우, 현재 나무를 오른쪽 나무로 포함시킨다.
				leftSum = ((mid - 1) * dist) - prefixSum[mid - 1];
				rightSum = (prefixSum[N] - prefixSum[mid - 1]) - ((long) (N - mid + 1) * dist);
			}

			sb.append((leftSum + rightSum)).append("\n");
		}
		System.out.print(sb);
	}

	private static int lowerBound(long pos) {
		int left = 1;
		int right = N;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (trees[mid] > pos)
				right = mid - 1;
			else if (trees[mid] < pos)
				left = mid + 1;
			else
				break;
		}
		return mid;
	}

}

// reference: https://ws-pace.tistory.com/211