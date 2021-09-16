package BOJ;

import java.util.Scanner;

public class _11726 {

	static public void main(String args[]) {
		// the Fibonacci sequence
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int arr[] = new int[n + 1];

		arr[0] = 1;
		arr[1] = 1;

		if (n >= 2) {
			for (int i = 2; i <= n; i++) {
				arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
			}
		}
		System.out.println(arr[n]);
	}
}