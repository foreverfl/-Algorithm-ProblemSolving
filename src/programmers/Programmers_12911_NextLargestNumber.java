package programmers;

public class Programmers_12911_NextLargestNumber {

	public static void main(String[] args) {
		System.out.println(solution(15));

	}

	public static int solution(int n) {
		String nAsBinary = Integer.toBinaryString(n);
		int cntOfOne = countOne(nAsBinary);

		int answer = 0;
		for (int i = n + 1; i <= 1000000; i++) {
			String tmp = Integer.toBinaryString(i);
			int tmpCntOfOne = countOne(tmp);
			if (cntOfOne == tmpCntOfOne) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	public static int countOne(String str) {
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				cnt++;
		}

		return cnt;
	}

}
