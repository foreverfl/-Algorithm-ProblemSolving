package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02381_MaximumDistance {

	static class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Coordinate[] arr = new Coordinate[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Coordinate(x, y);
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i].x + arr[i].y);
			min = Math.min(min, arr[i].x + arr[i].y);
		}
		int result1 = max - min;

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i].x - arr[i].y);
			min = Math.min(min, arr[i].x - arr[i].y);
		}
		int result2 = max - min;

		System.out.println(Math.max(result1, result2));

	}
}

// reference: https://velog.io/@pss407/%EB%B0%B1%EC%A4%802381-%EC%B5%9C%EB%8C%80-%EA%B1%B0%EB%A6%AC