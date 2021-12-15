package BOJ_incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class _2750_ArrangingNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		TreeSet<Integer> treeset = new TreeSet<Integer>();
		for (int i = 0; i < num; i++) {
			treeset.add(Integer.parseInt(br.readLine()));
		}

		Iterator<Integer> iterator = treeset.iterator();
		while (iterator.hasNext()) {
			int element = iterator.next();
			System.out.println(element);
		}

	}

}
