package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01145_MultiplesOfMostNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long[] arr = new long[5];
		long repeat = 1; // maximum
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			repeat *= arr[i];
		}
		
		Arrays.sort(arr);

		int cnt = 0;
		long result = 0;
		
		Loop: for (long i = arr[0]; i < repeat; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % arr[j] == 0) {
					cnt++;
					if (cnt == 3) {
						result = i;
						break Loop;
					}
				}
			}
			cnt = 0;
		}
		System.out.println(result);

	}

}
