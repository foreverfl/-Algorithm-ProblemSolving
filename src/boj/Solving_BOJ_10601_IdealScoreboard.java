package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solving_BOJ_10601_IdealScoreboard {
	/*
	 * 1. problem 객체 만들기(problem, team, time) 
	 * 2. team 객체 만들기(team, problem, time) 
	 * 3. 조건 충족시에 isIdeal 변경
	 * (1) 각 팀이 최소 한 문제 해결 
	 * (2) 한 팀이 모든 문제 해결 X
	 * (3) 각 문제가 최소 한 팀에 의해 해결
	 * (4) 한 문제가 모든 팀에 의해 해결 X
	 * 4. isIdeal 변경시 시간 출력
	 */

	private static class Problem {
		int id;
		List<Team> teams;

		public Problem() {

		}

		@Override
		public String toString() {
			return "Problem [id=" + id + ", teams=" + teams + "]";
		}

	}

	private static class Team {
		int id;
		String time;

		public Team() {

		}

		@Override
		public String toString() {
			return "Team [id=" + id + ", time=" + time + "]";
		}

	}

	private static String startTime;
	private static String endTime;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			String testCase = br.readLine();
			startTime = "--:--:--";
			endTime = "--:--:--";

			if (testCase.equals("0 0 0")) {
				break;
			}

			st = new StringTokenizer(testCase);
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			List<Problem> problems = new ArrayList<>();
			problems.add(null);
			for (int i = 1; i <= P; i++) {
				Problem problem = new Problem();
				problem.id = i;
				problem.teams = new ArrayList<>();
				problem.teams.add(null);
				for (int j = 1; j <= T; j++) {
					Team team = new Team();
					team.id = j;
					problem.teams.add(team);
				}
				problems.add(problem);
			}

			for (int i = 0; i < S; i++) {
				st = new StringTokenizer(br.readLine());
				int teamNo = Integer.parseInt(st.nextToken());
				int problemNo = st.nextToken().charAt(0) - 64;
				String time = st.nextToken();
				String yesOrNo = st.nextToken();

				boolean isSolved;
				if (yesOrNo.equals("Yes")) {
					isSolved = true;
				} else {
					isSolved = false;
				}

				if (isSolved) {
					problems.get(problemNo).teams.get(teamNo).time = time;
				}

//				System.out.println((i + 1) + ":====================================");
//				for (int j = 1; j <= P; j++) {
//					System.out.println(problems.get(j));
//				}

				if (!endTime.equals("--:--:--")) {
					break;
				}
				
				checkSituation(problems, T, P, time);

			}

			sb.append(startTime + " " + endTime + "\n");

		}		

		System.out.println(sb.toString().trim());

	}

	private static void checkSituation(List<Problem> problems, int T, int P, String time) {
		boolean A = true, B = true, C = true, D = true;

		int[] problemArray = new int[P + 1];
		int[] teamArray = new int[T + 1];

		for (int i = 1; i <= P; i++) {
			for (int j = 1; j <= T; j++) {
				if (problems.get(i).teams.get(j).time != null) {
					problemArray[i]++;
					teamArray[j]++;
				}
			}
		}

		// 각 팀이 최소 한 문제 해결
		for (int i = 1; i < teamArray.length; i++) {
			if (teamArray[i] == 0) {
				A = false;
				break;
			}
		}

		// 한 팀이 모든 문제 해결 X
		for (int i = 1; i < teamArray.length; i++) {
			if (teamArray[i] == P) {
				B = false;
				break;
			}
		}

		// 각 문제가 최소 한 팀에 의해 해결
		for (int i = 1; i < problemArray.length; i++) {
			if (problemArray[i] == 0) {
				C = false;
				break;
			}
		}

		// 한 문제가 모든 팀에 의해 해결 X
		for (int i = 1; i < problemArray.length; i++) {
			if (problemArray[i] == T) {
				D = false;
				break;
			}
		}

		if (A && B && C && D) {
			if (startTime.equals("--:--:--")) {
				startTime = time;
			}
		}

		if (!A || !B || !C || !D) {
			if (!startTime.equals("--:--:--") && endTime.equals("--:--:--")) {
				endTime = time;
			}
		}

	}
}
