package Programmers_Copied;

public class Copied_Programmers_43162_Network {
	public static void main(String[] args) {
		int n_1 = 3;
		int[][] computers_1 = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int n_2 = 3;
		int[][] computers_2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

		System.out.println(solution(n_1, computers_1));
		System.out.println(solution(n_2, computers_2));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] check = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				dfs(computers, i, check);
					answer++;
			}
		}

		return answer;
	}

	public static boolean[] dfs(int[][] computers, int i, boolean[] check) {
		check[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (i != j && computers[i][j] == 1 && check[j] == false) {
				check = dfs(computers, j, check);
			}
		}
		return check;
	}

}

// reference: https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
