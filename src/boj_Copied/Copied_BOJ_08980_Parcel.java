package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_08980_Parcel {

	static class Parcel implements Comparable<Parcel> {
		int start;
		int target;
		int cnt;

		Parcel(int start, int target, int cnt) {
			this.start = start;
			this.target = target;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Parcel o) {
			if (target == o.target) {
				return start - o.start;
			}
			return target - o.target;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		Parcel[] parcels = new Parcel[M + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			parcels[i] = new Parcel(start, target, cnt);
		}

		Arrays.sort(parcels, 1, M + 1);

		int[] weight = new int[N + 1];
		for (int i = 1; i < N; i++) { // The last town cannot be reached.
			weight[i] = C; // the maximum number of boxes to send
		}

		int ans = 0;
		for (int i = 1; i <= M; i++) {
			Parcel parcel = parcels[i];

			int maxBoxNum = Integer.MAX_VALUE;

			for (int j = parcel.start; j < parcel.target; j++) {
				// the maximum limit of boxes to send in the path(start - target)
				maxBoxNum = Math.min(maxBoxNum, weight[j]);
			}

			if (maxBoxNum >= parcel.cnt) {
				for (int j = parcel.start; j < parcel.target; j++) {
					weight[j] -= parcel.cnt;
				}
				ans += parcel.cnt;
			} else {
				// preventing a negative number to occur
				for (int j = parcel.start; j < parcel.target; j++) {
					weight[j] -= maxBoxNum;
				}
				ans += maxBoxNum;
			}
		}

		System.out.println(ans);

	}

}

// reference: https://steady-coding.tistory.com/58
