package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_08983_Hunter {

	static class Animal {
		int r, c;

		Animal(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int M, N, L, range[];
	static Animal[] animals;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		range = new int[M];
		animals = new Animal[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			range[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			animals[i] = new Animal(a, b);
		}

		int res = 0;
		Arrays.sort(range);

		for (int i = 0; i < N; i++) {
			res += binarySearch(i);
		}

		System.out.print(res);
	}

	public static int binarySearch(int idx) {

		int start = 0, end = M;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid >= M)
				return 0;

			int dist = getDist(animals[idx].r, animals[idx].c, range[mid]);
			
			if (L < dist && animals[idx].r < range[mid])
				end = mid - 1;
			else if (L < dist && animals[idx].r >= range[mid])
				start = mid + 1;
			else if (L >= dist)
				return 1;
		}

		return 0;
	}

	public static int getDist(int a, int b, int x) {
		return Math.abs(x - a) + b;
	}

}

// reference: https://data-make.tistory.com/593