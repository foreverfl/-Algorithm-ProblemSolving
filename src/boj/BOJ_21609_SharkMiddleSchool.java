package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609_SharkMiddleSchool {

	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
	}
	
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		
	}
}
