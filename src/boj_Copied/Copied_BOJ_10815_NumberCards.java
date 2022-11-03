package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_10815_NumberCards {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int arr[];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (binarySearch(num))
				bw.write("1 ");
			else
				bw.write("0 ");
		}

		bw.close();
		br.close();
	}

	private static boolean binarySearch(int num) {
		int leftIndex = 0;
		int rightIndex = N - 1;

		while (leftIndex <= rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			int mid = arr[midIndex];

			if (num < mid)
				rightIndex = midIndex - 1;
			else if (num > mid)
				leftIndex = midIndex + 1;
			else
				return true;
		}
		return false;
	}
}


// reference: https://dragon-h.tistory.com/30