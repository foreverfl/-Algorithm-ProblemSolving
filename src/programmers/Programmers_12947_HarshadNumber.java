package programmers;

public class Programmers_12947_HarshadNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean solution(int x) {
		int sum = findSum(x);
		if (x % sum == 0)
			return true;
		else
			return false;
	}

	private static int findSum(int x) {
		int res = 0;

		String str = Integer.toString(x);

		for (int i = 0; i < str.length(); i++) {
			res += (str.charAt(i) - '0');
		}

		return res;
	}

}
