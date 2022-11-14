package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solving_BOJ_02349_PhoneHome {

	private static class Point {
		int idx;
		double x;
		double y;

		public Point(int idx, double x, double y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [idx=" + idx + "]";
		}

	}

	private static int N;
	private static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list.add(new Point(i, x, y));
		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int cnt = 0;
//			List<Point> tmp = new ArrayList<>();
			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;

				double dist = calcDist(list.get(i), list.get(j));

				if (dist < 20)
					cnt++;
			}
			res = Math.max(res, cnt);

//			System.out.println(list.get(i).idx);
//			for (int j = 0; j < tmp.size(); j++) {
//				System.out.println(tmp.get(j));
//			}
//			System.out.println("==============");
		}

		System.out.println(res);

	}

	private static double calcDist(Point a, Point b) {

		return Math.sqrt((Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
	}

}
