package Programmers;

public class Programmers_43165_TargetNumber {

	public static void main(String[] args) {
		int[] numbers_1 = { 1, 1, 1, 1, 1 };
		int target_1 = 3;
		int res_1 = solution(numbers_1, target_1);

		System.out.println(res_1);

		cnt = 0;
		
		int[] numbers_2 = { 4, 1, 2, 1 };
		int target_2 = 4;
		int res_2 = solution(numbers_2, target_2);

		System.out.println(res_2);

	}

	static int cnt;
	static boolean[] visited;

	public static int solution(int[] numbers, int target) {
		visited = new boolean[numbers.length];

		dfs(numbers, 1, target, numbers[0]);
		dfs(numbers, 1, target, -numbers[0]);

		return cnt;
	}

	public static void dfs(int[] numbers, int depth, int target, int sum) {
		if (depth == numbers.length && sum == target)
			cnt++;

		if (depth == numbers.length)
			return;

		dfs(numbers, depth + 1, target, sum + numbers[depth]);
		dfs(numbers, depth + 1, target, sum - numbers[depth]);

	}

}
