package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Lotto {

	private static class Number implements Comparable<Number> {
		int num;
		int cnt;

		public Number() {
		}

		@Override
		public String toString() {
			return "Number [num=" + num + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Number o) {
			return this.cnt - o.cnt;
		}

	}

	private static Number[] arr = new Number[46];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\forev\\OneDrive\\바탕 화면\\numbers.txt"),
				16 * 1024);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= 45; i++) {
			arr[i] = new Number();
			arr[i].num = i;
		}

		String str;
		while ((str = br.readLine()) != null) {
			String[] tmp = str.split("\\t");
			for (int i = 0; i < tmp.length; i++) {
				int now = Integer.parseInt(tmp[i]);
				arr[now].cnt++;
			}
		}

		Arrays.sort(arr);

		sb.append("[least numbers]").append('\n');
		for (int i = 1; i <= 6; i++) {
			sb.append(arr[i].num).append(" ");
		}

		sb.append('\n').append('\n');

		sb.append("[most numbers]").append('\n');
		for (int i = 40; i <= 45; i++) {
			sb.append(arr[i].num).append(" ");
		}

		System.out.println(sb.toString());

		br.close();

	}

}
