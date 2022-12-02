package programmers;

public class Programmers_120812_FindingMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] array) {
		int[] visited = new int[1000];
		for (int i = 0; i < array.length; i++) {
			visited[array[i]]++;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < visited.length; i++) {
			max = Math.max(max, visited[i]);
		}

		int ans = 0;
		int duplicated = 0;
		for (int i = 0; i < visited.length; i++) {
			if (max == visited[i]) {
				ans = i;
				duplicated++;
			}
		}

		if (duplicated == 1)
			return ans;
		else
			return -1;

	}

}
