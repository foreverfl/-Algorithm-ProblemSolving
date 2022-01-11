package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01373_BinaryOctal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String binary = br.readLine();
		String octal = binaryToOctal(binary);
		System.out.println(octal);
	}

	private static String binaryToOctal(String binary) {
		StringBuilder sb = new StringBuilder(); // The 'String' causes memory excess.

		if (binary.length() % 3 == 1) {
			binary = "00" + binary;
		} else if (binary.length() % 3 == 2) {
			binary = "0" + binary;
		}

		String[] binary_arr = binary.split("");

		for (int i = 0; i < binary.length(); i = i + 3) {
			String temp = binary_arr[i] + binary_arr[i + 1] + binary_arr[i + 2];
			int decimal = Integer.parseInt(temp, 2);
			String octal = Integer.toOctalString(decimal);
			sb.append(octal);
		}

		return sb.toString();
	}

}
