package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15904_WhatIsAbbreviationOfUCPC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String result = "";
		loop: for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'U') {
				result += 'U';
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(j) == 'C') {
						result += 'C';
						for (int k = j + 1; k < str.length(); k++) {
							if (str.charAt(k) == 'P') {
								result += 'P';
								for (int l = k + 1; l < str.length(); l++) {
									if (str.charAt(l) == 'C') {
										result += 'C';
										break loop;
									}
								}
							}
						}
					}
				}
			}

		}

		if (result.equals("UCPC"))
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");
	}

}
