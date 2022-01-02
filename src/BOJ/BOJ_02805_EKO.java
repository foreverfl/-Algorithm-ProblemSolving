package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02805_EKO {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int arr[];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
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