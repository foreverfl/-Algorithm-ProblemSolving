package programmers;

import java.util.Arrays;

public class Programmers_120882_Ranking {

	public static void main(String[] args) {
		int[] arr = solution(new int[][] { { 80, 70 }, { 90, 50 }, { 40, 70 }, { 50, 80 } });
		System.out.println(Arrays.toString(arr));
		arr = solution(
				new int[][] { { 80, 70 }, { 70, 80 }, { 30, 50 }, { 90, 100 }, { 100, 90 }, { 100, 100 }, { 10, 30 } });
		System.out.println(Arrays.toString(arr));
	}

	private static class Student {

		int rank;
		int score;

		public Student(int rank, int score) {
			this.rank = rank;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Student [score=" + score + ", rank=" + rank + "]";
		}

	}

	public static int[] solution(int[][] score) {
		Student[] students = new Student[score.length];
		for (int i = 0; i < score.length; i++) {
			students[i] = new Student(0, score[i][0] + score[i][1]);
		}

		int rank = 1;
		while (true) {
			int max_score = Integer.MIN_VALUE;
			for (int i = 0; i < score.length; i++) {
				max_score = Math.max(max_score, students[i].score);
			}

			int jump = 0;
			for (int i = 0; i < score.length; i++) {
				if (max_score == students[i].score) {
					students[i].rank = rank;
					students[i].score = -1;
					jump++;
				}
			}

			if (jump == 0) {
				rank++;
			} else {
				rank += jump;
			}

			boolean isOver = true;
			for (int i = 0; i < score.length; i++) {
				if (students[i].score != -1) {
					isOver = false;
					break;
				}

			}

			if (isOver)
				break;

		}

		int[] ans = new int[score.length];
		for (int i = 0; i < score.length; i++) {
			ans[i] = students[i].rank;
		}

		return ans;
	}

}
