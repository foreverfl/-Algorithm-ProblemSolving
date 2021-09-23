package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_615 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String arr1[] = str.split(" ");
		str = br.readLine();
		String arr2[] = str.split(" ");
		int result1 = (Integer.parseInt(arr1[1]) + Integer.parseInt(arr2[1])) / 2;
		int result2 = (Integer.parseInt(arr1[2]) + Integer.parseInt(arr2[2])) / 2;
		System.out.println(arr1[0] + " " + arr1[1] + " " + arr1[2]);
		System.out.println(arr2[0] + " " + arr2[1] + " " + arr2[2]);
		System.out.println("avg " + result1 + " " + result2);

	}

}
