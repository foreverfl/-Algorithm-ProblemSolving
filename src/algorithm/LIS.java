package algorithm;

import java.util.Scanner;

public class LIS {

	static int N;
	static int[] arr, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// dp에 실질적으로 저장된 원소의 길이 = LIS인 1차원 dp테이블을 만든다.
		// 해당 dp에 저장된 원소(0이 아닌 값)들은 이후 조사하는 원소들이 부분 수열을 늘릴 수 있을지에 대한 정보를 제공한다.
		dp = new int[N];
		// 처음에 저장된 원소는 없으므로, LIS = 0이다.
		int LIS = 0;

		// 첫 번째 원소부터 N번째 원소까지 dp 테이블의 값을 채워 나간다.
		for (int i = 0; i < N; i++) {
			// 이분 탐색을 활용하여 dp테이블에 저장된 원소를 탐색하며 현재 선택된 숫자가 dp테이블의 어떤 위치에 포함될지 파악한다.
			int idx = BinarySearch(arr[i], 0, LIS, LIS + 1);

			// 찾지 못한 경우
			if (idx == -1) {
				// 가장 마지막 위치에 원소를 삽입하고 LIS의 길이를 늘린다.
				dp[LIS++] = arr[i];
			}
			// 찾은 경우
			else {
				// 해당 위치에 현재 값을 삽입하여 갱신한다.
				dp[idx] = arr[i];
			}
		}

		// LIS의 길이를 출력한다.
		System.out.println(LIS);

		sc.close();
	}

	private static int BinarySearch(int num, int start, int end, int size) {
		int res = 0;
		while (start <= end) {
			// 중앙 값을 찾는다.
			int mid = (start + end) / 2;

			// 만일 현재 선택된 원소가 해당 원소보다 작거나 같다면, 앞 부분을 탐색한다.
			if (num <= dp[mid]) {
				// 해당 원소의 위치를 기억해둔다.
				res = mid;
				end = mid - 1;
			}
			// 만일 현재 선택된 원소가 해당 원소보다 크다면, 뒷 부분을 탐색한다.
			else {
				start = mid + 1;
			}
		}

		// dp테이블에서 삽입될 위치를 찾지 못한 경우(즉, 모든 수들보다 큰 경우).
		if (start == size) {
			return -1;
		}
		// dp테이블에서 삽입될 위치를 찾은 경우.
		else {
			return res;
		}
	}
}
