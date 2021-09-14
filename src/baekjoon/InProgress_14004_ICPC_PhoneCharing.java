package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InProgress_14004_ICPC_PhoneCharing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String arr[] = str.split(" ");
		int result = (Integer.parseInt(arr[2]) + Integer.parseInt(arr[3]))
				/ (Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]));
		System.out.println(result);
	}

}
