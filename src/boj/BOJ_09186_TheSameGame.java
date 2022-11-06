package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_09186_TheSameGame {

	private static class Cluster {
		private int x;
		private int y;
		private int size;
		private char color;

		public Cluster(int x, int y, int size, char color) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.color = color;
		}

	}
	
	private static List<Cluster> clusters = new ArrayList<>();

	private static int T;
	private static List<List<Character>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			map = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				map.add(new ArrayList<>());
			}

			br.readLine();

			for (int i = 0; i < 10; i++) {
				String str = br.readLine();
				for (int j = 0; j < 15; j++) {
					map.get(i).add(str.charAt(j));
				}
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 15; j++) {
					System.out.print(map.get(i).get(j));
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	private static void findLargestCluster() {

	}

}
