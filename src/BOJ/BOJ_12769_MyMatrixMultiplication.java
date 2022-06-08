package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12769_MyMatrixMultiplication {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());

		sb.append("3").append('\n');
		sb.append("1 1 1 " + (K + 1));

		System.out.print(sb.toString());

	}

}
