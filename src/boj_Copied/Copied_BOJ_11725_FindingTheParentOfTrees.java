package boj_Copied;

import java.util.ArrayList;
import java.util.Scanner;

public class Copied_BOJ_11725_FindingTheParentOfTrees {

	static int n;
	static ArrayList<Integer>[] list;
	static int[] parents;
	static boolean[] check;

	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		list = new ArrayList[n + 1];
		parents = new int[n + 1];
		check = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				dfs(i);
			}
		}
		for (int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}

	}

	private static void dfs(int input) {
		if (check[input]) {
			return;
		}
		check[input] = true;
		for (int i : list[input]) {
			if (!check[i]) {
				parents[i] = input; // key code
				dfs(i);
			}

		}

	}

}

// reference: https://log-laboratory.tistory.com/65