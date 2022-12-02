package programmers;

public class Programmers_12977_MakingPrimeNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
		System.out.println(solution(new int[] { 1, 2, 7, 6, 4 }));
	}

	private static int[] arr;
	private static boolean[] visited;
	private static boolean[] isNotPrime = new boolean[3001];
	private static int ans;

	public static int solution(int[] nums) {
		arr = new int[nums.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = nums[i];
		}
		visited = new boolean[nums.length];

		checkPrime(3000);
		backTracking(0, nums.length, 3);

		int answer = ans;

		return answer;
	}

	private static void backTracking(int depth, int n, int r) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i])
					sum += arr[i];
			}

			if (!isNotPrime[sum]) {
				ans++;
			}

			return;
		}

		if (depth == n) {
			return;
		}

		visited[depth] = true;
		backTracking(depth + 1, n, r - 1);

		visited[depth] = false;
		backTracking(depth + 1, n, r);
	}

	private static void checkPrime(int num) {
		isNotPrime = new boolean[num + 1];

		if (num < 2) {
			return;
		}

		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(num); i++) {

			// 이미 체크된 배열이면 다음 반복문으로 skip
			if (isNotPrime[i] == true) {
				continue;
			}

			// i 의 배수들을 걸러주기 위한 반복문
			for (int j = i * i; j < isNotPrime.length; j = j + i) {
				isNotPrime[j] = true;
			}
		}
	}

}
