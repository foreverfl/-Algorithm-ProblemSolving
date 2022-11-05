package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_16947_SeoulMetro {

	private static boolean visited[], isCycle;
	private static int N, distance[];
	private static Queue<Integer> queue = new LinkedList<Integer>();
	private static ArrayList<Integer>[] adjacent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		distance = new int[N + 1];
		Arrays.fill(distance, -1);

		// 역과 역을 연결하는 구간의 정보 입력
		adjacent = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjacent[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjacent[a].add(b);
			adjacent[b].add(a);
		}

		findCycle(0, 1);

		findDistance();

		for (int i = 1; i <= N; i++) {
			sb.append(distance[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void findCycle(int before, int now) {
		
		visited[now] = true;
		
		for (int next : adjacent[now]) {
			// 직전 방문지가 아니면서 이미 방문한 곳에 도착 → 사이클을 이뤘다.
			if (visited[next] && next != before) {
				isCycle = true;
				distance[next] = 0;
				queue.add(next);
				break;
			} else if (!visited[next]) {

				findCycle(now, next);

				if (isCycle) {
					// 이미 사이클에 속한 곳을 만남 → 사이클을 다 돌았다.
					if (distance[next] == 0) {
						isCycle = false;
					} else {
						distance[next] = 0;
						queue.add(next);
					}
					return;
				}
			}
		}
	}

	private static void findDistance() {
		int cnt = 1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int nxt = queue.poll();
				// 연결된 구간을 다음 탐색지에 추가
				for (int j : adjacent[nxt]) {
					// 거리가 이미 구해진 역은 제외
					if (distance[j] != -1)
						continue;
					distance[j] = cnt;
					queue.add(j);
				}
			}
			cnt++; // 순환선과의 거리
		}
	}
}

// reference: https://velog.io/@wonjwi/%EB%B0%B1%EC%A4%80-16947%EB%B2%88-%EC%84%9C%EC%9A%B8%EC%A7%80%ED%95%98%EC%B2%A02%ED%98%B8%EC%84%A0
