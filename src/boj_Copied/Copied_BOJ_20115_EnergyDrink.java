package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_20115_EnergyDrink {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());

		int arr[] = new int[size];
		int max = -1;
		double sum = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < size; i++) {
			int bottleSize = Integer.parseInt(st.nextToken());
			max = Math.max(max, bottleSize);
			arr[i] = bottleSize;
		}

		for (int now : arr) {
			if (max != now)
				sum += (double) now / 2;
		}
		sum += max;
		System.out.print(sum);
	}

}

// reference: https://c-king.tistory.com/254
