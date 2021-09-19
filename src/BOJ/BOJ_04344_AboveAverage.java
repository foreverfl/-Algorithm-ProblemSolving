package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_04344_AboveAverage {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			String str = br.readLine();
			String arr[] = str.split(" ");
			int sum = 0;
			double avg = 0;
			int count = 0;
			double result = 0;
			for (int j = 1; j < arr.length - 1; j++) {
				sum += Integer.parseInt(arr[j]);
				avg = sum / Integer.parseInt(arr[0]);
			}
			for (int j = 1; j < arr.length - 1; j++)
				if (Integer.parseInt(arr[j]) > avg) {
					count++;
				}
			System.out.format("%.3f%%%n", count / (arr.length - 1) * 100.0);
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(count);
			System.out.println(arr.length - 1);
			System.out.println(result);

		}

	}

}
