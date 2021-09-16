package BOJ;

import java.util.Scanner;

public class _1279_in_progress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int result[] = new int[6];
		int count = 0;
		boolean chkDifference = false;
		boolean chkAvg = false;
		boolean stop = false;
		sc.close();

		for (int i = 1;; i++) {
			result[0] = (int) (Math.random() * i) + 1; // 임의의 정수 뽑기
			result[1] = (int) (Math.random() * i) + 1;
			result[2] = (int) (Math.random() * i) + 1;
			result[3] = (int) (Math.random() * i) + 1;
			result[4] = (int) (Math.random() * i) + 1;
			result[5] = (int) (Math.random() * i) + 1;

			for (int j = 0; j < 7; j++) {
				if (result[j] != result[j + 1]) { // 예외처리
					chkDifference = true;
				}

			}

			if ((result[0] + result[5]) == (result[1] + result[4]) == (result[2] + result[3]) <= input) {
				chkAvg = true;
			}

			if (chkDifference == true && chkAvg == true) {
				count++;
			}
			
			if(stop) // 나가는 조건
				break;
		}

		System.out.println(count / 1000000007);

	}

}
