package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Copied_BOJ_11478_TheNumberOfStringsWhichDifferFromEachOther {

	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		set = new HashSet<String>();

		for (int i = 0; i < str.length(); i++) {
			String tmp = "";
			for (int j = i; j < str.length(); j++) {
				tmp += str.substring(j, j + 1);
				set.add(tmp);
			}
		}

		System.out.println(set.size());
	}
}

// reference:https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11478%EB%B2%88-%EC%84%9C%EB%A1%9C-%EB%8B%A4%EB%A5%B8-%EB%B6%80%EB%B6%84-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%98-%EA%B0%9C%EC%88%98-%EC%9E%90%EB%B0%94Java