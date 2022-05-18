package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15975_DrawingArrow {

	static class Arrow implements Comparable<Arrow> {
		int pos;
		int color;
		long len;

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Arrow> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			list.add(new Arrow(pos, color));
		}

		Collections.sort(list);

		// the first value
		if (list.get(0).color == list.get(1).color)
			list.get(0).len = Math.abs(list.get(0).pos - list.get(1).pos);
		else
			list.get(0).len = 0;

		// middle values
		for (int i = 1; i < N - 1; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;

			if (list.get(i).color == list.get(i + 1).color) {
				a = Math.abs(list.get(i).pos - list.get(i + 1).pos);
			} else
				a = 0;

			if (list.get(i).color == list.get(i - 1).color) {
				b = Math.abs(list.get(i).pos - list.get(i - 1).pos);
			} else
				b = 0;

			int min = 0;
			if (a != 0 && b == 0) {
				min = a;
			} else if (a == 0 && b != 0) {
				min = b;
			} else {
				min = Math.min(a, b);
			}
			list.get(i).len = min;
		}

		// the last value
		if (list.get(N - 1).color == list.get(N - 2).color)
			list.get(N - 1).len = Math.abs(list.get(N - 1).pos - list.get(N - 2).pos);
		else
			list.get(N - 1).len = 0;

		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += list.get(i).len;
		}

		bw.write(sum + " ");
		bw.flush();
		bw.close();

	}

}
