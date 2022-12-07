package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_06165_GameOfLines {

	private static Set<Double> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Point[] arr = new Point[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point point = new Point(x, y);
			arr[i] = point;
		}

		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return o1.y - o2.y;

				return o1.x - o2.x;
			}

		});

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				getSlope(arr[i], arr[j]);
			}
		}

		System.out.println(set.size());
	}

	private static void getSlope(Point a, Point b) {
		double slope = (double) (b.y - a.y) / (double) (b.x - a.x);

		set.add(slope);
	}

}
