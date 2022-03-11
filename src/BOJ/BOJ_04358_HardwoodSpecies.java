package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class BOJ_04358_HardwoodSpecies {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		HashMap<String, Double> trees = new HashMap<>();

		double total = 0;
		String str = "";
		while ((str = br.readLine()) != null) {

			total++;

			if (!trees.containsKey(str)) {
				trees.put(str, 1.0);
			} else {
				trees.put(str, trees.get(str) + 1.0);
			}
		}

		List<String> list = new ArrayList<>();

		for (Entry<String, Double> entrySet : trees.entrySet()) {
			String key = entrySet.getKey();
			double value = entrySet.getValue();
			double result = value / total * 100;
			String result_final = String.format("%.4f", result);
			list.add(key + " " + result_final);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}

		System.out.println(sb.toString());

	}

}
