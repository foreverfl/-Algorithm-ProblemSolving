package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02170_DrawingLine {

	static class Line implements Comparable<Line> {
		int x;
		int y;

		Line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Line o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Line[] arr = new Line[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Line(x, y);
		}

		Arrays.sort(arr);

		// start
		Line start = arr[0];
		int min = start.x;
		int max = start.y;
		int len = max - min;

		// the remains
		for (int i = 1; i < N; i++) {
			if (min <= arr[i].x && arr[i].y <= max) { // If a current line is contained in the before one.
				continue;
			} else if (arr[i].x < max) { // If a current x is contained in the before line.
				len += arr[i].y - max;
			} else { // not contained
				len += arr[i].y - arr[i].x;
			}
			min = arr[i].x;
			max = arr[i].y;
		}
		System.out.println(len);
	}

}

// reference: https://moonsbeen.tistory.com/63
