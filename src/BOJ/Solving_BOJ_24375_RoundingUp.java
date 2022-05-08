package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solving_BOJ_24375_RoundingUp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		String S = "";
		String L = "";
		if(A.length() >= B.length()) {
			L = A;
			S = B;
		} else {
			L = B;
			S = A;
		}
		
		char[] S_arr = S.toCharArray();
		char[] L_arr = L.toCharArray();

		List<Character> list = new ArrayList<>();

		for (int i = 0; i < S_arr.length; i++) {
			for (int j = 0; j < L_arr.length; j++) {
				if (S_arr[i] == L_arr[j] && S_arr[i] != '0') {
					list.add(S_arr[i]);
					S_arr[i] = '0';
					L_arr[i] = '0';
				}
			}
		}

		Collections.sort(list);

		String result = "";

		for (int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}

		System.out.println(result);

	}

}
