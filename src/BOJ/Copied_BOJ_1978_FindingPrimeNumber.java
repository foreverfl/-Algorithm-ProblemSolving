package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_1978_FindingPrimeNumber {

	static boolean[] isNotPrime = new boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for (int i = 2; i <= 1000; i++) {
			if (!isNotPrime[i]) {
				erase(i);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int number = arr[i];
			if (!isNotPrime[number]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// erase the numbers excluding the 'number'.
	static void erase(int number) {
		int length = 1000 / number;
		for (int i = 2; i <= length; i++) {
			isNotPrime[number * i] = true;
		}
	}
}

// reference: https://chung-develop.tistory.com/117