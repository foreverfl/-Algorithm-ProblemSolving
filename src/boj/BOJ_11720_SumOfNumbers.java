package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720_SumOfNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int sum = 0;
		String arr[] = new String[count];
		
		String str = br.readLine();
		arr = str.split("");
		for (int i = 0; i < count; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println(sum);

	}

}
