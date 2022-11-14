package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01966_PrinterQueue {

	/*
	 * 1. 자료 객체 만들기
	 * 2. 리스트에 해당 자료 넣기
	 * 3. list.get(0)보다 우선순위가 큰 것이 있다면 지우고 맨 뒤로 보내기
	 * 4. 우선순위가 큰 것이 없다면 제거 및 몇 번째인지 카운트하기
	 */
	private static class Doc {
		int idx;
		int priority;

		public Doc(int idx, int priority) {
			super();
			this.idx = idx;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Doc [idx=" + idx + ", priority=" + priority + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			List<Doc> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				Doc doc = new Doc(i, priority);
				list.add(doc);
			}

			int seq = 0;
			while (!list.isEmpty()) {
				if (!isPossible(list)) {
					// 뒤로 미루기
					Doc now = list.remove(0);
					list.add(now);
				} else {
					// 프린트하기
					seq++;
					Doc now = list.remove(0);
					if (now.idx == M + 1) {
						break;
					}
				}
			}

			sb.append(seq).append('\n');

		}

		System.out.println(sb.toString());

	}

	private static boolean isPossible(List<Doc> list) {
		if (list.size() == 1)
			return true;

		Doc first = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			if (first.priority < list.get(i).priority) {
				return false;
			}
		}

		return true;
	}

}
