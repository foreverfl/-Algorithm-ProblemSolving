package BOJ_Copied;

import java.util.Arrays;
import java.util.Scanner;

public class Copied_BOJ_01744_BindingNumber {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		long result = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		result = 0;
		// 0, negative number
		for (; left < right; left += 2) {
			if (arr[left] < 1 && arr[left + 1] < 1) {
				result += arr[left] * arr[left + 1];
			} else {
				break;
			}
		}

		// positive number
		for (; right > 0; right -= 2) {
			// excludes 1
			if (arr[right] > 1 && arr[right - 1] > 1) {
				result += arr[right] * arr[right - 1];
			} else {
				break;
			}
		}
		// add remainders
		for (; right >= left; right--) {
			result += arr[right];
		}
		System.out.println(result);
	}
}
