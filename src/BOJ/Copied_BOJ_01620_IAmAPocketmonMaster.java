package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Copied_BOJ_01620_IAmAPocketmonMaster {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		String[] nameArr = new String[N];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			nameMap.put(name, i + 1);
			nameArr[i] = name;
		}

		while (M-- > 0) {
			String findStr = br.readLine();
			if (isStringNumber(findStr)) {
				int index = Integer.parseInt(findStr);
				sb.append(nameArr[index - 1]);
			} else {
				sb.append(nameMap.get(findStr));
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	public static boolean isStringNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

// reference: https://maivve.tistory.com/140
