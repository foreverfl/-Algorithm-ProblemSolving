package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Copied_BOJ_02929_NOP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(str);

		int cnt = 0;
		while (matcher.find()) {
			if (matcher.start() == 0)
				continue;

			int idx = matcher.start() + cnt;
			int mod = idx % 4;
			if (mod != 0)
				cnt += 4 - mod;

		}

		System.out.println(cnt);

	}

}

// reference: https://github.com/PaengE/AlgorithmPractice/blob/master/BaekJoon_java/src/BOJ2929.java