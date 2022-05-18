package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15970_DrawingArrow {

	static class Arrow implements Comparable<Arrow> {
		int pos;
		int color;
		int len;

		Arrow(int pos, int color) {
			this.pos = pos;
			this.color = color;
		}

		@Override
		public int compareTo(Arrow o) {
			if (this.color == o.color)
				return this.pos - o.pos;
			return this.color - o.color;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Arrow[] arr = new Arrow[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			arr[i] = new Arrow(pos, color);
		}

		Arrays.sort(arr);

		arr[0].len = arr[1].pos - arr[0].pos; // first
		arr[N - 1].len = arr[N - 1].pos - arr[N - 2].pos; // last

		for (int i = 1; i < N - 1; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;

			if (arr[i].color == arr[i + 1].color) {
				a = Math.abs(arr[i].pos - arr[i + 1].pos);
			}

			if (arr[i].color == arr[i - 1].color) {
				b = Math.abs(arr[i].pos - arr[i - 1].pos);
			}

			int min = Math.min(a, b);
			arr[i].len = min;
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i].len;
		}

		System.out.println(sum);

	}

}
