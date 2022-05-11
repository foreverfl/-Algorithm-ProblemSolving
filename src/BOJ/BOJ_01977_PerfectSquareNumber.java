package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_01977_PerfectSquareNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		
		for (int i = N; i <= M; i++) {
			double tmp = Math.sqrt(i);
			if (tmp % 1.0 == 0)
				list.add(i);
		}
		
		if(list.isEmpty()) {
			System.out.println("-1");
			System.exit(0);
		}
		
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
		System.out.println(list.get(0));
		
	}

}
