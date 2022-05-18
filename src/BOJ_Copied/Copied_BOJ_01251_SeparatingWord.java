package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Copied_BOJ_01251_SeparatingWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		List<String> list = new ArrayList<>();
		String[] arr = new String[3];
		for (int i = 1; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				arr[0] = str.substring(0, i);
				arr[1] = str.substring(i, j);
				arr[2] = str.substring(j, str.length());

				StringBuilder sb = new StringBuilder();

				for (int k = 0; k < 3; k++) {
					for (int l = arr[k].length() - 1; l >= 0; l--) {
						sb.append(Character.toString(arr[k].charAt(l)));
					}
				}

				list.add(sb.toString());

				sb.setLength(0);
			}
		}

		Collections.sort(list);

		System.out.println(list.get(0));

	}
}

// reference: https://blackvill.tistory.com/80
