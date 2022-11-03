package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09342_Chromosome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();

			if (str.matches("^(A|B|C|D|E|F)?A+F+C+(A|B|C|D|E|F)?$"))
				sb.append("Infected!").append('\n');
			else
				sb.append("Good").append('\n');
		}

		System.out.println(sb.toString());
	}

}
