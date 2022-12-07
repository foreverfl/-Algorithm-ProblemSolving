package programmers;

import java.util.Arrays;

public class Solving_Programmers_118668_StudyingCodingTest {

	public static void main(String[] args) {
//		System.out.println(solution(10, 10, new int[][] { { 0, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } }));
		System.out.println(solution(0, 0,
				new int[][] { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } }));
	}

	private static class Problem implements Comparable<Problem> {
		int al;
		int co;
		int al_rwd;
		int co_rwd;
		int time;
		double p;

		public Problem() {

		}

		public Problem(int al, int co, int time) {
			this.al = al;
			this.co = co;
			this.time = time;
		}

		@Override
		public int compareTo(Problem o) {
			return Double.compare(o.p, this.p);
		}

		@Override
		public String toString() {
			return "Problem [al=" + al + ", co=" + co + ", al_rwd=" + al_rwd + ", co_rwd=" + co_rwd + ", time=" + time
					+ ", p=" + p + "]";
		}

	}

	public static int solution(int alp, int cop, int[][] problems) {
		int size = problems.length;
		Problem[] problem_arr = new Problem[size];
		int[] dists = new int[size];
		boolean[] solved = new boolean[size];

		for (int i = 0; i < problem_arr.length; i++) {
			Problem problem = new Problem();
			problem.al = problems[i][0];
			problem.co = problems[i][1];
			problem.al_rwd = problems[i][2];
			problem.co_rwd = problems[i][3];
			problem.time = problems[i][4];
			problem.p = ((double) problems[i][2] + problems[i][3]) / 2;
			problem_arr[i] = problem;
		}

		Arrays.sort(problem_arr);

		for (Problem problem : problem_arr) {
			System.out.println((problem));
		}
		System.out.println("============");

		Problem now = new Problem(alp, cop, 0);

		while (true) {
			// 문제 해결 처리
			for (int i = 0; i < size; i++) {
				if (now.al >= problem_arr[i].al && now.co >= problem_arr[i].co) {
					solved[i] = true;
				}
			}

			System.out.println(now);
			System.out.println(Arrays.toString(solved));
			System.out.println("===========");

			// 현재 고를 수 있는 가성비가 제일 좋은 문제 찾기
			// 현재 풀 수 있는 가장 쉬운 문제 찾기
			int idx = -1;
			int easiest = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				if (!solved[i])
					continue;

				if (idx == -1 && now.al >= problem_arr[i].al && now.co >= problem_arr[i].co) {
					idx = i;
				}

				dists[i] = (problem_arr[i].al - now.al) + (problem_arr[i].co - now.co);
				easiest = Math.min(easiest, dists[i]);
			}

			int easiest_idx = 0;
			for (int i = 0; i < size; i++) {
				if (dists[i] == easiest) {
					easiest_idx = i;
					break;
				}
			}

			// 현재 풀 수 있는 가성비가 좋은 문제가 없다면
			if (idx == -1) {
				int al_diff = problem_arr[easiest_idx].al - now.al;
				int co_diff = problem_arr[easiest_idx].co - now.co;
				
				if (now.al < problem_arr[easiest_idx].al) {
					now.al += al_diff;
					now.time += al_diff;
				} 
				
				if (now.co < problem_arr[easiest_idx].co) {
					now.co += co_diff;
					now.time += co_diff;
				}
			}

			// 현재 풀 수 있는 가성비가 좋은 문제가 있다면
			else {
				now.al += problem_arr[idx].al_rwd;
				now.co += problem_arr[idx].co_rwd;
				now.time += problem_arr[idx].time;
			}

			if (isOver(solved))
				break;
		}

		return now.time;
	}

	private static boolean isOver(boolean[] solved) {
		for (int i = 0; i < solved.length; i++) {
			if (!solved[i])
				return false;
		}

		return true;

	}

}
