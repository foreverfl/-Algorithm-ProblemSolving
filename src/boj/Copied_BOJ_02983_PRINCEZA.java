package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Copied_BOJ_02983_PRINCEZA {

	static class Point implements Comparable<Point> {
		public long x;
		public long y;

		public Point(long firstX, long firstY) {
			this.x = firstX;
			this.y = firstY;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x > o.x)
				return 1;
			else if (this.x == o.x)
				return 0;
			else
				return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		String str = br.readLine();

		char[] directions = str.toCharArray();
		st = new StringTokenizer(br.readLine());
		long firstX = Long.parseLong(st.nextToken());
		long firstY = Long.parseLong(st.nextToken());
		long filter = (firstX + firstY) % 2;

		HashMap<Long, TreeSet<Point>> sumMap = new HashMap<Long, TreeSet<Point>>();
		HashMap<Long, TreeSet<Point>> subtractionMap = new HashMap<Long, TreeSet<Point>>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			if ((x + y) % 2 == filter) {
				Point newPoint = new Point(x, y);
				TreeSet<Point> sumList = sumMap.get(x + y);

				if (sumList == null) {
					sumList = new TreeSet<Point>();
				}
				sumList.add(newPoint);
				sumMap.put(x + y, sumList);

				TreeSet<Point> diffList = subtractionMap.get(x - y);
				if (diffList == null) {
					diffList = new TreeSet<Point>();
				}
				diffList.add(newPoint);
				subtractionMap.put(x - y, diffList);
			}
		}

		long loopX = firstX;
		long loopY = firstY;
		for (char ch : directions) {
			long key = (ch == 'A' || ch == 'D') ? loopX - loopY : loopX + loopY;
			TreeSet<Point> set = (ch == 'A' || ch == 'D') ? subtractionMap.get(key) : sumMap.get(key);
			if (set == null || set.size() == 0) {
				continue;
			} else {
				boolean isXAdd = (ch == 'A' || ch == 'B') ? true : false;
				Point exPoint = new Point(loopX, loopY);
				Point hitPoint = (isXAdd) ? set.higher(exPoint) : set.lower(exPoint);
				if (hitPoint == null) {
					continue;
				}
				loopX = hitPoint.x;
				loopY = hitPoint.y;
				set.remove(hitPoint);

				if (set.size() == 0) {
					set = null;
				}

				if (ch == 'A' || ch == 'D') {
					subtractionMap.put(key, set);

					TreeSet<Point> tmp = sumMap.get(hitPoint.x + hitPoint.y);
					tmp.remove(hitPoint);
					if (tmp == null || tmp.size() == 0) {
						tmp = null;
					}
					sumMap.put(hitPoint.x + hitPoint.y, tmp);
				} else {
					sumMap.put(key, set);

					TreeSet<Point> tmp = subtractionMap.get(hitPoint.x - hitPoint.y);
					tmp.remove(hitPoint);
					if (tmp == null || tmp.size() == 0) {
						tmp = null;
					}

					subtractionMap.put(hitPoint.x - hitPoint.y, tmp);
				}
			}
		}

		System.out.println(loopX + " " + loopY);
	}

}

// reference: https://www.stackhoarder.com/2019/09/01/%EB%B0%B1%EC%A4%80-2983%EB%B2%88-%EA%B0%9C%EA%B5%AC%EB%A6%AC-%EA%B3%B5%EC%A3%BC-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/
