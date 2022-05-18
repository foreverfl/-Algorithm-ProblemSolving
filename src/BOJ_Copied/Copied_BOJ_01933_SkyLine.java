package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Copied_BOJ_01933_SkyLine {

	static class Building {
		int x, h;

		Building(int x, int h) {
			this.x = x;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Building> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.x == o2.x) {
				return o2.h - o1.h;
			}
			return o1.x - o2.x;
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			pq.offer(new Building(L, H));
			pq.offer(new Building(R, -H));
		}

		StringBuilder sb = new StringBuilder();

		// descending order depending on key
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); // <height, count of height>
		int maxX = 0, maxH = 0;
		map.put(0, 1);
		while (!pq.isEmpty()) {
			Building building = pq.poll();

			if (building.h > 0) { // In case of start
				map.put(building.h, map.getOrDefault(building.h, 0) + 1);
			} else { // In case of end
				int val = map.get(-building.h);
				if (val == 1) {
					map.remove(-building.h);
				} else {
					map.replace(-building.h, val - 1);
				}
			}

			int height = map.firstKey();
			if (maxX != building.x && maxH != height) {
				sb.append(building.x + " " + height + " ");
				maxX = building.x;
				maxH = height;
			}
		}

		System.out.println(sb.toString().trim());
	}

}

// reference: https://gre-eny.tistory.com/293
