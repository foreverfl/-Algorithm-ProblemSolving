package BOJ_incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10818_MinimumAndMaximum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		String str = br.readLine();
		String arr[] = str.split(" ");
		int max = -1000000;
		int min = 1000000;
		for (int i = 0; i < num; i++) {
			if (Integer.parseInt(arr[i]) > max) {
				max = Integer.parseInt(arr[i]);
			}
			
			if(Integer.parseInt(arr[i]) < min) {
				min = Integer.parseInt(arr[i]);
			}
		}
		System.out.println(min + " " + max);
	}

}
