package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_02576_OddNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> list = new ArrayList<>();
		int repeat = 7;
		while (repeat-- > 0) {
			int input = Integer.parseInt(br.readLine());

			if (input % 2 == 1)
				list.add(input);
		}

		if (list.isEmpty())
			System.out.println("-1");
		else {
			
			Collections.sort(list);

			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}

			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}

}
