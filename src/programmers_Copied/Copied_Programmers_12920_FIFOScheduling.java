package programmers_Copied;

public class Copied_Programmers_12920_FIFOScheduling {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 1, 2, 3 }));

	}

	public static int solution(int n, int[] cores) {
		int answer = 0;

		int min = 0; // 시간의 최소값
		int max = 10000 * n; // 시간의 최대값

		int time = 0;
		int m = 0;

		while (true) {
			int mid = (min + max) / 2;

			int count = calculate(mid, cores);

			if (min > max)
				break;

			if (count >= n) { // 해당시간까지 처리한 작업량보다 n이 크면 time과 m갱신
				max = mid - 1;
				time = mid;
				m = count;
			} else {
				min = mid + 1;
			}
		}

		m -= n; // 처리한 작업량과 n의 차이 갱신
		for (int i = cores.length - 1; i >= 0; i--) {
			if (time % cores[i] == 0) {
				if (m == 0) {
					answer = i + 1;
					break;
				}
				m--;
			}
		}

		return answer;
	}

	private static int calculate(int time, int[] cores) {

		if (time == 0) { // 시간이 0일 때, 처리할 수 있는 작업량은 코어의 개수
			return cores.length;
		}

		int count = cores.length; // 시간이 0일 때, 처리한 작업량

		for (int i = 0; i < cores.length; i++) { // time까지 코어가 처리할 수 있는 작업량 합산
			count += (time / cores[i]);
		}

		return count;
	}

}
