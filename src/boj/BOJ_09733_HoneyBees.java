package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_09733_HoneyBees {

	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> map = new HashMap<>();
		map.put("Re", 0);
		map.put("Pt", 0);
		map.put("Cc", 0);
		map.put("Ea", 0);
		map.put("Tb", 0);
		map.put("Cm", 0);
		map.put("Ex", 0);

		String str = "";
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);

			while (st.hasMoreTokens()) {
				total++;

				String activity = st.nextToken();

				if (map.containsKey(activity)) {
					map.put(activity, map.get(activity) + 1);
				}
			}
		}

		sb.append("Re ").append(map.get("Re") + " ").append(calcRatio(map.get("Re"))).append('\n');
		sb.append("Pt ").append(map.get("Pt") + " ").append(calcRatio(map.get("Pt"))).append('\n');
		sb.append("Cc ").append(map.get("Cc") + " ").append(calcRatio(map.get("Cc"))).append('\n');
		sb.append("Ea ").append(map.get("Ea") + " ").append(calcRatio(map.get("Ea"))).append('\n');
		sb.append("Tb ").append(map.get("Tb") + " ").append(calcRatio(map.get("Tb"))).append('\n');
		sb.append("Cm ").append(map.get("Cm") + " ").append(calcRatio(map.get("Cm"))).append('\n');
		sb.append("Ex ").append(map.get("Ex") + " ").append(calcRatio(map.get("Ex"))).append('\n');
		sb.append("Total ").append(total + " ").append("1.00");

		System.out.print(sb.toString());

	}

	public static String calcRatio(int num) {
		double ratio = (double) num / total;
		String res = String.format("%.2f", ratio);
		return res;
	}

}
