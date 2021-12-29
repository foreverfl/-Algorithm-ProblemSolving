package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11651_ArrangingCoordinates_2 {

	static class Coordinate implements Comparable<Coordinate> {

		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x; // index
			this.y = y;
		}

		@Override
		public int compareTo(Coordinate o) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		ArrayList<Coordinate> coordinate = new ArrayList<>();

		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			int x_value = Integer.parseInt(st.nextToken());
			int y_value = Integer.parseInt(st.nextToken());

			coordinate.add(new Coordinate(x_value, y_value));
		}

		Collections.sort(coordinate);

		for (int i = 0; i < T; i++) {
			bw.write(coordinate.get(i).x + " " + coordinate.get(i).y + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}
}
