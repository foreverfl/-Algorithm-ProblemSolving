package programmers;

public class Programmers_140107_MarkingDots {

	public static void main(String[] args) {
		System.out.println(solution(2, 4));
		System.out.println(solution(1, 5));
	}

	public static long solution(int k, int d) {

		long answer = 0;
		for (int x = 0; x <= d; x += k) {
			int y = getY(x, d);
			long tmp = (y / k) + 1;
			answer += tmp;
		}

		return answer;
	}

	private static int getY(int x, int d) {
		int y = (int) Math.sqrt((long) d * d -  (long) x * x);

		return y;
	}

}
