package programmers;

public class Programmers_12985_Competition {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

	public static int solution(int n, int a, int b) {
		int answer = 1;

		int range = 2;
		int start = 1;
		int end = range;
		loop: while (true) {

			boolean a_check = false;
			boolean b_check = false;
			
			for (int i = start; i <= end; i++) {
				if (a == i) {
					a_check = true;
				}

				if (b == i) {
					b_check = true;
				}

				if (a_check && b_check)
					break loop;

				if (i == n) {
					range *= 2;
					answer++;
					start = 1;
					end = range;
					continue loop;
				}
			}

			start += range;
			end += range;

		}

		return answer;
	}

}
