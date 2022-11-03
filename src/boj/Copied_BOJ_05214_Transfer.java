package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_05214_Transfer {

	static ArrayList<Integer>[] tubeStation;
	static int[] dijkstra;
	static int n, k, m;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tubeStation = new ArrayList[n + m + 1]; // '1 ~ n station' + 'n + 1 ~ m' tube
		dijkstra = new int[n + m + 1];
		for (int i = 1; i < tubeStation.length; i++) {
			tubeStation[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				int station = Integer.parseInt(st.nextToken());
				tubeStation[station].add(n + i); // station -> tube
				tubeStation[n + i].add(station); // tube -> station
			}
		}

		int res = -1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		dijkstra[1] = 1; // start
		while (!queue.isEmpty()) {
			int station = queue.poll();
			if (station == n) {
				res = dijkstra[n];
				break;
			}

			for (int nextStation : tubeStation[station]) {

				// If not visited or visited the least time
				if (dijkstra[nextStation] == 0) {
					if (station > n) {
						dijkstra[nextStation] = dijkstra[station];
					} else {
						dijkstra[nextStation] = dijkstra[station] + 1;
					}
					queue.offer(nextStation);
				}
			}
		}

		System.out.print(res);
	}

}

// reference: https://maivve.tistory.com/252