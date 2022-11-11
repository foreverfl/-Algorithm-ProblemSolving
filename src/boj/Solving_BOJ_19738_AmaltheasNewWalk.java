package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solving_BOJ_19738_AmaltheasNewWalk {

	private static List<Point> list = new ArrayList<>();
	private static List<Point> toRight = new ArrayList<>();
	private static List<Point> toLeft = new ArrayList<>();
	private static List<Point> vertical = new ArrayList<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Point(2 * x, 2 * y));
			list.add(new Point(2 * x, 2 * y + 1));
			list.add(new Point(2 * x + 1, 2 * y));
			list.add(new Point(2 * x + 1, 2 * y + 1));
		}

		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}

		});

//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		// 초기값
		sb.append(list.get(0).y + " " + list.get(0).x + "\n");

		for (int i = 1; i < list.size(); i++) {
			if (list.get(0).x == list.get(i).x) {
				vertical.add(list.get(i));
				continue;
			}

			if (list.get(0).y % 2 == (list.get(i).y % 2)) {
				printToLeft(toLeft);
				toLeft.clear();
				toRight.add(list.get(i));
			} else {
				printToRight(toRight);
				toRight.clear();
				toLeft.add(list.get(i));
			}

		}

		if (!toLeft.isEmpty()) {
			printToLeft(toLeft);
		} else if (!toRight.isEmpty()) {
			printToRight(toRight);
		}

		Collections.sort(vertical, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o2.y - o1.y;
			}

		});

		for (int i = 0; i < vertical.size(); i++) {
			sb.append(vertical.get(i).y + " " + vertical.get(i).x + "\n");
		}

		System.out.println(sb.toString().trim());

	}

	private static void printToRight(List<Point> list) {
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).y + " " + list.get(i).x + "\n");
		}
	}

	private static void printToLeft(List<Point> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i).y + " " + list.get(i).x + "\n");
		}
	}

}
