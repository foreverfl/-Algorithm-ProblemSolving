package programmers;

public class Programmers_68935_ReversingTernaryScale {

	public static void main(String[] args) {
		System.out.println(solution(45));
		System.out.println(solution(125));
	}

	public static int solution(int n) {
		String ternary = Integer.toString(n, 3);
		StringBuilder reverse = new StringBuilder(ternary);
		reverse.reverse();
		String reverseStr = reverse.toString();
		int ans = 0;
		for (int i = 0; i < reverseStr.length(); i++) {
			int now = (int) Math.pow(3, i) * (reverseStr.charAt(reverseStr.length() - 1 - i) - '0');
			ans += now;
		}

		return ans;
	}

}
