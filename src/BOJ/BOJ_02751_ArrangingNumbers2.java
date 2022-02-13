package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_02751_ArrangingNumbers2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		ArrayList<Integer> arraylist = new ArrayList<>();

		for (int i = 0; i < T; i++) {
			Integer input = Integer.parseInt(br.readLine());
			arraylist.add(input);
		}

		Collections.sort(arraylist);

		for (int i = 0; i < T; i++) {
			bw.write(arraylist.get(i) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

}
