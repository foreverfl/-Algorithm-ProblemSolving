package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Copied_BOJ_05608_Problem_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());

		HashMap<String, String> map = new HashMap<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			String str = br.readLine();
			if (map.containsKey(str))
				sb.append(map.get(str));
			else
				sb.append(str);
		}

		System.out.println(sb);
	}

}
