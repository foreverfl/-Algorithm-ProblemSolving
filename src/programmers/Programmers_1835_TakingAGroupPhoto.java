package programmers;

public class Programmers_1835_TakingAGroupPhoto {

	public static void main(String[] args) {
		System.out.println(solution(2, new String[] { "M~C<2", "C~M>1" }));
		System.out.println(solution(2, new String[] { "N~F=0", "R~T>2" }));
	}

	private static char[] members = new char[] { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	private static boolean[] visited = new boolean[8];
	private static int[] idx = new int[8];
	private static int ans;

	public static int solution(int n, String[] data) {

		ans = 0;
		backTracking(0, data);
		int answer = ans;

		return answer;
	}

	private static void backTracking(int depth, String[] condition) {
		if (depth == 8) {
			String res = "";
			for (int i = 0; i < 8; i++) {
				res += members[idx[i]];
			}

			if (isPossible(condition, res))
				ans++;

			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				idx[depth] = i;
				backTracking(depth + 1, condition);
				visited[i] = false;
			}
		}
	}

	private static boolean isPossible(String[] condition, String str) {
		for (int i = 0; i < condition.length; i++) {
			char start = condition[i].charAt(0);
			char end = condition[i].charAt(2);
			char sign = condition[i].charAt(3);
			int num = condition[i].charAt(4) - '0';

			int distance = Math.abs(str.indexOf(start) - str.indexOf(end)) - 1;

			if (sign == '=') {
				if (!(distance == num)) {
					return false;
				}
			} else if (sign == '>') {
				if (!(distance > num)) {
					return false;
				}
			} else if (sign == '<') {
				if (!(distance < num)) {
					return false;
				}
			}

		}

		return true;

	}

}
