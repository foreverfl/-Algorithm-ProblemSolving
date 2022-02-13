package BOJ_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_07785_APersonWhoIsInCompany {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashSet<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();

			if (log.equals("enter"))
				set.add(name);
			if (log.equals("leave")) {
				if (set.contains(name))
					set.remove(name);
			}
		}

		List<String> list = new ArrayList<>();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext())
			list.add(iterator.next());

		Collections.sort(list, Collections.reverseOrder());

		for (String name : list)
			bw.write(name + "\n");

		bw.flush();

	}

}

// reference: https://lotuslee.tistory.com/110 