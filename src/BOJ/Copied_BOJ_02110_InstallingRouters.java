package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02110_InstallingRouters {

	public static int[] house;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		int lo = 1; // minimum value of minimum distance
		int hi = house[N - 1] - house[0] + 1; // maximum value of minimum distance

		while (lo < hi) { // upper bound

			int mid = (hi + lo) / 2;

			if (canInstall(mid) < M) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(lo - 1);
	}

	public static int canInstall(int distance) {

		int count = 1; // The first house is installed unconditionally
		int lastLocate = house[0];

		for (int i = 1; i < house.length; i++) {
			int locate = house[i];

			if (locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;

	}

}

// reference: https://st-lab.tistory.com/277