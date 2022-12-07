package programmers;

public class Programmers_92335_FindTheNumberOfPrimeNumbers {

	public static void main(String[] args) {
		System.out.println(solution(437674, 3));
		System.out.println(solution(110011, 10));

	}

	public static int solution(int n, int k) {
		checkPrime(1000000);

		int answer = 0;

		String str = Integer.toString(n, k);
		String[] arr = str.split("0+");
		for (int i = 0; i < arr.length; i++) {
			if (checkPrime(Long.parseLong(arr[i]))) {
				answer++;
			}
		}

		return answer;
	}

	private static boolean checkPrime(long num) {
		if (num <= 1)
			return false;

		for (long i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;

		return true;
	}

}
