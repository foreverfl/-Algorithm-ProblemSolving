package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_21939_ProblemRecommendationSystem_Version_1 {

	static class Problem {
		int p, l;

		Problem(int p, int l) {
			this.p = p;
			this.l = l;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Set<Integer> set = new HashSet<>();
		PriorityQueue<Problem> difficult = new PriorityQueue<>(new Comparator<Problem>() {

			@Override
			public int compare(Problem o1, Problem o2) {
				if (o2.l == o1.l) {
					return o2.p - o1.p;
				}
				return o2.l - o1.l;
			}

		});

		PriorityQueue<Problem> easy = new PriorityQueue<>(new Comparator<Problem>() {

			@Override
			public int compare(Problem o1, Problem o2) {
				if (o2.l == o1.l) {
					return o1.p - o2.p;
				}
				return o1.l - o2.l;
			}

		});

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int problem = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			set.add(problem);
			difficult.offer(new Problem(problem, level));
			easy.offer(new Problem(problem, level));
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			List<Problem> tmp_max = new ArrayList<>();
			List<Problem> tmp_min = new ArrayList<>();

			if (set.contains(difficult.peek().p)) {
				tmp_max.add(difficult.poll());
			} else {
				difficult.poll();
			}

			if (set.contains(easy.peek().p)) {
				tmp_min.add(easy.poll());
			} else {
				easy.poll();
			}

			while (!tmp_max.isEmpty()) {
				difficult.offer(tmp_max.remove(0));
			}

			while (!tmp_min.isEmpty()) {
				easy.offer(tmp_min.remove(0));
			}

			if (query.equals("add")) {

				int problem = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());
				set.add(problem);
				difficult.offer(new Problem(problem, level));
				easy.offer(new Problem(problem, level));

			} else if (query.equals("solved")) {

				int problem = Integer.parseInt(st.nextToken());
				set.remove(problem);

			} else if (query.equals("recommend")) {
				if (st.nextToken().equals("1")) {
					sb.append(difficult.peek().p).append('\n');
				} else {
					sb.append(easy.peek().p).append('\n');
				}
			}

		}

		System.out.print(sb.toString());
	}

}
