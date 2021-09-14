package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17266_DarkUnderpass {
	static int atoi(String str) {
		return Integer.parseInt(str);
	} 

	static int N; // 굴다리 길이
	static int M; // 가로등의 개수
	static int A[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = atoi(br.readLine());
		M = atoi(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = new int[M];

		for (int i = 0; i < M; i++) {
			A[i] = atoi(st.nextToken());
		}

		paraSearch();
	}

	// 높이가 target으로 들어옴
	static boolean possible(int target) {
		int last = 0; // 밝혀진 마지막 위치

		for (int i = 0; i < M; i++) {
			if (A[i] - last <= target) {
				last = A[i] + target;
			} else
				return false;
		}
		return last >= N;
	}

	static void paraSearch() {
		int s = 0, e = 100000, rel = 0;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (possible(mid)) {
				rel = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}

		System.out.println(rel);
	}
}
